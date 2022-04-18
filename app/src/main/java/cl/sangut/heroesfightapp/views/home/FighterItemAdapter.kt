package cl.sangut.heroesfightapp.views.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.sangut.heroesfightapp.R
import cl.sangut.heroesfightapp.models.Character

class FighterItemAdapter(
    private val fighters: MutableList<Character>,
    private val actionListener: ActionListener
  ) : RecyclerView.Adapter<FighterItemAdapter.ViewHolder>() {

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Buscamos una única vez los views de la vista que contiene nuestro item
    // en este caso, fighter_item.
    val fighterName = itemView.findViewById<TextView>(R.id.fighterNameTextView)!!
    val fighterType = itemView.findViewById<TextView>(R.id.fighterTypeTextView)!!
    val fighterImage = itemView.findViewById<ImageView>(R.id.fighterImageView)!!
    val fighterItem = itemView.findViewById<ViewGroup>(R.id.fighterItem)!!
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FighterItemAdapter.ViewHolder {
    // obtenemos el contexto del parent
    val context = parent.context
    // le pedimos el inflater al parent
    val inflater = LayoutInflater.from(context)

    // aqui "inflamos" la vista del parent con nuestro fighter item
    val fighterView: View = inflater.inflate(R.layout.fighter_item, parent, false)

    // para crear el viewholder, le pasamos la vista
    return ViewHolder(fighterView)
  }

  override fun onBindViewHolder(holder: FighterItemAdapter.ViewHolder, position: Int) {
    // aqui le decimos que hacer al view holder
    // para que podamos editar, manipular o entregar eventos
    // a los elementos de la vista
    val fighter: Character = fighters[position]

    val name = holder.fighterName
    val type = holder.fighterType
    val image = holder.fighterImage
    val detailsButton = holder.fighterItem

    name.text = fighter.fullName
    type.text = fighterType(fighter)
    image.setImageResource(R.mipmap.ic_hero_example)

    detailsButton.setOnClickListener {
      actionListener.goToFighterDetails(fighter)
    }
  }

  override fun getItemCount(): Int {
    return fighters.size
  }

  // esta funcion notifica al adapter cuando cambia el
  // dataset definido al principio, en el constructor
  @SuppressLint("NotifyDataSetChanged")
  fun updateFighters(newFighters: List<Character>) {
    fighters.clear()

    fighters.addAll(newFighters)
    notifyDataSetChanged()
  }

  // esta funcion obtiene la clase de mi objeto
  private fun fighterType(fighter: Character): String {
    return fighter.javaClass.simpleName
  }

  // Para que podamos utilizar este adapter en diversos fragments
  // creamos una interfaz, donde el fragment que requiera de este
  // adapter pueda entregar una accion a un elemento. En este caso,
  // el fin de este item es ver los detalles de un fighter, por lo
  // que definimos dicha funcion. Podria ser un nombre un poco
  // mas generico? a lo mejor si, depende del fin de tu adapter
  interface ActionListener {
    fun goToFighterDetails(fighter: Character)
  }
}
