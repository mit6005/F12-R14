/**
  Examples for map, filter, and reduce lecture.
*/

import scala.math._

object MapFilterReduce {
  /**
   * Implementing our own map.
   */
  def map[A, B] (f: A => B, seq: List[A]): List[B] = {
    var result: List[B] = List ()
    seq.foreach (x => result ::= f (x))
    return result.reverse
  }

  def map2[A, B] (f: (A, A) => B, seq1: List[A], seq2: List[A]): List[B] = {
    return map ((args: (A, A)) => f (args._1, args._2), seq1.zip(seq2))
  }

  /**
   * Implemeting our own filter.
   */
  def filter[A] (f: A => Boolean, seq: List[A]): List[A] = {
    var result: List[A] = List ()
    seq.foreach (x => if (f (x)) { result ::= x })
    return result.reverse
  }

  /**
   * Partially applied functions.
   */
  def mysqrt = scala.math.sqrt _

  /**
   * Some helper functions.
   */
  def powerOfTwo (k: Double):Double = pow (2, k)
  def isOdd (x: Int): Boolean = x % 2 == 1

  def flatten[A](list: List[List[A]]): List[A] = {
    return list.foldLeft (List (): List[A])(_++_)
  }

  /**
   TODO: I have a hunch that foreach is the better iterator to use for
   this...
   map(IOBase.close, streams) # closes each stream on the list
   map(Thread.join, threads) # waits for each thread to finish
   */

  def evaluate(a: List[Double], x: Double): Double = {
    val xi = map ((i: Int) => pow (x, i), (0 to a.length).toList)
      val axi = map2 ((x: Double, y: Double) => x*y, a, xi)
    return axi.foldLeft (0: Double)(_+_)
  }

  /**                                           
   * Map examples.
   */
  def mapExamples (): Unit = {
    println (List (1: Double, 4, 9, 16).map (sqrt))
    println (List ('A', 'B').map ((s: Char) => s.toLower))
    println (map (powerOfTwo, List (1: Double, 2, 3, 4)))
    println (map ((k: Double) => pow (2, k), List (1: Double, 2, 3, 4)))
  }
  /**
   * Filter examples.
   */
  def filterExamples (): Unit = {
    println (List (1, 2, 3, 4).filter (isOdd))
    println (List (1, 2, 3, 4).filter (x => x % 2 == 1))
    println (filter ((c: Char) => c.isLetter, List ('x', 'y', '2', '3', 'a')))
    println (filter ((s: String) => s.length () > 0, List ("abc", "", "d")))
  }

  def reduceExamples (): Unit = {
    println (List (1, 2, 3).foldLeft (0)(_+_))
    println (List (5, 8, 3, 1).foldLeft (0)(max _))
    println (List (1, 2, 3, 4).foldLeft ("")((s, x) => s + x))
    println (flatten (
              List (List (1, 2), List (3, 4), List (), List (5), List ())))
  }

  /**
   * Some useful functions in Function1
   * andThen[A](g: (R) ⇒ A): (T1) ⇒ A
   * compose[A](g: (A) ⇒ T1): (A) ⇒ R 
   */
}
