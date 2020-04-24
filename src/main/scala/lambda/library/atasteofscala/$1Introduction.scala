package lambda.library.atasteofscala

object $1Introduction {
  
  val pageId = s"$id-introduction"

  def apply() = (simplePage("Introduction: Why Scala?")
    withWidget mk(
      widgetId(pageId, 0),
      """Scala is a modern, multi-paradigm programming language designed to express common programming patterns in a concise,
      |elegant, and type-safe way. It smoothly integrates features of object-oriented and functional languages.
      |
      |Scala was created by Martin Odersky at the [EPFL](https://www.epfl.ch/en/), in Switzerland. The first release of Scala is from 2003.
      |The language has since then successfully been used by major tech companies, startups, and as the primary language of
      |widely-used open-source projects such as [Apache Spark](https://spark.apache.org/) or kafka[https://kafka.apache.org/].
      |Scala can be used for heavy data processing, machine learning, web services and more. It has been steadily gaining popularity in the IT industry,
      |and is probably the most popular functional programming language in use today.
      |
      |Scala is a beautiful, modern programming language, that can be used to build robust, safe programs that perform well and easily
      |adapt over time. And
      |
      |""".stripMargin
    )
    withWidget multipleChoices(
      widgetId(pageId, 1),
      "What is Scala ?",
      "A general-purpose, functional and object oriented programming language with a strong type system",
      "The name of a very famous boys band from the 90s",
      "A framework to build microservices",
      "The new game of Peter Molyneux"
    )
    withWidget mk(
      widgetId(pageId, 2),
      """#### What's in this course ?
      |
      |This first course covers the basics of the language. It should be a first step for people that have some programming
      |experience and no experience in Scala.
      |
      |### Scala is expressive and statically typed
      |
      |In Scala, every value has a well-defined type. The correctness of Scala programs is
      |enforced at compile time. Scala's type system allows using powerful abstractions in safe and coherent manner.
      |
      |Scala supports traits, generics, inner classes, type bounds and many other features that allow developers
      |to model their business model with precision and write complex programs with confidence. Many deadly
      |errors will be caught during the compilation, thus making runtime safer.
      |
      |Furthermore, we say the Scala is an *expression oriented* language. When writing Scala code, we strive
      |to focus on *what* should be achieved, instead of *how*. We do that by combining expressions rather than
      |imperatively control the flow of execution. In Scala, everything has a value, including conditionals such
      |as *if/else*. We don't make the distinction between expression and statement like most languages do.
      |
      |The powerful *pattern matching* feature allows to destructure and transform expressions in a concise way.
      |
      |Can you guess what this code does ?""".stripMargin
    )
    withWidget (
      scala(widgetId(pageId, 3))
        .withBaseFile(sourceFileResource("/examples/atasteofscala/intro/PatternMatching.scala"))
        .withDefaultValue(textFromResource("/examples/atasteofscala/intro/patternMatchingValue.sc"))
      )
    withWidget mk(
      widgetId(pageId, 4),
      """Try to modify the last line to get different results. Put "Bob" in place of Jane, or put your own
      |name and age!
      |
      |### Scala is functional
      |
      |Scala is a functional language in the sense that functions are first-class citizens. Scala's functions
      |can be passed around, nested, curried and partially applied. We'll get into the details of what these mean.
      |Scala has a lightweight syntax for anonymous functions. Functions that aren't members of a class can be grouped
      |in singleton objects, similar to the concept of module in other languages. This means you don't even have to write
      |object-oriented code. Scala supports both purely functional programming, object-oriented patterns, or both depending
      |on the problem at hand.
      |
      |Functional programming is a programming *paradigm*, a way of reasoning about software under a different angle than what
      |most programmers are used to. The goal of functional programming is to use **functions** as the primary building block of your
      |application, while minimizing **side-effects** (we'll get there). This makes software more reliable, easier to test and easier
      |to understand.
      |
      |### Scala is object oriented
      |
      |In Scala, every value is also an object. The language supports complex type hierarchies through classes and traits.
      |Traits support multiple-inheritance with the ability to mix interface declarations with behavior implementation.
      |Scala traits can act as *interfaces* and *mixins*, and they are the foundation for some of the most widely used patterns
      |in Scala.
      |
      |Imagine you have role-playing game where characters can combine abilities from different classes. Here's how
      |you can use traits to combine the abilities of Thief with those of a Wizard to create a new class of character.
      |""".stripMargin
    )
    withWidget (
      scala(widgetId(pageId, 5))
        .withDefaultValue(textFromResource("/examples/atasteofscala/intro/classValue.sc"))
        .wrapInMain
    )
    withWidget mk(
      widgetId(pageId, 6),
      """
      |### Scala interoperates
      |
      |Scala runs on the Java Virtual Machine, or *JVM* for short. It can also execute Java code, like your own Java classes or your favorite
      |Java library. Calling Java from Scala requires no syntax change, it just works. The goal of Scala is not to recreate what Java already
      |has, meaning if something exists in Java's standard library, you can just use it.
      |""".stripMargin
    ))
}
