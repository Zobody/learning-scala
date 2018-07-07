// Listing 7.13 : A catch clause that yields a value

import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) = 
	try {
		new URL(path)
	} catch {
		case e: MalformedURLException =>
			new URL("http://www.scala-lang.org")
	}

println(urlFor(args(0)))