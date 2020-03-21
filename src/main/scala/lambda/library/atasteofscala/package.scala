package lambda.library

import lambda.domain.courses.Course
import lambda.dsl.courses.DSL

package object atasteofscala extends DSL {

  val title: String = "A taste of Scala"
  val id: String = slug(title)

  def apply(): Course =
    (course(title)
      withDescription (
        """
        |Scala is a modern, expressive, statically typed programming language that is both functional and object oriented.
        |This course is aimed at people who already have some experience of programming and would like to learn the basics
        |of functional programming in Scala.
        |
        """.stripMargin.trim
      )
      withImage mediaResource("/public/a-tour-of-scala.png")
      withPage $1Introduction()
      withPage $2ExpressionsAndTypes())
}
