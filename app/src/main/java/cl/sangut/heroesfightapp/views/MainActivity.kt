package cl.sangut.heroesfightapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.ActivityMainBinding
import cl.sangut.heroesfightapp.views.signin.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  private var _binding: ActivityMainBinding? = null
  private val binding get() = _binding
  private lateinit var navigationController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding?.root)

    // Buscamos el navigation view
    val navigationView: BottomNavigationView = binding?.navigationView!!

    // buscamos el nav host
    val navHostFragment =
      (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)) as NavHostFragment
    navigationController = navHostFragment.navController

    NavigationUI.setupActionBarWithNavController(this, navigationController)

    // seteamos las navegaciones que van en la barra
    val appBarConfiguration = AppBarConfiguration(
      setOf(R.id.nav_graph)
    )
    // seteamos el action bar con el navigation controller y la confiuración creada
    setupActionBarWithNavController(navigationController, appBarConfiguration)
    // le decimos al navigation view cual va a ser su controlador
    navigationView.setupWithNavController(navigationController)
  }

  override fun onSupportNavigateUp(): Boolean {
    return NavigationUI.navigateUp(navigationController, null)
  }
}
