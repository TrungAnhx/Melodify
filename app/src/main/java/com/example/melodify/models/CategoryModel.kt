package com.example.melodify.models

data class CategoryModel(
    val name: String = "",
    val coverUrl: String = "",
) {
    constructor() : this("", "")
}
