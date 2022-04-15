package cl.sangut.heroesfightapp.models

class Fighters {
  companion object {
    fun createFighterList() : ArrayList<Character> {
      val characters = ArrayList<Character>()
      characters.add(Hero("Spider Woman", intelligence = 77, speed = 37, strength = 61))
      characters.add(Hero("Spider Man", intelligence = 57, speed = 76, strength = 83))
      characters.add(Villain("Joker", intelligence = 99, speed = 40, strength = 38))
      characters.add(Hero("Batman", intelligence = 95, speed = 45, strength = 76))
      characters.add(Villain("Mapi", intelligence = 95, speed = 45, strength = 76))
      characters.add(Villain("Vicente", intelligence = 95, speed = 45, strength = 76))
      characters.add(Hero("Pepe", intelligence = 95, speed = 45, strength = 76))
      characters.add(Hero("Matias", intelligence = 95, speed = 45, strength = 76))
      characters.add(Hero("Lucas", intelligence = 95, speed = 45, strength = 76))

      return characters
    }
  }
}
