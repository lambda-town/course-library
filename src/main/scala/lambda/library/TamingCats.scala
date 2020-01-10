package lambda.library

import lambda.domain.courses.Course
import lambda.domain.courses.Course.CourseId

object TamingCats {

  private val id: String = "taming-cats"

  def apply() =
    Course(
      CourseId(id),
      "Taming Cats",
      "",
      tags = Nil,
      pages = Nil
  )
}
