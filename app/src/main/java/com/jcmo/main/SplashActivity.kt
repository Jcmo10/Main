package com.jcmo.main


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        val timer = Timer()
        timer.schedule(
            timerTask {
                gotoMainActivity()

            },2000
        )

    }

    private fun gotoMainActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}
