package cl.sangut.heroesfightapp.views.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.FighterDetailsFragmentBinding
import cl.sangut.heroesfightapp.models.Fighters

class FighterDetails : Fragment() {

  private val allFighters = Fighters.createFighterList()
  private var fighterName = "0"
  private var _binding: FighterDetailsFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    _binding = FighterDetailsFragmentBinding.inflate(inflater, container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    arguments?.let {
      // obtenemos los parametros que me pase el otro fragment
      fighterName = FighterDetailsArgs.fromBundle(it).fighterName
      setFighterAttributes(fighterName)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  private fun setFighterAttributes(fighterName: String) {
    val name = _binding?.fighterNameTextView
    val intelligence = _binding?.fighterIntelligenceTextView
    val strength = _binding?.fighterStrengthTextView
    val speed = _binding?.fighterSpeedTextView
    val fighterImage = _binding?.fighterImageView

    val fighter = allFighters.find { it.fullName.toString() === fighterName }

    if (fighter != null) {
      name?.text = fighter.fullName.toString()
      intelligence?.text = fighter.intelligence.toString()
      strength?.text = fighter.strength.toString()
      speed?.text = fighter.speed.toString()
      fighterImage?.setImageResource(R.mipmap.ic_hero_example)
    }
  }

}
