// 7.1 If expressions
println("7.1 If expressions")
// imperative style

var filenameI = "default.txt"

if (!args.isEmpty)
	filenameI = args(0)

// functional style

// Listing 7.1

val filenameF = 
	if (!args.isEmpty) args(0)
	else "default.txt"

println(filenameI)
println(filenameF)
println(if (!args.isEmpty) args(0) else "default.txt")


// 7.2 While loops
println("7.2 While loops")
// Listing 7.2

def gdcLoop(x: Long, y: Long): Long = {
	var a = x
	var b = y
	while (a != 0) {
		val temp = a
		a = b % a
		b = temp
	}
	b
}

// Listing 7.3
println("WARNING: You must write an empty line if you want the following code to continue like most likely intended, or otherwise while loop will never end.")
import scala.io.StdIn.readLine // we get deprecation warning if we don't include this, book is outdated

var line = ""
do {
	line = readLine()
	println("Read: "+ line)
} while(line != "")

// Listing 7.4

def gcd(x: Long, y: Long): Long = // This is shorter, functional and better, and usually while loops should be avoided overall
	if (y == 0) x else gcd(y, x % y)


// 7.3 For expressions
println("7.3 For expressions") // sanity check

def spaceBetweenListings = { // To make output easier to read
	println("")
	println("-------")
	println("")
}

// Listing 7.5

spaceBetweenListings

val filesHere = (new java.io.File(".")).listFiles

for (file <- filesHere)
	println(file)

spaceBetweenListings

// We can also use Range type

for (i <- 1 to 4) 
	println("Iteration "+ i)

spaceBetweenListings

// I can also ignore the final value, often when dealing with 0-indexed arrays, but I don't see why in a for loop would you use Range type instead of just iterating over the array

for (j <- 1 until 4) // I could have used i, it would have simply overwritten it
	println("JIteration "+ j)

spaceBetweenListings

// There is also this, tho it is not common in Scala for reasons stated above
for (i <- 0 to filesHere.length - 1) 
	println(filesHere(i))

spaceBetweenListings

// Filtering

// Listing 7.6

// val filesHere = (new java.io.File(".")).listFiles // This is already present in Listing 7.5

for (file <- filesHere if file.getName.endsWith(".scala"))
	println(file)

spaceBetweenListings

// Alternative(imperative)

for (file <- filesHere) 
	if (file.getName.endsWith(".scala"))
		println(file)

spaceBetweenListings

// Listing 7.7

for (
	file <- filesHere
	if file.isFile
	if file.getName.endsWith("scala")
) println(file)

spaceBetweenListings

// Listing 7.8

def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

def grepA(pattern: String): Unit = {
	for ( 
		file <- filesHere
		if file.isFile // without this, script trips up over folder named 'notAFile.scala', since it ends in .scala but it is not a file.
		if file.getName.endsWith(".scala"); // SEMICOLON
		line <- fileLines(file)
		if line.trim.matches(pattern)
	) println(file +": "+ line.trim)
}

grepA(".*gcd.*")

spaceBetweenListings

// Listing 7.9

def grepB(pattern: String): Unit = {
	for { // notice the curly braces
		file <- filesHere
		if file.isFile
		if file.getName.endsWith(".scala")
		line <- fileLines(file)
		trimmed = line.trim
		if trimmed.matches(pattern)
	} println(file +": "+ trimmed)
}

grepB(".*for.*") // they use gcd, since this is regex, we can change it to any valid matching pattern

spaceBetweenListings

// We can also generate a new collection(or something like that)

def scalaFiles = 
	for {
		file <- filesHere
		if file.isFile
		if file.getName.endsWith(".scala")
	} yield file // for clauses yield body

/*
for (
	file <- filesHere
	if file.isFile
	if file.getName.endsWith(".scala")
)	{
	yield file // Syntax error!
}
*/

// Listing 7.10

val forLineLengths = 
	for {
		file <- filesHere
		if file.isFile
		if file.getName.endsWith(".scala")
		line <- fileLines(file)
		trimmed = line.trim
		if trimmed.matches(".*for.*") // alright, so apperantly, the book actually already had .*for.* matching, so that was uh unexpected
	} yield trimmed.length


for (file <- scalaFiles) {
	println(file)
}

spaceBetweenListings

for (i <- forLineLengths) 
	println(i)

spaceBetweenListings