package com.example.melodify

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.melodify.adapter.CategoryAdapter
import com.example.melodify.databinding.ActivityMainBinding
import com.example.melodify.databinding.CategoryItemRecyclerRowBinding
import com.example.melodify.models.CategoryModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var categoryAdapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategories()
    }

    fun getCategories() {
        FirebaseFirestore.getInstance().collection("category")
            .get()
            .addOnSuccessListener { documents ->
                val categoryList = documents.toObjects(CategoryModel::class.java)
                if (categoryList.isNotEmpty()) {
                    Log.d("MainActivity", "Categories: $categoryList")  // Kiểm tra dữ liệu
                    setupCategoryRecyclerView(categoryList)
                } else {
                    Log.e("MainActivity", "No categories found")
                }
            }
            .addOnFailureListener { e ->
                Log.e("MainActivity", "Error fetching categories", e) // Log lỗi
            }
    }




    fun setupCategoryRecyclerView(categoryList: List<CategoryModel>){
        categoryAdapter = CategoryAdapter(categoryList)
        binding.categoriesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView.adapter = categoryAdapter
    }

}