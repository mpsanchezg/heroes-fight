package cl.sangut.heroesfightapp.models

data class Villain(
 override val fullName: String?,
 override var intelligence: Int,
 override var strength: Int,
 override var speed: Int,
): Character (
 fullName = fullName,
 intelligence = intelligence,
 strength = strength,
 speed = speed
), Fightable {

 init {
  stamina = (0..9).random()
 }

 override fun attack(): Int {
  return (intelligence + strength + speed)/100 * stamina!!
 }

 override fun avoidAttack(): Boolean {
  return (0..9).random() > 5
 }

 override fun takeDamage(damage: Int) {
  this.healthPoints -= damage
 }

 override fun isAlive() = characterAlive()
}

