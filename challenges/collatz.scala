import scala.collection.mutable.Map

object Collatz extends App {
	var cache = Map(1 -> 4, 4 -> 1)

	def factorize(x: Int): List[Int] = {
		def foo(x: Int, a: Int): List[Int] = if (a * a > x) List(x) else
			x % a match {
			  case 0 => a :: foo(x / a, a)
			  case _ => foo(x, a + 1)
			}
			foo(x, 2)
	}

	def step(num: Int): Int = {
		if (cache contains num) cache(num) else {
		val returnValue = if (num % 2 == 0) step(num / 2) else divOutTwos(3*num+1)
		cache += (num -> returnValue)
		returnValue
		}
	}

	def divOutTwos(num: Int): Int = {
		if (num % 2 == 0) divOutTwos(num/2) else num
	}

	for (n <- 1 to args(0).toInt) {
		var num = n.toInt
		var steps = 0
		while (num > 4) {
			num = step(num)
			steps += 1
			println(num + ": " + factorize(num).filter(_ != 2).toArray.mkString(" "))
		}
		println()
		println("STEPS: " + steps)
		println()
	}	
}