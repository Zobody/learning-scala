import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

abstract class Creature {

	def health: Int
	def offense: Int
	def defense: Int

	def receiveDamage(damage: Int): Creature
	def directDamage(damage: Int):  Creature

	def attack(that: Creature): Creature // Always, without exceptions, returns the target after the attack

	def isDead: Boolean = health <= 0
}

class Player(val health: Int, val offense: Int, val defense: Int) extends Creature {
	def attack(that: Creature): Creature = {
		that.receiveDamage(this.offense)
	}

	def receiveDamage(damage: Int): Creature = {
		val newDefense = if (defense > damage) defense - damage else 0
		val newHealth = if (damage > defense) health - (damage - defense) else health

		new Player(newHealth, offense, newDefense)
	}

	def directDamage(damage: Int): Creature = {
		val newHealth = health - damage

		new Player(newHealth, offense, defense)
	}
}

abstract class Monster extends Creature {
	def name: String
}

class RegularMonster(val health: Int, val offense: Int, val defense: Int, val name: String) extends Monster {
	def attack(that: Creature): Creature = {
		that.receiveDamage(this.offense)
	}

	def receiveDamage(damage: Int): Creature = {
		val newDefense = if (defense > damage) defense - damage else 0
		val newHealth = if (damage > defense) health - (damage - defense) else health

		new RegularMonster(newHealth, offense, newDefense, name)
	}

	def directDamage(damage: Int): Creature = {
		val newHealth = health - damage

		new RegularMonster(newHealth, offense, defense, name)
	}
}

class State(val name: String, val target: Creature) {

	require(this.isValidState)

	override def toString: String = name
	
	def isValidState: Boolean = State.validStates.contains(this.toString)

	def this(stateName: String) {
		this(stateName, State.placeholderCreature)
	}
}

object State {
	private val placeholderCreature = new Player(1,1,1)
	private val validStates = List("REGUALR", "GAMEOVER", "BATTLE")
}

class Universe(val field: List[Creature], val state: State) {

	def update(input: String): Universe = {
		val inputArgs: Array[String] = input.split(" ")
		
		state.toString match {
			case "REGULAR" => {
				inputArgs(0).toLowerCase match {
					case "attack" => {
						/*
						val target = inputArgs(1).toInt
						// field.head.attack(field(target))
						val fieldAfterAttack = field map (creature => {
							if (creature == field.head) creature.attack(field(target)) else if (field.indexOf(creature) == target) creature.attack(field.head) else creature
						})

						val nonDeadField = fieldAfterAttack.filter(creature => !creature.isDead)
						// if (fieldAfterAttack.head.isDead) "GAMEOVER" else if (nonDeadField.length < fieldAfterAttack.length) "REGULAR" else "BATTLE"
						val newState = {
							if (fieldAfterAttack.head.isDead) {
								new State("GAMEOVER")
							} else if (nonDeadField.length < fieldAfterAttack.length) {
								new State("REGULAR")
							} else {
								new State("BATTLE", nonDeadField(target))
							}
						} 

						new Universe(nonDeadField, newState)
						*/

						val targetCreature = field(inputArgs(1).toInt)
						val newUniverse = newUniverse(this.field, new State("Battle", targetCreature))
						newUniverse.update("attack")
					}
					case _ => this // If it is an invalid command, we just repeat exact same thing
				}
			}
			case "BATTLE" => {
				inputArgs(0).toLowerCase match {
					case "attack" => {
						val fieldAfterAttack = field map (creature => {
							if (creature == field.head) {
								creature.attack(state.target)
							} else if (creature == state.target) {
								creature.attack(field.head)
							} else {
								creature
							}
						})

						val nonDeadField = fieldAfterAttack.filter(creature => !creature.isDead)

						val newState = {
							if (fieldAfterAttack.head.isDead) {
								new State("GAMEOVER")
							} else if (nonDeadField.length < fieldAfterAttack.length) {
								new State("REGULAR")
							} else {
								new State("BATTLE", field.head.attack(state.target))
							}
						}

						new Universe(nonDeadField, newState)
					}
				}

			}
			case _ => this // if it is an invalid state, game is effectively dead, as it will constantly just loop. This cannot happen though, as State requires the game to be in a valid state.
		}
	}

	def output(): Unit = {
	}
}

object GameTest extends App {

	def init(): Universe = {
		val player = new Player(10, 2, 5)
		val monster1 = new RegularMonster(3, 5, 0, "Wispboy")
		val monster2 = new RegularMonster(5, 1, 5, "Nightbody")
		val monster3 = new RegularMonster(3, 1, 3, "Dawnbody")

		new Universe(List(player, monster1, monster2, monster3), new State("REGULAR"))
	}

	def receiveInput(): String = scala.io.StdIn.readLine()

	def mainLoop(inputUniverse: Universe): Universe = {
		val userInput = receiveInput()
		val outputUniverse = inputUniverse.update(userInput)
		outputUniverse.output()
		outputUniverse
	}


}

