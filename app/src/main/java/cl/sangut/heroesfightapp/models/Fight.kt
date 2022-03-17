package cl.sangut.heroesfightapp.models

class Fight(private val fightable1: Fightable, private val figtable2: Fightable) {

  // TODO: Poner variables privadas
  private val first: Fightable
  private val second: Fightable
  init {
    var fighters = listOf(fightable1, figtable2)
    fighters = fighters.shuffled()

    first = fighters[0]
    second = fighters[1]
  }

  fun start() {
    while(areAlive()) {
      turn(first.attack(), second)
      if (second.isAlive()) turn(second.attack(), first)
    }
  }

  private fun turn(damage: Int, opponent: Fightable) {
    if(!opponent.avoidAttack()) {
      opponent.takeDamage(damage)
    }
  }

  fun winner(): Fightable? {
    if (areAlive()) return null
    return if(first.isAlive()) first else second
  }

  private fun areAlive(): Boolean {
    return first.isAlive() && second.isAlive()
  }
}
