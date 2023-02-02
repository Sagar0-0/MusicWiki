package com.example.musicwiki.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.musicwiki.R
import com.example.musicwiki.data.remote.model.TestObject
import kotlinx.android.synthetic.main.list_item.view.*
import javax.inject.Inject

class MainAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    lateinit var clickListener: (item: TestObject) -> Unit

    var list: MutableList<TestObject> = mutableListOf()

    fun changeList(newList: List<TestObject>) {
        list.clear()
        list.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val oneItem = list[position]
        holder.itemView.apply {
            glide.load(oneItem.image).into(item_image)
            item_text.text = oneItem.name
        }
        holder.itemView.setOnClickListener { clickListener(oneItem) }
    }
}