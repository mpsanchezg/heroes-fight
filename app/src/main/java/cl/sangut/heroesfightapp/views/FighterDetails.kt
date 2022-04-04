package cl.sangut.heroesfightapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.FighterDetailsFragmentBinding

class FighterDetails : Fragment() {

  private var _binding: FighterDetailsFragmentBinding? = null
  private val binding get() = _binding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
    _binding = FighterDetailsFragmentBinding.inflate(inflater, container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setFighterAttributes()
  }

  private fun setFighterAttributes() {
    val intelligence = _binding?.fighterIntelligenceTextView
    val strength = _binding?.fighterStrengthTextView
    val speed = _binding?.fighterSpeedTextView
    val fighterImage = _binding?.fighterImageView

    intelligence?.text = "81"
    strength?.text = "73"
    speed?.text = "57"
    fighterImage?.setImageResource(R.mipmap.ic_hero_example)
  }

}
