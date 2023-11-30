package com.rockthejvm

object ContextualAbstractionss {
  /*
      contextual parameter/arguments
       */
  val aList = List(2,1,3,4,5)
  val anOrderedList = aList. sorted // (ordering)
  //Ordering
  val decendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) //(a,b) = a > b


  def main(array: Array[String]): Unit = {
    println(anOrderedList)

  }

}
