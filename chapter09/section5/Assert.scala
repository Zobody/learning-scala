
var assertationsEnabled = true

def myAssert(predicate: () => Boolean) = 
	if (assertationsEnabled && !predicate())
		throw new AssertionError

myAssert(() => 5 > 3) // This is weird

// Listing 9.5 : Using a by-name parameter.

def byNameAssert(predicate: => Boolean) = 
	if (assertationsEnabled && !predicate
		throw new AssertionError

byNameAssert(5 > 3) // Ah, a lot better

// Hold up tho...

def boolAssert(predicate: Boolean) = 
	if (assertationsEnabled && !predicate) // A little bit different, the `!predicate vs !predicate()` part
		throw new AssertionError

boolAssert(5 > 3) // Pretty much the same