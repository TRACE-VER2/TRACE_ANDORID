package com.trace.myapplication
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.trace.myapplication.R.*
import com.trace.myapplication.main.MainActivity
import com.trace.myapplication.startpage.LoginActivity


class SplashActivity : Activity() {

    val SPLASH_VIEW_TIME: Long = 3000 //4초간 스플래시 화면을 보여줌 (ms)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_splash)

        //val splashGif: ImageView = findViewById(id.gif_image) as ImageView
        //val gifImage = GlideDrawableImageViewTarget(splashGif)
        //Glide.with(this).load(raw.trace_splash4).into(splashGif)

        Handler().postDelayed({ //delay를 위한 handler

                startActivity(Intent(this, LoginActivity::class.java))

            finish()
        }, SPLASH_VIEW_TIME)


    }
}