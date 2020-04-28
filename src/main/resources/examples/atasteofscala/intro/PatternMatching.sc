import lambda.utils.Emojis.{heavyCheckMark, robot}
import lambda.utils.captureStdOut

object Main extends App {
  val (_, stdOut) = captureStdOut[Any]({
    //[userInput
    //]
  })

  print(stdOut)
  println()
  if (stdOut.contains("Hi there, Jane")) {
    println(s"$robot We've got a nice greeting message for Jane! Now try to replace 'Jane' with 'Bob' in the last line, and see what happens :)")
  }
  else if (stdOut.contains("Bob")) {
    println(s"$robot $heavyCheckMark Well done! Now try to replace Bob with another name, and put your age to see what happens.")
  }
  else if (stdOut.contains("is a great age to learn Scala")) {
    println(s"$robot $heavyCheckMark Great! You did your very first pattern matching right there!")
    println("Pattern matching allows you to extract values of compound types such as this User class, and return an expression based on these values, in a concise way. We will use that a lot in this course.")
  } else {
    println(s"$robot I see you've done something different here. It's nice to experiment. Don't hesitate to reset the code when you've done something wrong.")
  }
}

