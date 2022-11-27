package com.example.fresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.fresh.meal_bases.*

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)


        val imageMeats = findViewById<CardView>(R.id.card_carnivore)
        val imageVegetables = findViewById<CardView>(R.id.card_vegetable)
        val imageBreakfast = findViewById<CardView>(R.id.card_breakfast)
        val imageSmoothie = findViewById<CardView>(R.id.card_smoothie)
        val imageSnacks = findViewById<CardView>(R.id.card_snacks)


        imageMeats.setOnClickListener {
            var intentMeatActivity = Intent(this, MeatActivity::class.java)
            startActivity(intentMeatActivity)
        }

        imageVegetables.setOnClickListener {
            var intentVegetableActivity = Intent(this, VegetableActivity::class.java)
            startActivity(intentVegetableActivity)
        }

        imageBreakfast.setOnClickListener {
            var intentBreakfastActivity = Intent(this, BreakfastActivity::class.java)
            startActivity(intentBreakfastActivity)
        }

        imageSmoothie.setOnClickListener {
            var intentSmoothieActivity = Intent(this, SmoothieActivity::class.java)
            startActivity(intentSmoothieActivity)
        }

        imageSnacks.setOnClickListener {
            var intentSnacksActivity = Intent(this, SnacksActivity::class.java)
            startActivity(intentSnacksActivity)
        }


    }
    private fun displayToast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}