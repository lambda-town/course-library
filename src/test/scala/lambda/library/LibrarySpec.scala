package lambda.library

import org.scalatest._
import lambda.domain.courses.MultipleChoices
import cats.effect.IO
import lambda.domain.code.SourceFile
import lambda.domain.courses.InteractiveCodeWidget.{SimpleScala2CodeWidget, TabbedScala2CodeWidget}


class LibrarySpec extends FunSpec with Matchers {

  describe("Courses library") {
    it("Should have unique courses ids") {
      courses[IO].map(courses => courses.map(_.id).distinct shouldEqual courses.map(_.id)).unsafeRunSync()
    }

    it("Should have unique widgets ids") {
      widgets[IO].map(widgets => widgets.map(_.id).distinct shouldEqual widgets.map(_.id)).unsafeRunSync()
    }

    it("Should have unique proposition ids for each Multiple choices widgets") {
      widgets[IO]
        .map(
          widgets =>
            widgets.foreach({
              case MultipleChoices(_, _, question) =>
                val propositionsIds = (question.otherPropositions
                  .map(_.id) :+ question.rightAnswer.id)
                propositionsIds.distinct shouldEqual propositionsIds
              case _ => succeed
            })
        )
        .unsafeRunSync()
    }

    it("Should have valid resources for all code widgets") {
      widgets.flatMap({
        case w: SimpleScala2CodeWidget => w.baseFiles
        case w: TabbedScala2CodeWidget => w.baseFiles
        case _ => Nil
      }).collect({
        case f: SourceFile.ClasspathResource => f
      }).foreach(f => {
        println(s"Reading ${f.name}")
        getClass.getResourceAsStream(f.name)
      })
    }
  }
}
