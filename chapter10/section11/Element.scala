// Listing 10.2 : Defining parameterless methods width and height.

abstract class Element {
	def contents: Array[String]
	def height: Int = contents.length
	def width: Int = if (height == 0) 0 else contents(0).length
}