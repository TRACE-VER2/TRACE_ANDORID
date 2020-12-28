package com.trace.myapplication.startpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.trace.myapplication.R

class SignupActivity : AppCompatActivity() {
    private lateinit var appBarSignupConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val navHostSignupFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_signup) as NavHostFragment
        //val navSignupController = navHostSignupFragment.navController
        //appBarSignupConfiguration = AppBarConfiguration(navSignupController.graph)
        //setupActionBarWithNavController(navSignupController, appBarSignupConfiguration)
        //setupActionBarWithNavController(navSignupController)
    }
/* Appbar setting
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_signup)
        return navController.navigateUp(appBarSignupConfiguration)
                || super.onSupportNavigateUp()
    }

 */
}