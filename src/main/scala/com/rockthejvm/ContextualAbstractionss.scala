package com.rockthejvm

object ContextualAbstractionss {
  /*
      contextual parameter/arguments
       */
  val aList = List(2,1,3,4,5)
  val anOrderedList = aList. sorted // (ordering)

  //Ordering
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) //(a,b) = a > b

  //analogous to an implicit val

  trait Combinator[A] {
    def combine(x: A, y:A): A
  }

  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce((a,b) => combinator.combine(a,b))

  given intCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x + y 
  }
  val theSum = combineAll(aList) //intCombinator

  /*
  given places
   - local scope
   - imported scope
   - the companions of all the tyoes involved in the call
    - companions of List
    - the companion of Int

   */

  //context bounds
  def combineAll_v2[A](list: List[A])(using Combinator[A]): A = ???
  def combineAll_v3[A: Combinator](list: List[A]): A = ???

  /*
  where context args are usuful
   - type classes
   - dependecy injection
   - context-dependent functionality
   - type-level programming
   */

  /*
  2 - extension methods
   */

  case class Person(name: String) {
    def greet(): String = s"hi ma name is $name"
  }

  extension (string: String)
    def greet(): String = new Person(string).greet()

  val danielGreeting = "daniel".greet() // "type enrichment"

  //power
  extension [A] (list: List[A])
    def combineAllValues(using combinator: Combinator[A]): A =
    list.reduce(combinator.combine)

  val theSum_v2 = aList.combineAllValues

  def main(array: Array[String]): Unit = {
    println(anOrderedList)
    println(theSum)
    println((theSum_v2))
  }

}
