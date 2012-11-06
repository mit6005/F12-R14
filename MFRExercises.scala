/**
 * Exercises for the first 6.005 Recitation on Scala.
 * Jean Yang (jeanyang [at] mit)
 * November 2012
 *
 * Things we will do in recitation:
 * - Get everyone running Scala.  See:
 *   https://sites.google.com/site/jeevesprogramming/tutorial/introduction-to-scala-for-6-005
 * - Section 1: Recursion (ex. 1) and tail recursion (ex. 2).
 * - Section 2: Map (ex. 3), filter (ex. 4), and reduce (ex. 5, 6).  How reduce
 *   is all you need in life (ex. 7, 8).
 */
import scala.math._

/* Bonus exercise: What is the point of defining this exception? */
case object Unimplemented extends Exception

object MFRExercises {

  /* Part 1: Recursion. */
  /* From Martin Odersky's Scala by Example:
     A common way to compute square roots is by Newton’s method of successive
     approximations. One starts with an initial guess y (say: y = 1).  One then
     repeatedly improves the current guess y by taking the average of y and
     x/y. As an example, the next three columns indicate the guess y, the
     quotient x/y, and their average for the first approximations of 2.
     1        2/1 = 2             1.5
     1.5      2/1.5 = 1.3333      1.4167
     1.4167   2/1.4167 = 1.4118   1.412
     1.4142   ...                 ...
     y        x/y                 (y + x/y)/2
  */
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.001

  def sqrt(x: Double) = sqrtIter(1.0, x)

  /* Exercise 1: Now implement Newton's method using nested functions. */
  def yourSqrt(x: Double) = throw Unimplemented

  /* Bonus exercise: The test in isGoodEnough is not too precise for small
     numbers and might lead to non-termination for very large ones.  (Why?)
     Design a different version of isGoodEnough which does not have these
     problems.  You may want to get by reading this:
     http://bloodredsun.com/2011/06/22/doubles-financial-calculations/ */

  /* Part 1.1: Recursion vs. tail recursion. */
  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

  /* Exercise 2: Implement a tail recursive version of factorial. How does
     evaluation of this differ? */
  def factorialTail(n: Int, acc:Int): Int = throw Unimplemented

  /* Part 2: Map/filter/reduce. */
  /* Exercise 3: Use List.map to implement the incList funtion, which takes
     each element of a list and increments it by 1. */
  def incList(lst: List[Int]): List[Int] = throw Unimplemented

  /* Exercise 4: Use List.filter to implement the getEvens function, which
     returns a new list with only the even elements of an integer list. */
  def getEvens(lst: List[Int]): List[Int] = throw Unimplemented

  /* Exercise 5: Use List.foldLeft (reduce) to implement the sumList function
     for summing all elements of a list. */
  def sumList(lst: List[Int]): Int = throw Unimplemented

  /* Exercise 6: Use List.foldLeft (reduce) to implement the countOccurrences
     function for counting the number of times a word shows up in a list.  How
     might such a function be useful in real life? */
  def countOccurrences(word: String, lst: List[String]): Int =
     throw Unimplemented

  /* Bonus exercise: What is the difference between foldLeft and foldRight?
     When do we want to use foldLeft vs. foldRight? */

  /* Exercise 7: Use List.foldLeft to define map. */
  def mapWithFold[A, B](lst: List[A], f: A => B): List[B] =
    throw Unimplemented

  /* Exercise 8: Use List.foldLeft to define filter. */
  def filterWithFold[A](lst: List[A], f: A => Boolean): List[A] =
    throw Unimplemented

  /* Bonus exercise: How does Google's map-reduce framework work?  What
     aspects of functional programming help map-reduce work as well as it
     does? */
}
