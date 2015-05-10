//------- A Scala code-along quick init

/* Preparations:
  * Download latest Scala: http://scala-lang.org/download/
  * Open a terminal window (bash | powershell | cmd)
  * Run the scala command
  * Type in the code snippets below line by line as we code along together 
*/

/* What is Scala?
  * Scala is a statically typed object-functional language 
  * Scala runs on the Java Virtual Machine 
  * Scala can call any Java byte code, including all classes in the JDK
  * Scala's standard library includes a powerful collections library
  * Scala has more powerful abstraction mechanisms compared to Java
  * Scala is more regular compared to Java
  * Scala is as concise as many dynamic scripting languages
  * Scala is statically typed; thus both safe and fast
  * Scala is used by Twitter, LinkedIn, Netflix, Coursera, ...
    https://tech.coursera.org/blog/2014/02/18/why-we-love-scala-at-coursera/
  * There are many useful Scala libs and frameworks: Play, Akka, Scalatra, Lift, ..
*/   

//every value is an object (no special "primitive types" as in Java)
1.toString
(3.14).toInt
"3.14".toDouble

//variable definition (type annotation with type name after colon)
var x: Int = 0  //corresponding Java:  int x = 0;

//type inference allow us to skip the type annotation, but still statically typed!
var x = 0

//assignment
x = x + 1
x += 1
x -= 10
println(x)

//value definition (a name referring to an assign-only-once variable)
val k = 20
k = k + 1 //Compile error:reassignment to val

//Scala raw strings
"""This string has "quotes" in it without escape chars."""

//Scala string interpolation:
//  http://docs.scala-lang.org/overviews/core/string-interpolation.html
//the s interpolator: inserting values or expressions into strings
val it = 42
println(s"This is it: $it")
println(s"This is almost it: ${it-1}")

//the f interpolator: a type-safe formatter of numbers
val that = 42 / 3.14
println(f"This is that with $that%2.2f decimals ")

//we have access to the whole JDK, e.g. just change locale default if you like
java.util.Locale.setDefault(java.util.Locale.US)

//function definition
def inc(x: Int): Int = x + 1

//type inference allow us to skip the return type
def inc(x: Int) = x + 1

//function application, "calling" a function
inc(41)

//create a Vector
val xs = Vector(5, 6, 8, 7)   //or List or Set

//map inc over all elements and make a new Vector
val ys = xs.map(inc)

//collect some specific elements in a new vector
val zs = xs.collect{ case x if x > 6 => x }

//for loop
for (i <- 0 to 2) { println(xs(i)) }
for (i <- 0 until xs.size) { println(xs(i)) }

//for comprehension
val xsPlus1 = for (i <- 0 to 2) yield xs(i) + 1

//creating a range (a collection of consecutive integers)
(0 to 2)
(0 until 3)

//executing a function for each element in a collection using a function literal
(0 to 2).foreach(i => println(i))
xs.foreach(i => println(i))
(0 to 2).foreach(i => println(xs(i))

//take the first 3 and print - safer as it does not break if less than 3
xs.take(3).foreach(i => println(i))

//shorter but expanded to the code above
xs.take(3).foreach(println(_))

//even shorter 
xs.take(3).foreach(println)

//while loop
var i = 0
while (i < 10) { println(i); i += 1 }

//create a singelton object (exactly one instance, no new)
object obj { def dec(x: Int) = x - 1 }

//dot notation:
obj.dec(41)

//import all public members of an object:
import obj._
dec(43)

//functions are objects (!) with apply method(s)
object inc2 { def apply(x: Int) = x + 1}
inc2.apply(41)
inc2(41)  //the complier injects the .apply method call 

//Every value is an object
41 + 1  //this is actually simplified dot notation
41.+(1)  //41 is an object
inc2 apply 41  //operator notation on object inc2

//declare a class with a primary constructor
class Banana(gram: Int) {
  val color = "yellow"       //an immutable attribute
  var pricePerKilo = 10      //a mutable attribute
  def kilo = gram / 1000.0   //a method
  def price = kilo * pricePerKilo  //another method
}

//create an object and define a name that refers to that object:
val b1 = new Banana(420)

//Gram is private
b1.gram //Compile error:value gram is not a member of Banana

//Members are public by default
b1.kilo 
b1.pricePerKilo = 20

//create a base type to inherit from (trait is similar to a Java interface)
trait Fruit { 
  def gram: Int                     //an abstract member
  def kilo: Double = gram / 1000.0  //trait members can be concrete
}

//inherit from Fruit (val before class parameters to make it public)
class Banana(val gram: Int) extends Fruit 
val b2 = new Banana(399)
b2.gram
b2.kilo

//Create a companion object with an apply factory method using :paste in REPL
class Banana(val gram: Int) extends Fruit {
  override def toString = s"Banana($kilo) // in kilograms"
}
object Banana { //the same name as the class name and in the same code file
  def apply(kilo: Double) = new Banana((kilo*1000).toInt)
}

//use our apply method (often used instead of multiple constructors)
val b3 = Banana(0.333333)

//Create a case class:
case class Orange(gram: Int) extends Fruit

/* What do you get with the keyword 'case'?
By adding 'case' in front of 'class' you get all these goodies for free:
 * object with apply factory; no need for new
 * a nice toString of all class parameters
 * class parameters become public val fields
 * an equals method implementing structural equality over class params with ==
 * a hash code making objects hash well in e.g. HashMap and Set collections
 * an unapply method to enable pattern matching
*/
val o1 = Orange(123)
Orange(123) == Orange(123) //structural equality
Vector(Orange(42), Orange(43)).collect{case Orange(g) if g > 42 => g + 42} //pattern matching

//operator method + (this example is somewhat strange; better put + in Fruit)
case class Apple(val gram: Int) extends Fruit {
  def +(that: Orange): Vector[Fruit] = Vector(this, that) 
}
Apple(111) + Orange(222)

implicit class StringPimper(s: String) {
  def toCoolString = s + " is cool!"
}  
"Scala".toCoolString