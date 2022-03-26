package cl.sangut.heroesfightapp.models

interface Fightable {
  fun attack(): Int
  fun avoidAttack(): Boolean
  fun takeDamage(damage: Int)
  fun isAlive(): Boolean
}
