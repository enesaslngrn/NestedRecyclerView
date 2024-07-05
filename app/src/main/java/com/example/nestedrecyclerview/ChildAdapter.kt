package com.example.nestedrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ChildItemBinding

class ChildAdapter(private val childList : List<ChildData>) : RecyclerView.Adapter<ChildAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ChildItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildAdapter.ViewHolder {
        val binding = ChildItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildAdapter.ViewHolder, position: Int) {
        val currentItem = childList[position]
        holder.binding.ivChild.setImageResource(currentItem.logo)
        holder.binding.tvChildTitle.text = currentItem.title
    }

}