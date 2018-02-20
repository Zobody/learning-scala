/*
modified a bit to learn a bit about previous sections

*/

def abs(x: Int): Int = 
	if (x >= 0) x
	else -x

def isEven(x: Int): Boolean = 
	if (x == 0) true else {
		val direction = x / abs(x)
		isOdd(x - direction)
	}

def isOdd(x: Int): Boolean = 
	if (x == 0) false else {
		val direction = x / abs(x)
		isEven(x - direction)
	}

def getParity(x: Int*) = {
	for (i <- x) yield i -> isEven(i)
}

val input = args
val inputProcessed = {
	for (i <- input) yield i.toInt
}

(getParity(inputProcessed: _*)).foreach(println _)