object GameTest2 {

	abstract class Creature {

		def health: Int
		def offense: Int
		def defense: Int

		def receiveDamage: Int => Creature
		def directDamage: Int => Creature

		def attack: Creature => Creature

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
}