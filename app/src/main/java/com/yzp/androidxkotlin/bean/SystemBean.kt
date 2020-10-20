package com.yzp.androidxkotlin.bean


data class SystemBean(
    val children: List<Children>,
    val courseId: Double,
    val id: Double,
    val name: String,
    val order: Double,
    val parentChapterId: Double,
    val userControlSetTop: Boolean,
    val visible: Double
)

data class Children(
    val children: List<Any>,
    val courseId: Double,
    val id: Double,
    val name: String,
    val order: Double,
    val parentChapterId: Double,
    val userControlSetTop: Boolean,
    val visible: Double
)