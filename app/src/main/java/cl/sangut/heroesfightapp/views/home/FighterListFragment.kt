package cl.sangut.heroesfightapp.views.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.databinding.FragmentFighterListBinding
import cl.sangut.heroesfightapp.models.Character
import cl.sangut.heroesfightapp.models.Fighters

class FighterListFragment : Fragment(), FighterItemAdapter.ActionListener {

  // declaramos el adapter
  private lateinit var fighterItemAdapter: FighterItemAdapter
  private val allFighters = Fighters.createFighterList()
  private var _binding: FragmentFighterListBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentFighterListBinding.inflate(inflater, container, false)

    // definimos el adapter, pasandole la mutable list y quien va a entregar eventos a
    // los elementos de la vista que contiene el adapter
    fighterItemAdapter = FighterItemAdapter(allFighters.toMutableList(), this)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val fighterListView = binding.fighterListView

    // aqui al layout manager del recycler view le decimos
    // que tipo de layout va a contener nuestros items.
    fighterListView.layoutManager = LinearLayoutManager(context)

    // aqui le entregamos el adapter
    fighterListView.adapter = fighterItemAdapter
  }

  override fun onResume() {
    super.onResume()
    binding.editTextSearchFighter.addTextChangedListener(object: TextWatcher{
      override fun afterTextChanged(p0: Editable?) {  }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        var searchText = p0.toString().lowercase()
        filterFighters(searchText)
      }
    })
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  private fun filterFighters(searchText: String) {
    val filteredFighters = allFighters.filter {
      it.fullName!!
        .lowercase()
        .contains(searchText)
    }

    fighterItemAdapter.updateFighters(filteredFighters)
  }

  override fun goToFighterDetails(fighter: Character) {
    Toast.makeText(context, "hola! hiciste click en el ${fighter.fullName}", Toast.LENGTH_LONG).show()
    /* ir al Fragment Fighter Details */
    // usando safe args...
    val bundle = bundleOf("fighterName" to fighter.fullName.toString())
    // llamamos la accion para navegar y el argumento entregado
    findNavController().navigate(R.id.action_fighterListFragment_to_fighterDetails, bundle)
  }
}
