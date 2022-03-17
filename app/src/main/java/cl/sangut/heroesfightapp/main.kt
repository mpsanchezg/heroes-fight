package cl.sangut.heroesfightapp

import cl.sangut.heroesfightapp.models.Fight
import cl.sangut.heroesfightapp.models.Hero
import cl.sangut.heroesfightapp.models.Villain

fun main() {
  val hero = Hero("Hero", 50, 80, 30)
  val villain = Villain("Villain", 90, 10, 60)

  val fight = Fight(hero, villain)
  fight.start()
  print(fight.winner())
}
