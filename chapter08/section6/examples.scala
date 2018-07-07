
val someNumbers = List(-11, -10, -5, 0, 5, 10)

someNumbers.foreach(println _) // This passes all of the arguments
// In this case it is same as:
// someNumbers.foreach(x => println(x))

def sum(a: Int, b: Int, c: Int) = a + b + c

sum(1, 2, 3)

// Printing...
println(
	sum(1, 2, 3)
)

val a = sum _

a(1, 2, 3)

// Printing...
println(
	a(1, 2, 3)
)

val b = sum(1, _: Int, 3)

b(2)

// Printing...
println(
	b(2)
)

b(5)

// Printing...
println(
	b(5)
)


someNumbers.foreach(println) // We can leave off _, if we write a partially applied function expression where we leave off all of the parameters

// But...

/*
val c = sum // underscore left out, we get an error
*/

val d = sum _

d(10,20,30)

// Printing...
println(
	d(10,20,30)
)

