package com.yzp.androidxkotlin.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yzp.androidxkotlin.R

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }
}