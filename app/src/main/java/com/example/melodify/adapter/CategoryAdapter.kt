package com.example.melodify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.melodify.databinding.CategoryItemRecyclerRowBinding
import com.example.melodify.models.CategoryModel

class CategoryAdapter(private val categoryList: List<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: CategoryItemRecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Bind the data with views
        fun bindData(category: CategoryModel) {
            binding.nameTextView.text = category.name

            // Use Glide to load the image
            Glide.with(binding.coverImageView.context)
                .load(category.coverUrl) // URL from Firestore
                .placeholder(com.example.melodify.R.drawable.placeholder_image) // Placeholder while loading
                .error(com.example.melodify.R.drawable.error_image) // Fallback image if URL is invalid
                .into(binding.coverImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}
