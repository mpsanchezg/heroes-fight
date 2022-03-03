# Heroes Fight

Esta aplicación consiste en un juego para Android, donde podrán elegir un héroe o villano y pelear con otros usuarios o el computador.

Durante el semestre veremos clase a clase ejemplos de los contenidos dentro de esta app.

## Clase 2: Introducción a Kotlin

### TODO
* Explorar el proyecto

* Crear interfaz
  - Fightable que tenga métodos: attack, avoidAttack, takeDamage, isAlive

* Crear modelos. Estos deben contener los siguientes atributos:
  - Character: fullName, healthPoints, stamina, intelligence, strength, speed
  - Hero: heredan de character, tipo fightable
  - Villain: heredan de character, tipo fightable
  
* Crear clase
  - Fight: debe obtener el heroe elegido y el enemigo. Esta debe tener los siguientes métodos:
    - turn: que se encargue de que cada uno pelee
    - start: que permita empezar la pelea
    - winner: que nos entregue el ganador
  
* Crear archivo "main.kt"
 - función main, que nos imprima el ganador
