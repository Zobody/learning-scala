// Listing 10.9 : Class Element with above, beside, and toString.

abstract class Element {
	def contents: Array[String]
	def height: Int = contents.length
	def width: Int = if (height == 0) 0 else contents(0).length

	def above(that: Element): Element = 
		new ArrayElement(this.contents ++ that.contents)
	/*
	def beside(that: Element): Element = {
		val contents = new Array[String](this.contents.length)
		for (i <- 0 until this.contents.length)
			contents(i) = this.contents(i) + that.contents(i)
		new ArrayElement(contents)
	}
	*/

	def beside(that: Element): Element = {
		new ArrayElement(
			for (
				(line1, line2) <- this.contents zip that.contents
			) yield {line1 + line2}
		)
	}

	override def toString = contents mkString "\n"

}

// Listing 10.10 : A factory object with factory methods.

object Element {
	def elem(contents: Array[String]): Element = 
		new ArrayElement(contents)

	def elem(chr: Char, width: Int, height: Int): Element = 
		new UniformElement(chr, width, height)

	def elem(line: String): Element = 
		new LineElement(line)
}