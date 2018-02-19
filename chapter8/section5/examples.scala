
val someNumbers = List(-11, -10, -5, 0, 5, 10)

someNumbers.filter(_ > 0)

someNumbers.filter(x => x > 0)
/*
val f = _ + _ // Does not compile
*/
val f = (_: Int) + (_: Int)

f(5,10)

// Now printing

println(someNumbers.filter(_ > 0))
println(someNumbers.filter(x => x > 0))
println(f(5,10))