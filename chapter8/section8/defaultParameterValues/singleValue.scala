// Listing 8.3 : A parameter with a default value.

def printTime(out: java.io.PrintStream = Console.out) = 
	out.println("time = "+ System.currentTimeMillis())

printTime()
printTime(Console.err)