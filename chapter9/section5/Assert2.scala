
var assertationsEnabled = false
val x = 1 // Any value really

def myAssert(predicate: () => Boolean) = 
	if (assertationsEnabled && !predicate())
		throw new AssertionError

myAssert(() => 5 > 3) // This is weird

// Listing 9.5 : Using a by-name parameter.

def byNameAssert(predicate: => Boolean) = 
	if (assertationsEnabled && !predicate)
		throw new AssertionError

byNameAssert(x / 0 == 0) // Ah, a lot better

// Hold up tho...

def boolAssert(predicate: Boolean) = 
	if (assertationsEnabled && !predicate) // A little bit different, the `!predicate vs !predicate()` part
		throw new AssertionError

boolAssert(x / 0 == 0) // Throws ArithmeticException: / by zero