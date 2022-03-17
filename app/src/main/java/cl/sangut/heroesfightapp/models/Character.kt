package cl.sangut.heroesfightapp.models

open class Character(
  open val fullName: String?,
  internal var healthPoints: Int = 100,
  var stamina: Int? = null,
  open var intelligence: Int = 0,
  open var strength: Int = 0,
  open var speed: Int = 0
) {
  fun characterAlive(): Boolean {
    return healthPoints > 0
  }
}
