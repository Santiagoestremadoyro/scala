package com.rockthejvm

object ContextualAbstractionss {
  /*
      contextual parameter/arguments
       */
  val aList = List(2,1,3,4,5)


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
  val theSum = combineAll(aList)




  def main(array: Array[String]): Unit = {
    println(anOrderedList)

  }

}
