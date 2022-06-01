package com.starmakerinteractive.starmak

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val pliinatAdasdfasStyletaoderacacent = findViewById<ConstraintLayout>(R.id.cl_parent)
        val teliinaetaoderacacerryiew = findViewById<TextView>(R.id.tv_name)

        val texliinatAdasdfasStyletaoderacacpha = ObjectAnimator.ofFloat(
            teliinaetaoderacacerryiew, View.ALPHA, 0F, 1F
        ).apply {
            duration = 800L
        }
        val sliinatAdasdfasStyletaoderacacerryleX = ObjectAnimator.ofFloat(
            pliinatAdasdfasStyletaoderacacent, View.SCALE_X, 0.98F, 1.1F
        ).apply {
            duration = 1000L
        }
        val scliinatAdasdfasStyletaoderacacerry = ObjectAnimator.ofFloat(
            pliinatAdasdfasStyletaoderacacent, View.SCALE_Y, 0.98F, 1.1F
        ).apply {
            duration = 1000L
        }

        AnimatorSet().apply {
            play(sliinatAdasdfasStyletaoderacacerryleX).with(scliinatAdasdfasStyletaoderacacerry)
        }.apply {
            doOnEnd {
                texliinatAdasdfasStyletaoderacacpha.apply {
                    doOnEnd { navigateToMainActivity() }
                    start()
                }
            }
            start()
        }
    }

    private fun navigateToMainActivity() {
        Intent(this, MainActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }
}