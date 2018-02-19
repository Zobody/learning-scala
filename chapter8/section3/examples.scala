
var increase = (x: Int) => x + 1
println(increase(10)) // Prints 11\n

increase = (x: Int) => x + 9999
println(increase(10)) // Prints 10009\n

increase = (x: Int) => {
	println("We")
	println("are")
	println("here!")
	x + 1
}
println(increase(10)) // Prints: We\nare\nhere!\n11

val someNumbers = List(-11, -10, -5, 0, 5, 10)
someNumbers.foreach((x: Int) => println(x)) // Prints -11\n-10\n-5\n0\n5\n10\n

val someNumbersFiltered = someNumbers.filter((x: Int) => x > 0)
println(someNumbersFiltered) // Prints List(5,10)\n