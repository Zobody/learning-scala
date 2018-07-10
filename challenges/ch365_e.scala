import scala.math.{pow}

object UpArrow {

	def main(args: Array[String]) {
		val base: Int = args(0).toInt
		val arrowCount: Int = args(1).length
		val exponent: Int = args(2).toInt

		// println("Base: " + base + ". Arrow count: " + arrowCount + ". Exponent: " + exponent)

		println(evaluate(base, arrowCount, exponent))
	}

	def evaluate(base: Int, arrowCount: Int, exponent: Int) : Int = {
		if (arrowCount == 1) pow(base, exponent).toInt
		else {
			evaluate(base, arrowCount - 1, evaluate(base, arrowCount, exponent - 1))
		}
	}
}
