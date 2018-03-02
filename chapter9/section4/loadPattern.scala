import java.io._

// Listing 9.4 : Using the loan pattern to write to a file.

def withPrintWriter(file: File)(op: PrintWriter => Unit) {
	val writer = new PrintWriter(file)
	try {
		op(writer)
	} finally {
		writer.close()
	}
}

val file = new File("date.txt")

withPrintWriter(file) {
	writer => writer.println(new java.util.Date)
}