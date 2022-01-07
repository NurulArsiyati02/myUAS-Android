package com.nurul.myuas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nurul.myuas.Model
import com.nurul.myuas.R

class Adapter (
    val mebel: ArrayList<Model.Data>
): RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val data = mebel[position]
        holder.textJudul.text = data.jenis
        holder.textKategori.text = data.kategori
    }

    override fun getItemCount() = mebel.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textJudul = view.findViewById<TextView>(R.id.textjudul)
        val textKategori = view.findViewById<TextView>(R.id.textkategori)
    }
    public fun setData(data: List<Model.Data>){
        mebel.clear()
        mebel.addAll(data)
        notifyDataSetChanged()
    }

}