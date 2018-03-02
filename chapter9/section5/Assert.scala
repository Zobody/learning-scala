
var assertationsEnabled = true

def myAssert(predicate: () => Boolean) = 
	if (assertationsEnabled && !predicate())
		throw new AssertionError

myAssert(() => 5 > 3) // This is weird