package com.example.musicwiki.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.data.remote.model.TempObject


// TODO Don't take onClick in constructor
class MainAdapter(private val onClick: (TempObject) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View, val onClick: (TempObject) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.item_text)
        private val imageView: ImageView = itemView.findViewById(R.id.item_image)
        private var current: TempObject? = null

        init {
            itemView.setOnClickListener {
                current?.let {
                    onClick(it)
                }
            }
        }

        /* Bind item name and image. */
        fun bind(oneItem: TempObject) {
            current = oneItem
            textView.text = oneItem.name
            Glide.with(imageView).load(oneItem.image).into(imageView)
        }
    }

    var list: MutableList<TempObject> = mutableListOf()

    fun changeList(newList: List<TempObject>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            ),
            onClick
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val oneItem = list[position]
        holder.bind(oneItem)
    }
}