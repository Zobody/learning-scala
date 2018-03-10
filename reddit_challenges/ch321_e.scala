

def timeToText(input: String) : String = {

	val hourPart: String = input.substring(0,2)
	val minutesPart: String = input.substring(3,5)

	val hoursInt: Int = hourPart.toInt
	val minutesTens: Int = minutesPart.charAt(0).toInt - '0'.toInt
	val minutesOnes: Int = minutesPart.charAt(1).toInt - '0'.toInt


	// temp
	println(hourPart + " | " + minutesPart) 
	println(minutesTens + " | " + minutesOnes)
	"WARNING"
}

println(timeToText(args(0)))