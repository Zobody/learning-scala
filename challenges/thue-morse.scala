
/*
	This is my self defined challenge.

	This program will take in input with either 0s and 1s, or As and Bs, and return input + !input
*/

object ThueMorse {

	def main(input: Array[String]) {
		val numbers = input(0)(0) == '0' || input(0)(0) == '1'
		val times = if (input.length == 1) 1 else input(1).toInt

		val mappingToLetters = Map('0' -> 'A', '1' -> 'B', 'A' -> 'A', 'B' -> 'B')
		val mappingToNumbers = Map('A' -> '0', 'B' -> '1')

		val processedInput = process(input(0) map (_.toUpper), mappingToLetters)

		val output = compute(
			processedInput,
			times
		)

		val processedOutput = if (numbers) process(output, mappingToNumbers) else output

		println(processedOutput)
	}

	def invert(input: String) : String = input map (c => {if (c == 'A') 'B' else 'A'})

	def compute(input: String, times: Int): String = {
		if (times == 0) input
		else compute(input + invert(input), times - 1)
	}

	def process(input: String, mapping: Map[Char, Char]) : String = input map (c => {mapping(c)})

}