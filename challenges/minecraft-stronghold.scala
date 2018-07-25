
import scala.math

object StrongholdFinder {
	def main(args: Array[String]) {
		val x0 = args(0).toFloat
		val y0 = args(1).toFloat
		val t0 = args(2).toDouble.toDegrees.toFloat

		val x1 = args(3).toFloat
		val y1 = args(4).toFloat
		val t1 = args(5).toDouble.toDegrees.toFloat

		val finalPoint: List[Float] = fullCalculation(List(x0, y0, t0), List(x1, y1, y1)))

		println("x: " + finalPoint(0) + "\ny: " + finalPoint(1))
	}

	def fullCalculation(firstReading: List[Float], secondReading: List[Float]): List[Float] = {
		getIntersectionPoint(
			getSlope(firstReading(2)),
			getB(firstReading(2), firstReading(0), firstReading(1)),
			getSlope(secondReading(2)),
			getB(secondReading(2), secondReading(0), secondReading(1))
		)
	}

	def getSlope(angle: Float): Float = {
		tan(angle)
	}

	def getB(angle: Float, x: Float, y: Float): Float = {
		y - getSlope(angle)*x
	}

	def getIntersectionPoint(a0: Float, b0: Float, a1: Float, b1: Float): List[Float] = {
		val x = (b1 - b0)/(a0-a1)
		val y = a0*x+b0
		List(x, y)
	}
}