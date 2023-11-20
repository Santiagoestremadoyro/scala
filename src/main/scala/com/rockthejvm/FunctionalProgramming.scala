package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name : String) {
    def apply(age: Int): Unit = println(s"I have aged $age years")
  }

  val bob = new Person("bob")
  bob.apply(43)
  bob(49) // Invoking bob as a function === bob.apply(49)

  /*
  Scala runs in JVM
  Functional Programming:
  - compose functions
  - pass functions as args
  - return functions as results

  conclusion : FunctionX = Function1, Function2, Functions3....Function22
   */

  val SimpleIncrementor = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  SimpleIncrementor(23)
  SimpleIncrementor.apply(23)

  // all scala FUNCTIONS are instances of the FunctionX TYPES

  //Functions with two arguments and a string return
  val StringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  StringConcatenator("I love", "Scala")

  //syntax sugar
  val doubler: Int => Int = (X: Int) => X * 2
  doubler(4)// 8

  /*
  equivalent to:
  val doubler : Function1[Int, Int] = New Function1[Int, Int] {
     override del apply(x= Int) = x * 2
     }
   */



}
