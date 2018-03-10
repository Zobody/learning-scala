
def timeToText(input: String) : String = {
	val hourPart: String = input.substring(0,2)
	val minutesPart: String = input.substring(3,5)

	println(hourPart + " | " + minutesPart)

	"WARNING"
}

println(timeToText(args(0)))