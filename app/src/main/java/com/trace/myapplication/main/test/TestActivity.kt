package com.trace.myapplication.main.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trace.myapplication.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity(){
    private val vBinding by lazy{ActivityTestBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vBinding.root)
    }
}