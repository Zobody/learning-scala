

/*
// This is Java
class CompilesFine {
	private int f = 0;
	public int f() {
		return 1;
	}
}
*/

class WontCompile {
	private var f = 0
	def f = 1
}

/*
chapter10\section5\JavaScalaComparison.scala:15: error: method f is defined twic e;
  the conflicting variable f was defined at line 14:21
        def f = 1
            ^
one error found
*/