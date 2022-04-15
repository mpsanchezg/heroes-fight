package cl.sangut.heroesfightapp.views.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

  private var _binding: FragmentHomeBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    goToFighterList()
  }

  private fun goToFighterList() {
    val goToListButton = _binding?.seeListButton
    goToListButton?.setOnClickListener {
      findNavController().navigate(R.id.action_homeFragment_to_fighterListFragment)
    }
  }
}
