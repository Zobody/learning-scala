package bobsdelights {

	abstract class Fruit(
		val name: String,
		val color: String
	)

	object Fruits {
		object Apple extends Fruit("apple", "red")
		object Orange extends Fruit("orange", "orange")
		object Pear extends Fruit("pear", "green")
		val menu = List(Apple, Orange, Pear)
	}

}

package object bobsdelights {
	def showFruit(fruit: Fruit) {
		import fruit._
		println(name + "s are " + color + " and very delicious")
	}
}



package somethingAboutRegex {

	import java.util.regex // package names can also be imported, so instead of using java.util.regex each time, regex may be used

	class AStarB {
		val pat = regex.Pattern.compile("a*b")
	}

}