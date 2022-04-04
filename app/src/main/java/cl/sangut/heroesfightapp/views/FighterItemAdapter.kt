package cl.sangut.heroesfightapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
      val fighterDetailsFragment = FighterDetails()

      activity
        ?.supportFragmentManager
        ?.beginTransaction()
        ?.replace(R.id.frame_container, fighterDetailsFragment)
        ?.addToBackStack("tag")
        ?.commit()
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
