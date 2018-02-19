
// Rewriting stuff from previous section
var increase = (x: Int) => x + 1
increase(10)
increase = (x: Int) => x + 9999
increase(10)
increase = (x: Int) => {
	println("We")
	println("are")
	println("here!")
	x + 1
}
increase(10)
val someNumbers = List(-11, -10, -5, 0, 5, 10)
someNumbers.foreach((x: Int) => println(x))
someNumbers.filter((x: Int) => x > 0)

// Actual section 4

someNumbers.filter((x) => x > 0)
someNumbers.filter(x => x > 0)

// Putting these in println()

println(someNumbers.filter((x) => x > 0))
println(someNumbers.filter(x => x > 0))