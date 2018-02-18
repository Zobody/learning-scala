// Listing 7.11 : A try-catch clause in Scala.

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
	val f = new FileReader("input.txt")
	// Use and close file
} catch {
	case ex: FileNotFoundException => println("File was not found.")
	case ex: IOException => println(ex)
}