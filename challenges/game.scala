import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object GameTest extends App {

	class Universe(val field: List[Creature]) {

		def update(input: String): Universe = {
			this
		}

		def output(outputUniverse: Universe): Unit = {

		}

		def init(): Universe = {
			
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

	def receiveInput(): String = scala.io.StdIn.readLine()

	def mainLoop(inputUniverse: Universe): Universe = {
		val userInput = receiveInput()
		val outputUniverse = inputUniverse.update(userInput)
		outputUniverse.output
		outputUniverse
	}


}

