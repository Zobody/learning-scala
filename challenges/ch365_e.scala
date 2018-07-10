

object UpArrow {

	def main(args: Array[String]) {
		val base: Int = args(0).toInt
		val arrowCount: Int = args(1).length
		val exponent: Int = args(2).toInt

		println("Base: " + base + ". Arrow count: " + arrowCount + ". Exponent: " + exponent)
	}
}