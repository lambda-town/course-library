package lambda

import cats.Monad
import lambda.domain.courses.Course
import lambda.domain.courses.Page._
import lambda.domain.courses.Widget

package object library {

  import cats.Functor

  def courses[F[_]: Monad]: F[List[Course]] = {
    Monad[F].pure(
      List(
        atasteofscala.apply()
      )
    )
  }

  def widgets[F[_]: Monad](): F[List[Widget]] =
    Functor[F].map(courses[F])(_.flatMap(_.pages).flatMap {
      case p: SimplePage => p.widgets
      case p: CodePage   => p.widgets :+ p.code
    })
}
