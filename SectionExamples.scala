object SectionExamples {
  def incList(lst: List[Int]): List[Int] = {
    lst.map(x => x + 1)
  }

  def getEvens(lst: List[Int]): List[Int] = {
    lst.filter(x => x % 2 == 0)
  }

  def sumList(lst: List[Int]): Int = {
    lst.foldLeft(0)((acc, x) => x + acc)
  }

  def mapWithFold[A, B](lst: List[A], f: A => B): List[B] = {
    lst.foldLeft(List[B]())((acc: List[B], x: A) => f(x)::acc)
  }

  def filterWithFold[A](lst: List[A], f: A => Boolean): List[A] = {
    lst.foldLeft(List[A]())((acc: List[A], x: A) => if (f(x)) x::acc else acc)
  }
}
