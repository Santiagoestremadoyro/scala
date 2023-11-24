package com.rockthejvm

object Advanced extends App {
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  import scala.util.{Failure, Success, Try}

  //lazy evaluations
  lazy val aLazyValue = 22
  lazy val aLazyValWithSideEffects = {
    println("i am Scala")
    43
  }

  val eagerValue = aLazyValWithSideEffects + 1
  //useful in infinite collections

  //"pseudo-Collections": Option, Try
  def methodThatCanReturnNull : String = "Hello Scala"
  val anOption = Option(methodThatCanReturnNull()) // some("hello Scala")
  //options are collections that can contain at most one element: Null or Some(value)

  val stringProcession = anOption match {
    case Some(string) => s"i have obtain a valid string: $string"
    case None => "i obtain nothing"
  }

  //map, filter, flatmap

  def MethodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(MethodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well or an exception if the code threw one.

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"i have obtain a valid string $validValue"
    case Failure(ex) => s"I have obtain a exception $ex"
  }

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }

  //future is a "collections" that contains a value when it is evaluated
  //future is composable with map, filter, flatmap

  /**
   * Implicits basic
   */
  //1: implicit value conversion
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) //

  //2: implicit conversion
  implicit class myRichInteger(n: Int){
    def isEven() = n % 2 == 0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven()

}
