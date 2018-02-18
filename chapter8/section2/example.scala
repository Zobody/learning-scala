
import scala.io.Source

def processFile(filename: String, width: Int) {
	def processLine(filename: String, width: Int, line: String) {
		if (line.length > width)
			println(filename + ": "+ line)
	}
	val source = Source.fromFile(filename)
	for (line <- source.getLines()) {
		processLine(filename, width, line)
	}
}

processFile(args(0), args(1).toInt)