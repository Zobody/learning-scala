
// Listing 9.3 : Defining and invoking a curried function

def curriedSum(x: Int)(y: Int) = x + y

println(
	curriedSum(1)(2)
)

// Explanation(Illiustration)

def first(x: Int) = (y: Int) => x + y

val second = first(1) // so it becomes (y: Int) => y + 1

println(
	second(2) // so, it puts 2 into the y, resulting 2 + 1
)

// We can get curriedSum's "second" function too, if we want

val onePlus = curriedSum(1) _ // We can write the underscore next to parentheses, because curriedSum(1)_ is not a legal identifier, but I wont, because it is confusing.

// onePlus = (x: Int) => x + 1

println(
	onePlus(2) // We insert 2 into the onePlus, so we get 2 + 1
)

// A better example:

lazy val twoPlus = curriedSum(two) _

val two = 2

println(
	twoPlus(2)
)