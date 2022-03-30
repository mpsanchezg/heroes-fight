package cl.sangut.heroesfightapp.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.FragmentFighterListBinding

class FighterListFragment : Fragment() {

  private var _binding: FragmentFighterListBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentFighterListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    addFighterItem()
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  private fun addFighterItem() {
    val fighterItemAdapter = FighterItemAdapter()

    activity
      ?.supportFragmentManager
      ?.beginTransaction()
      ?.replace(R.id.heroListView, fighterItemAdapter)
      ?.commit()
  }
}
