import scala.math.{pow}
import java.lang.StackOverflowError

object UpArrow {

	def main(args: Array[String]) {
		val base: Int = args(0).toInt
		val arrowCount: Int = args(1).length
		val exponent: Int = args(2).toInt

		// println("Base: " + base + ". Arrow count: " + arrowCount + ". Exponent: " + exponent)
		try {
			println(evaluate(base, arrowCount, exponent))
		}
		catch {
			case java.lang.StackOverflowError => {
				println(cache)
			}
		}
	}

	val cache: collection.mutable.Map[List[Int],Int] = collection.mutable.Map[List[Int],Int]()

	def getCached(numList: List[Int]): Int = {
		cache get numList match {
			case Some(result) => result
			case None => {
				0
			}
		}
	}

	def evaluate(base: Int, arrowCount: Int, exponent: Int) : Int = {
		if (arrowCount == 1) pow(base, exponent).toInt
		else if (cache contains List(base, arrowCount, exponent)) {
			getCached(List(base, arrowCount, exponent))
		}
		else {
			val result = evaluate(base, arrowCount - 1, evaluate(base, arrowCount, exponent - 1))
			cache += (List(base, arrowCount, exponent) -> result)
			result
		}
	}
}
