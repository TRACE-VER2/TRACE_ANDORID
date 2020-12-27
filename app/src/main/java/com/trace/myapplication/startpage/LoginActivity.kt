package com.trace.myapplication.startpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trace.myapplication.MainActivity
import com.trace.myapplication.R
import com.trace.myapplication.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        //btn_login.setOnClickListener(){
        binding.btnLogin.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java));
            finish()
        }
        //btn_to_signup.setOnClickListener {
        binding.btnToSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}