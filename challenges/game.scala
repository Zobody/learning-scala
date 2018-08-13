import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object GameTest extends App {

	abstract class Creature(val health: Int, val offense: Int, val defense: Int) {

		def receiveDamage: Int => Creature
		def directDamage: Int => Creature

		def attack: Creature => Creature

		def isDead: Boolean = health <= 0
	}

	class Player(override val health: Int, override val offense: Int, override val defense: Int) extends Creature(health, offense, defense) {
		def attack(that: Creature): Creature = {
			that.receiveDamage(this.offense)
		}

		def receiveDamage(damage: Int): Player = {
			val newDefense = if (defense > damage) defense - damage else 0
			val newHealth = if (damage > defense) health - (damage - defense) else health

			new Player(newHealth, offense, newDefense)
		}

		def directDamage(damage: Int): Player = {
			val newHealth = health - damage

			new Player(newHealth, offense, defense)
		}
	}

	abstract class Monster(override val health: Int, override val offense: Int, override val defense: Int, override val name: String) extends Creature(health, offense, defense)

	class RegularMonster( override val health: Int, override val offense: Int, override val defense: Int, override val name: String) extends Monster(health, offense, defense, name) {
		def attack(that: Creature): Creature = {
			that.receiveDamage(this.offense)
		}

		def receiveDamage(damage: Int): RegularMonster = {
			val newDefense = if (defense > damage) defense - damage else 0
			val newHealth = if (damage > defense) health - (damage - defense) else health

			new RegularMonster(newHealth, offense, newDefense, name)
		}

		def directDamage(damage: Int): RegularMonster = {
			val newHealth = health - damage

			new RegularMonster(newHealth, offense, defense, name)
		}
	}

	class Universe(val field: List[Creature], state: String) {

		def update(input: String): Universe = {
			this
		}

		def output(): Unit = {

			if (state == "REGULAR") {
				println("-"*15)
				println()
				println("On the field, currently there are: ")

				for (creature <- field) {
					val name = creature match {
						case m: Monster => creature.asInstanceOf[Monster].name
						case p: Player => "Player"
						case _ => "BAD_DATA"
					}
					val index: String = (field.indexOf(creature)).toString
					println("[" + index + "] " + name + "with the following stats: HP: " + creature.health + ", ATK: " + creature.attack + ", DEF: " + creature.defense)
				}

				println()
				println("-"*15)
				println("You can do one of these things: attack <N>, rest")
				print("> ")
			} else if (state == "BATTLE") {
				println("-"*15)
				println()
				println("You deal " + field.head.attack + " damage to ")
			}

			

		}

		
	}

	def init(): Universe = {
		val player = new Player(10, 2, 5)
		val monster1 = new RegularMonster(3, 5, 0, "Wispboy")
		val monster2 = new RegularMonster(5, 1, 5, "Nightbody")
		val monster3 = new RegularMonster(3, 1, 3, "Dawnbody")

		new Universe(List(player, monster1, monster2, monster3), "REGULAR")
	}

	def receiveInput(): String = scala.io.StdIn.readLine()

	def mainLoop(inputUniverse: Universe): Universe = {
		val userInput = receiveInput()
		val outputUniverse = inputUniverse.update(userInput)
		outputUniverse.output()
		outputUniverse
	}


}

