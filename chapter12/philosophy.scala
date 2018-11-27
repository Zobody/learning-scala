trait Philosophical {
	def philosophize() {
		println("I consume memory, there I am!")
	}
}

class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {
	override def toString = "green"
}