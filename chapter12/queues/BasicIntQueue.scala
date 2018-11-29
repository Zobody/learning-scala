import scala.collection.mutable.ArrayBuffer

trait Doubling extends IntQueue {
	abstract override def put(x: Int) { super.put(2*x) }
}

class BasicIntQueue extends IntQueue {
	private val buf = new ArrayBuffer[Int]
	def get() = buf.remove(0)
	def put(x: Int) {buf += x}
}