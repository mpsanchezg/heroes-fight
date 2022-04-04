package cl.sangut.heroesfightapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.sangut.heroesfightapp.R

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val loginFragment = LoginFragment()
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.frame_container, loginFragment)
      .commit()
  }
}
