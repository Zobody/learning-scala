// Listing 8.4 : A function with two parameters that have defaults.

def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) = 
	out.println("time = "+ System.currentTimeMillis()/divisor)

printTime2()
printTime2(out = Console.err)
printTime2(divisor = 1000)