package com.example.testandroidk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidk.model.Person

class PersonAdapter(private val persons: MutableList<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvnamePerson)
        fun bind( person :Person){
            name.text = person.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_person,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val curPerson = persons[position]
        holder.bind(curPerson)
    }

    override fun getItemCount(): Int {
        return persons.size
    }
}
