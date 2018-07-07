
// Imperative

def containsNegImperative(nums: List[Int]): Boolean = {
	var exists = false
	for (num <- nums)
		if (num < 0)
			exists = true
	exists
}

println(
	containsNegImperative(List(1,2,3,4))
)
println(
	containsNegImperative(List(1,2,-3,4))
)

// Functional

def containsNegFunctional(nums: List[Int]) = nums.exists(_ < 0)

println(
	containsNegFunctional(Nil)
)
println(
	containsNegFunctional(List(0,-1,-2))
)


// Another example, I won't bother with println statements, as the book didn't either

// Imperative

def containsOddImperative(nums: List[Int]): Boolean = {
	var exists = false
	for (num <- nums)
		if (num % 2 == 1)
			exists = true
	exists
}

// Functional

def containsOddFunctional(nums: List[Int]) = nums.exists(_ % 2 == 1)