
var more = 1
val addMore = (x: Int) => x + more
println(
	addMore(10)
)


more = 9999
println(
	addMore(10)
)


val someNumbers = List(-11, -10, -5, 0, 5, 10)
var sum = 0
someNumbers.foreach(sum += _)
println(
	sum
)

def makeIncreaser(more: Int) = (x: Int) => x + more

val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)

println(
	inc1(10)
)
println(
	inc9999(10)
)
