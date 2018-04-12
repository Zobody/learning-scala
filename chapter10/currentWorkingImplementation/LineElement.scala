// Listing 10.6 : Invoking a superclass constructor

class LineElement(s: String) extends ArrayElement(Array(s)) {
	override def width = s.length
	override def height = 1
}