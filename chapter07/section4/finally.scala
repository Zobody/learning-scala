// Listing 7.12 : A try-finally clause in Scala.

import java.io.FileReader

val file = new FileReader("input.txt")

try {
	// Use the file
} finally {
	file.close() // be sure to close the file
}