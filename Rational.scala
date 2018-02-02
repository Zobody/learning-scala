

class Rational(n: Int, d: Int) { // a comment to induce change

	require(d != 0)

	private val g = this.gcd(n.abs, d.abs)

	val numer: Int = n / this.g
	val denom: Int = d / this.g


	def this(n: Int) = this(n, 1) // auxiliary constructor


	override def toString = 
		this.numer + "/" + this.denom

	def + (that: Rational): Rational =
		new Rational(
			this.numer * that.denom + that.numer * this.denom,
			this.denom * that.denom
		)

	def - (that: Rational): Rational = 
		new Rational(
			this.numer * that.denom - that.numer * this.denom,
			this.denom * that.denom
		)

	def * (that: Rational): Rational = 
		new Rational(
			this.numer * that.numer,
			this.denom * that.denom
		)

	def / (that: Rational): Rational = 
		new Rational(
			this.numer * that.denom,
			this.denom * that.numer
		)

	def unary_- : Rational =
		new Rational(
			-this.numer,
			this.denom
		)
	
	def < (that: Rational) =
		this.numer * that.denom < that.numer * this.denom

	def > (that: Rational) =
		this.numer * that.denom > that.numer * this.denom

	def max(that: Rational) = 
		if (this < that) that else this

	def min(that: Rational) =
		if (this > that ) that else this

	private def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b)
}