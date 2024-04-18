package com.myapp.testhorizontal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapp.testhorizontal.databinding.FragmentTestBinding

class RvAdapter : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    class RvViewHolder(private val binding: FragmentTestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(text: String) {
            binding.text.text = text
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(
            FragmentTestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bindData(position.toString())
    }
}