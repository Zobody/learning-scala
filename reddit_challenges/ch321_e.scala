
val hoursEnglish: List[String] = List("twelve", "one", "two", "three", "four", "five", "six", "seven", "eigth", "nine", "ten", "eleven")
val minutesTensEnglish: List[String] = List("oh", "???", "twenty", "thirty", "forty", "fifty") // minutesTensEnglish(1) is invalid 
val minutesOnesEnglish: List[String] = List("", "one", "two", "three", "four", "five", "six", "seven", "eigth", "nine", "ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

def timeToText(input: String) : String = {

	val hourPart: String = input.substring(0,2)
	val minutesPart: String = input.substring(3,5)

	val hoursInt: Int = hourPart.toInt
	val minutesInt: Int = minutesPart.toInt
	val minutesTens: Int = minutesPart.charAt(0).toInt - '0'.toInt
	val minutesOnes: Int = minutesPart.charAt(1).toInt - '0'.toInt

	val meridiem: String = if (hoursInt >= 12) "pm" else "am"

	val outputHourPart: String = hoursEnglish(hoursInt % 12)

	val outputMinutePart: String = {
		if (minutesTens != 1 && minutesInt != 0) {
			minutesTensEnglish(minutesTens) + " " + minutesOnesEnglish(minutesOnes)
		} else {
			minutesOnesEnglish(minutesInt)
		}
	}

	val output: String = {
		String.join(" ", "It's", outputHourPart, outputMinutePart, meridiem)
		// "It's " + outputHourPart + " " + outputMinutePart + " " + meridiem 
	}

	// temp
	println(hourPart + " | " + minutesPart) 
	println(minutesInt)
	println(minutesTens + " | " + minutesOnes)
	println(meridiem)
	println(outputMinutePart)
	println(outputHourPart)
	output
}

println(timeToText(args(0)))