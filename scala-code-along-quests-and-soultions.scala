//*** QUEST: How to implement the below Java method using a scala Stream:

/** calculate an approximation of e to the power of x
*/
public double exp(double x, double epsilon){ //this is a Java method
    // use e.g. epsilon = 0.5E-6
    double sum = 0;
    double term = 1;
    int k = 0;
    while (Math.abs(term) > epsilon) {
        sum += term;
        k++;
        term = term * x / k;
    }
}

//Solution with scala Stream

import Stream._

def macLaurinExp(x: Double, i: Int=1, prev: Double=1.0): Stream[Double] = 
  prev #:: series(x,i+1, prev*x/(i+1))

def exp(X: Double, epsilon: Double = 0.5E-6) = 
  1 + (macLaurinExp(1) takeWhile (x => x > epsilon)).sum
  

//*** QUEST: How to remove code duplication in factory object?

//Code with some duplication:
trait Fruit {
  def gram: Int
  def kilo: Double = gram/1000.0
  def color: String
}

case class Banana(gram: Int) extends Fruit { val color = "yellow" }
object Banana { def apply(kilo: Double): Banana = new Banana((kilo*1000).toInt) }

case class Orange(gram: Int) extends Fruit { val color = "orange" }
object Orange { def apply(kilo: Double): Orange = new Orange((kilo*1000).toInt) }

//We want to factor out duplicated code into a FruitCompanion, like this:

trait Fruit { /* same as above */ }

trait FruitCompanion { ??? /* what should go here ??? */}
 
case class Banana(gram: Int) extends Fruit { val color = "yellow" }
object Banana extends FruitCompanion

case class Orange(gram: Int) extends Fruit { val color = "orange" }
object Orange extends FruitCompanion

//Solution with trait 

trait Fruit {  //same as before
  def gram: Int
  def kilo: Double = gram/1000.0
  def color: String
}

trait FruitCompanion[F <: Fruit]{
  val makeFruit: Int => F
  def apply(kilo: Double): F = makeFruit((kilo * 1000).toInt)
}

case class Banana(gram: Int) extends Fruit { val color = "yellow" }
object Banana extends FruitCompanion[Banana] { val makeFruit = new Banana(_)}

case class Orange(gram: Int) extends Fruit { val color = "orange" }
object Orange extends FruitCompanion[Orange] { val makeFruit = new Orange(_)}

//Solution with class

trait Fruit { //same as before
  def gram: Int
  def kilo: Double = gram/1000.0
  def color: String
}

class FruitCompanion[F <: Fruit](makeFruit: Int => F) {  
  def apply(kilo: Double): F = makeFruit((kilo * 1000).toInt)
}

case class Banana(gram: Int) extends Fruit { val color = "yellow" }
object Banana extends FruitCompanion(new Banana(_)) //type F can now be inferred from class parameter

case class Orange(gram: Int) extends Fruit { val color = "orange" }
object Orange extends FruitCompanion(new Orange(_))

