package com.rockthejvm

object PatterMatching extends App {

//switch expression
  val aInteger = 55
  val order = aInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => aInteger + "th"
  }
  // PM is an Expression

  //case class decomposition
  case class Person(name: String, age: Int)
  val Bob = Person("bob", 44)

  val personGreating = Bob match {
    case Person(n, a) => s"Hi mi name is $n and my age is $a"
    case _ => "something else"
  }

  //deconstructing tuples
  val aTupple = ("Bon Jove", "Rock")
  val bandDescription = aTupple match {
    case (band, genre) => s"$band belong to the genre $genre"
    case _ => "i don know "
  }

  //decomposing list
  val aList = List(1,2,3,4)
  val listDescription = aList match {
    case List(_,2,_) => "list contains 2"
    case => "unknown list"
  }
  //If PM does`t math anything it will throw an error matching
  //pm will try all case in sequence
}
