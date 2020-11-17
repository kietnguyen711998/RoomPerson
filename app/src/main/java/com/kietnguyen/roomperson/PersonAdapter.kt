package com.kietnguyen.roomperson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kietnguyen.roomperson.model.Person
import kotlinx.android.synthetic.main.stuff_item.view.*

class PersonAdapter(val listPerson: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    private lateinit var db: PersonDatabase
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stuff_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        holder.itemView.tv_name.text = listPerson[position].name
        holder.itemView.tv_address.text = listPerson[position].address

        PersonDatabase.getInstance(holder.itemView.context)?.let {
            db = it

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}