// Listing 8.2 : LongLines with a local processLine function

import scala.io.Source

object LongLines {
	def processFile(filename: String, width: Int) {
		def processLine(line: String) {
			if (line.length > width)
				println(filename + " : "+ line)
		}
		val source = Source.fromFile(filename)
		for (line <- source.getLines())
			processLine(line)
	}
}