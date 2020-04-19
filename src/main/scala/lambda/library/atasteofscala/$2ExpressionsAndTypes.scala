package lambda.library.atasteofscala

object $2ExpressionsAndTypes {

  val pageId = s"$id-expressions-and-types"

  def apply() =
    simplePage("Expressions and Types")
      .withWidget(mk(widgetId(pageId, 0),
        """
          |In this section, we will go over the most basic building blocks of a Scala program: expressions
          |and methods.
          |
          |## Hello, World!
          |
          |We will start this Scala journey with a traditional *Hello world* example that will allow us to
          |demonstrate how the entry-point of s Scala application is defined:
          |""".stripMargin
      ))
    .withWidget(scala(widgetId(pageId, 2))
        .withDefaultValue(
          """
            |object Main extends App {
            |    println("Hello, world")
            |}
            |""".stripMargin.trim
        )
    )
    .withWidget(mk(widgetId(pageId, 3),
      """
        |In Scala, there are multiple ways of defining the entry point or *main class* of an application.
        |In this example, we show the most simple form, which consists of a singleton `object`, inheriting from some
        |globally-defined `App` component. (This component is called a *Trait*, we'll cover them soon enough).
        |
        |Whatever goes in that object will be executed when we run the program. The `println` method allows you
        |to print lines to the standard output. Pretty straightforward so far.
        |
        |### Running the program
        |
        |On *Lambdacademy*, you can run programs and solve exercises without leaving your browser. Nonetheless, here
        |is how one would run such a program on a computer.
        |
        |You first need to compile the file to Java bytecode using the Scala compiler
        |
        |```
        |scalac Main.scala
        |```
        |
        |This creates classes files that are ready to be ran by the JVM. Execute them using the `scala command`
        |
        |```
        |scala Hello
        |// => Hello, world
        |```
        |""".stripMargin
    ))
    .withWidget(mk(widgetId(pageId, 4),
      """
        |## Expressions and types
        |
        |In Scala, the most basic building block of a program is an *expression*. Expressions are combinations
        |of terms that can be reduced to a value. Here are some examples of anonymous expressions:
        |
        |```scala
        |45 + 3
        |"Hello" + " " + "World"
        |"foo bar baz".toUpperCase()
        |```
        |All of these expressions can be evaluated, i.e. reduced to a value, and all values in Scala have a type
        |associated to them.
        |
        |But of course, anonymous expressions on their own are limited, we need a way of reusing expressions by binding
        |them to a name.
        |
        |```scala
        |val name = "George"
        |```
        |
        |Here we have used the `val` keyword to bind the expression `"George"` to the `name` identifier. This binding
        |is immutable, meaning it can't be changed after declaration. However, Scala also supports traditional, mutable,
        |variables with the `var` keyword.
        |
        |```scala
        |var counter = 1
        |println(counter) // 1
        |counter += 1
        |println(counter) // 2
        |```
        |
        |Try changing the binding below from a `val` to a `var` so the compiler doesn't complain.
        |""".stripMargin
    ))
    .withWidget(scala(widgetId(pageId, 5))
        .withDefaultValue(
          """
            |object Main extends App {
            |val name = "Paul"
            |name = John"
            |
            |println(name)
            |}
            |""".stripMargin.trim
        )
    )
    .withWidget(mk(widgetId(pageId, 6),
      """
        |Please keep in mind that immutable bindings (`val`) should be preferred, and mutable variables only
        |used when necessary. Mutable variables make the code harder to reason about, hence more prone to bugs, and
        |harder to execute in multi-threaded environment because of race-conditions risks.
        |Using functional programming, it is possible to write complete applications without
        |using a single mutable variable.
        |""".stripMargin
    ))
}
