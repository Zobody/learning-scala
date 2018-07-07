
import java.io._

def twice(op: Double => Double, x: Double) = op(op(x))

println(
	twice(_ + 1, 5)
)


def withPrintWriter(file: File, op: PrintWriter => Unit) {
	val writer = new PrintWriter(file)
	try {
		op(writer)
	} finally {
		writer.close()
	}
}

withPrintWriter(
	new File("date.txt"),
	writer => writer.println(new java.util.Date)
)

println("Hello, World!")

println{"Hello, World!"}