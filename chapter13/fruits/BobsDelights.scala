package bobsdelights

abstract class Fruit(
	val name: String,
	val color: String
)

object Fruits {
	object Apple extends Fruit("apple", "red") with Showable
	object Orange extends Fruit("orange", "orange") with Showable
	object Pear extends Fruit("pear", "green") with Showable
	val manu = List(Apple, Orange, Pear)
}

trait Showable { // this is THE BIGGEST MESS POSSIBLE
	def showFruit(fruit: Fruit) {
		import fruit._
		println(name + "s are " + color)
	}
}

import java.util.regex // package names can also be imported, so instead of using java.util.regex each time, regex may be used

class AStarB {
	val pat = regex.Pattern.compile("a*b")
}