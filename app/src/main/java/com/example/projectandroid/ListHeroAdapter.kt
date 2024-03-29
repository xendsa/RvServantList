package com.example.projectandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectandroid.databinding.ActivityMainBinding
import com.example.projectandroid.databinding.ItemRowHeroBinding

class ListHeroAdapter : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private var listOfHero = ArrayList<Hero>()

    fun addHeroList(list: List<Hero>) {
        this.listOfHero.clear()
        this.listOfHero.addAll(list)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val itemNow = listOfHero[position]

            Glide.with(itemView.context).load(itemNow.photo).fitCenter().into(binding.imgItemPhoto)

            binding.tvItemName.text = itemNow.name
            binding.tvItemDescription.text = itemNow.description

            binding.cardView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("heroData", itemNow)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemRowHeroBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return listOfHero.size
    }

}