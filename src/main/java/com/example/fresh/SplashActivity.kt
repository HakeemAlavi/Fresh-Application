package com.example.fresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var iv_recipe: ImageView = findViewById(R.id.imageView)
        iv_recipe.alpha = 0f
        iv_recipe.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent(this, MenuActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}