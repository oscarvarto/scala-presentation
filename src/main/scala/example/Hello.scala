package example

import scala.util.Random
import scala.collection.immutable.HashMap

object Hello extends Greeting with App {
  //println(greeting)

  val x: Int = Random.nextInt(10)

  x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  // Instead of this
  val x1: HashMap[Int, String] = new HashMap[Int, String]()
  // Any of these alternatives work in Scala
  val x2 = new HashMap[Int, String]()
  val x3: Map[Int, String] = new HashMap()

  def testStringOrNull(o: Object): Unit = {
    o match {
      case null        => println("Oops, got null!")
      case str: String => println(s"Got the string: $str")
      case _           => println("Other thing received");
    }
  }

  testStringOrNull(null)
  testStringOrNull("Hello")

  def testSealedCoverage(s: S): Int =
    s match {
      case a: A => 1
      case b: B => 2
      case C(i) => i
    }

  println(s"Computed: ${testSealedCoverage(C(5))}")
}

sealed trait S
final class A extends S
final class B extends S
final case class C(i: Int) extends S

trait Greeting {
  lazy val greeting: String = "hello"
}
