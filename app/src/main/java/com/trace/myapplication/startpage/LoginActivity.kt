package com.trace.myapplication.startpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.trace.myapplication.R
import com.trace.myapplication.databinding.ActivityLoginBinding
import com.trace.myapplication.main.MainActivity
import com.trace.myapplication.startpage.dataType.RequestLogin
import com.trace.myapplication.network.Repository
import com.trace.myapplication.startpage.dataType.ResponseLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var myjwt="";
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    val requestToServer = Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //btn_to_signup.setOnClickListener {
        binding.btnToSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }


        //btn_login.setOnClickListener(){
        binding.btnLogin.setOnClickListener(){
            if (binding.loginEtId.text.isNullOrBlank() || binding.loginEtPw.text.isNullOrBlank()) {
                Toast.makeText(this, "이메일과 비밀번호를 모두 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                //로그인 요청
                requestToServer.service.requestLogin(
                    RequestLogin(
                        userId = binding.loginEtId.text.toString(),
                        password = binding.loginEtPw.text.toString()
                    )   //로그인 정보를 전달
                ).enqueue(object : Callback<ResponseLogin> {
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Log.d("통신 실패", "${t.message }")
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if (response.isSuccessful) {
                            if (response.body()!!.success) {
                                Log.d("성공", response.body()!!.data.toString())
                                myjwt=response.body()!!.data!!.accessToken
                                startActivity(Intent(this@LoginActivity, MainActivity::class.java));
                                finish()

                            } else {
                                Log.d("실패", "실패")
                                Toast.makeText(this@LoginActivity, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }


        }



    }
}