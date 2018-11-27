class Point(val x: Int, val y: Int)

trait Rectangular {
	def topLeft: Point
	def bottomRight: Point

	def left = topLeft.x
	def right = bottomright.x
	def width = right - left
	// etc
}