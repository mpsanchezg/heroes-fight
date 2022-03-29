package cl.sangut.heroesfightapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.LoginFragmentBinding


class LoginFragment : Fragment() {

  private var _binding: LoginFragmentBinding? = null
  private val binding get() = _binding!!
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = LoginFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    loginAction()
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  private fun loginAction() {
    val loginButton = _binding?.loginButton

    loginButton?.setOnClickListener {
      val fighterListFragment = FighterListFragment()
      activity
        ?.supportFragmentManager
        ?.beginTransaction()
        ?.replace(R.id.frame_container, fighterListFragment)
        ?.commit()
    }
  }
}
