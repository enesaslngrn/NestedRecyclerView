package com.example.nestedrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ParentItemBinding

class ParentAdapter(private val parentList : List<ParentData>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ParentItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return parentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentAdapter.ViewHolder {
        val binding = ParentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParentAdapter.ViewHolder, position: Int) {
        val currentItem = parentList[position]
        holder.binding.tvParentTitle.text = currentItem.title
        holder.binding.childRecyclerView.apply {
            adapter = ChildAdapter(currentItem.childData)
            layoutManager = GridLayoutManager(holder.itemView.context,3,GridLayoutManager.VERTICAL,false)
        }
    }

}