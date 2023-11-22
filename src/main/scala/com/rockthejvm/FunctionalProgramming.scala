package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 arguments and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", " Scala") // "I love Scala"

  // syntax sugars
  val doubler: Int => Int = (x: Int) => 2 * x
  doubler(4) // 8

  /*
    equivalent to the much longer:

    val doubler: Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x
    }
   */

  // higher-order function: take functions as arg/return functions as results.
  val aMappedList: List[Int] = List(1,2,3).map(x => x+1) //HOF
  val aFlatMappedList: List(1,2,3).flatMap { X =>
    List(X, X  2)
  } //alternative syntax, same as .map(X => List(x, 2* X))
  val afilterList: List(1,2,3,4,5).filter (_ <= 3) //equivalent to x => x <= 3

  // all pairs between the num 1, 2, 3 and the letters "a", "b", "c"
  val allPairs: List(1,2,3).flatMap(number => List 'a', 'b', 'c').map(letters => s"$number-$letters")

  //for comprehension
  val altNativePairs: for {
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number-$letter"
  //equivalent to the map/flatmap chain above

  /**
   * collections
   */

  //list
  val aList = List(1,2,3,4,5)
  val fistElement = alist.head
  val rest = alist.tail
  val PrependingList = 0 :: aList // List (0,1,2,3,4,5)
  val anExtendingLsit = 0 +: aList + 6 // List(0,1,2,3,4,5,6)

  //Sequences
  val aSequences: seq[Int] = Seq(1,2,3) //Seq.apply(1,2,3
  val accesElementes = aSequences(1) // the element in the 1 index: 2

  //vectors
  val vector = Vector(1,2,3,4,5)

  //set
  val aSet = Set(1,2,3,1,2,3) //set(1,2,3)
  val setHas5 = aset.contains(5)
  val anAddedSet = aSet + 5 // set(1,2,3,5)
  val aRemoveSet = aSet - 2 //set(1,3)
}
