
/*
	This is my self defined challenge.

	This program will take in input with either 0s and 1s, or As and Bs, and return input + !input
*/

object ThueMorse {

	def main(input: Array[String]) {
		val string = compute(
			input(0),
			input(1).toInt
		)
		println(string)
	}

	def invert(input: String) : String = input map (s => {if (s == 'A') 'B' else 'A'})

	def compute(input: String, times: Int): String = {
		if (times == 0) input
		else compute(input + invert(input), times - 1)
	}

}