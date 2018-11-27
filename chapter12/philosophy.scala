trait Philosophical {
	def philosophize() {
		println("I consume memory, there I am!")
	}
}

class Frog extends Philosophical {
	override def toString = "green"
}