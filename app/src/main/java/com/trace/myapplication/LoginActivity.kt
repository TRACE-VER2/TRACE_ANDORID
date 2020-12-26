package com.trace.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn_login.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java));
            finish()
        }
        btn_to_signup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}