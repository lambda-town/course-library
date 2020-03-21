abstract class Character {
  val name: String
}

trait Magic {
  def castSpell() = println("Woosh!")
}

trait Stealth {
  def sneakBehind(target: Character) = println(s"You've stolen ${target.name}'s purse!")
}

class Wizard(val name: String) extends Character with Magic

// Wizard AND Thief, because why not ?
class WizardThief(val name: String) extends Character with Stealth with Magic

val player = new WizardThief("Olugorim The Great")
val npc = new Wizard("Ezor The Fierce")

player.castSpell()
player.sneakBehind(npc)