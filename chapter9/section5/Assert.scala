
var assertationsEnabled = true

def myAssert(predicate: () => Boolean) = 
	if (assertationsEnabled && !predicate())
		throw new AssertionError

myAssert(() => 5 > 3) // This is weird

// Listing 9.5 : Using a by-name parameter.

def byNameAssert(predicate: => Boolean) = 
	if (assertationsEnabled && !predicate())
		throw new AssertionError

byNameAssert(5 > 3)