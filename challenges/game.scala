import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object GameTest extends App {

	class Universe(val field: List[Creature]) {

		def update(input: String): Universe = {
			this
		}

		def output(outputUniverse: Universe): Unit = {

		}

		abstract class Creature(val health: Int, val attack: Int, val defense: Int) {

			def receiveDamage(damage: Int): Creature = {
				val newDefense = if (defense > damage) defense - damage else 0
				val newHealth = if (damage > defense) health - (damage - defense) else health

				Creature(newHealth, attack, newDefense)
			}

			def directDamage(damage: Int): Creature = {
				val newHealth = health - damage

				Creature(newHealth, attack, defense)
			}

			def attack: Creature => Creature
		}

		class Player(val health: Int, val attack: Int, val defense: Int) extends Creature(health, attack, defense) {
			def attack(that: Creature): Creature = {
				that.receiveDamage(this.attack)
			}
		}

		abstract class Monster(val health: Int, val attack: Int, val defense: Int, val name: String) extends Creature(health, attack, defense) 

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

		new Universe(List(player, monster1, monster2, monster3))
	}

	def receiveInput(): String = scala.io.StdIn.readLine()

	def mainLoop(inputUniverse: Universe): Universe = {
		val userInput = receiveInput()
		val outputUniverse = inputUniverse.update(userInput)
		outputUniverse.output
		outputUniverse
	}


}

