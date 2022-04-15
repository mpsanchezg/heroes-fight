package cl.sangut.heroesfightapp.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.FighterItemBinding

class FighterItemAdapter : Fragment() {

  private var _binding: FighterItemBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FighterItemBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    goToDetailsFragment()
    setAttributesToItem()
  }

  private fun goToDetailsFragment() {
    val detailsButton = _binding?.fighterDetailsButton

    detailsButton?.setOnClickListener {
      // si quiero entregar parámetros, se utiliza
      // bundle para pasar el valor del parametro (con safe args)
      val bundle = bundleOf("fighterName" to "Spider Woman")
      // se llama a la navegacion
      Navigation.findNavController(it).navigate(R.id.action_fighterListFragment_to_fighterDetails, bundle)
    }
  }

  private fun setAttributesToItem() {
    val fighterName = _binding?.fighterNameTextView
    val fighterType = _binding?.fighterTypeTextView
    val fighterImage = _binding?.fighterImageView
    fighterName?.text = "Spider Woman"
    fighterType?.text = "Hero"
    fighterImage?.setImageResource(R.mipmap.ic_hero_example)
  }
}
