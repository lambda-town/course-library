case class User(name: String, age: Int)

def greetUser(user: User) = user match {
  case User("Jane", _) => println("Hi there, Jane")
  case User("Bob", _) => println("Nice to see you Bob!")
  case User(name, age) => println(s"Hey there $name, $age is a great age to learn Scala!")
}

greetUser(User("Jane", 28))