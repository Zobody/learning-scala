
/*
	This is my self defined challenge.

	This program will take in input with either 0s and 1s, or As and Bs, and return input + !input
*/

object ThueMorse {

	def main(input: Array[String]) {
		var string = input(0)
		for (i <- 0 until input(1).toInt) {
			string = string + invert(string)
		}
		println(string)
	}

	def invert(input: String) : String = input.map(s => {if (s == 'A') 'B' else 'A'})

}