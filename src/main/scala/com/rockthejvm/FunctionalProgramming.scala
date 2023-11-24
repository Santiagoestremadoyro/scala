package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO

  class Person(name: String) {


  class Person(name : String) {


  // higher-order function: take functions as arg/return functions as results.
  val aMappedList: List[Int] = List(1,2,3).map(x => x+1) //HOF
  val aFlatMappedList: List(1,2,3).flatMap { X =>
    List(X, X  2)
  } //alternative syntax, same as .map(X => List(x, 2* X))
  val afilterList: List(1,2,3,4,5).filter (_ <= 3) //equivalent to x => x <= 3

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

  //range
  val aRange = 1 to 1000
  val twoByTwo aRange.map(x => 2 * x).toList // List(2,4,6,8....2000

  //tuples: group of values under the same values
  val aTuple = ("Bon Jovi", "Rock", 1948)

  //maps
  val aPhoneBook = Map[String, Int] = Map(
    ("daniel", 685234),
    "jane", -> 357951 //equivalent to ("jane", 357951)
  )


