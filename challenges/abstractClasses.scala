
object ClassTest extends App{
	abstract class Animal {
		def sound: String

		def makeSounds(a: Int): String
	}

	class Dog extends Animal {
		val sound = "Woof!"

		def makeSounds(count: Int): String = {
			sound*count
		}
	}

	val laika = new Dog
	println(laika.makeSounds(3))
}