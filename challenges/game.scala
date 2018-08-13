import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object GameTest extends App {

	class Universe(val field: List[Creature], state: String) {

		def update(input: String): Universe = {
			this
		}

		def output(outputUniverse: Universe): Unit = {

			if (outputUniverse.state == "REGULAR") {
				println("-"*15)
				println()
				println("On the field, currently there are: ")

				for (creature <- field) {
					val name = if (creature.isInstanceOf[Player]) "Player" else creature.name
					val index = field.indexOf(creature)
					println("[" + index + "] "  name + "with the following stats: HP: " + creature.health + ", ATK: " + creature.attack + ", DEF: " + creature.defense)
				}

				println()
				println("-"*15)
				println("You can do one of these things: attack <N>, rest")
				print("> ")
			} else if (outputUniverse.state == "BATTLE") {
				println("-"*15)
				println()
				println("You deal " + field.head.attack + " damage to ")
			}

			

		}

		abstract class Creature(val health: Int, val attack: Int, val defense: Int) {

			def receiveDamage: Int => Creature
			def directDamage: Int => Creature

			def attack: Creature => Creature

			def isDead: Boolean = health <= 0
		}

		class Player(val health: Int, val attack: Int, val defense: Int) extends Creature(health, attack, defense) {
			def attack(that: Creature): Creature = {
				that.receiveDamage(this.attack)
			}

			def receiveDamage(damage: Int): Player = {
				val newDefense = if (defense > damage) defense - damage else 0
				val newHealth = if (damage > defense) health - (damage - defense) else health

				Player(newHealth, attack, newDefense)
			}

			def directDamage(damage: Int): Player = {
				val newHealth = health - damage

				Player(newHealth, attack, defense)
			}
		}

		abstract class Monster(val health: Int, val attack: Int, val defense: Int, val name: String) extends Creature(health, attack, defense) {
			def receiveDamage(damage: Int): Monster = {
				val newDefense = if (defense > damage) defense - damage else 0
				val newHealth = if (damage > defense) health - (damage - defense) else health

				Monster(newHealth, attack, newDefense, name)
			}

			def directDamage(damage: Int): Monster = {
				val newHealth = health - damage

				Monster(newHealth, attack, defense, name)
			}
		}

		class RegularMonster(val health: Int, val attack: Int, val defense: Int, val name: String) extends Monster(health, attack, defense, name) {
			def attack(that: Creature): Creature = {
				that.receiveDamage(this.attack)
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
		outputUniverse.output
		outputUniverse
	}


}

