package com.example.fresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.example.fresh.meal_bases.MeatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val cardrecipe = findViewById<CardView>(R.id.card_recipes)
        val cardmyrecipes = findViewById<CardView>(R.id.card_myrecipes)
        val cardcreate = findViewById<CardView>(R.id.card_createrecipe)
        val cardtips = findViewById<CardView>(R.id.card_tips)

        cardrecipe.setOnClickListener {
            var intentCardRecipe = Intent(this, IntroActivity::class.java)
            startActivity(intentCardRecipe)
        }

        cardcreate.setOnClickListener {
            var intentCardCreate = Intent(this, SaveActivity::class.java)
            startActivity(intentCardCreate)
        }

        cardmyrecipes.setOnClickListener {
            var intentCardMyRecipes = Intent(this, RetrieveActivity::class.java)
            startActivity(intentCardMyRecipes)
        }

        cardtips.setOnClickListener {
            var intentCardTips = Intent(this, TipsActivity::class.java)
            startActivity(intentCardTips)
        }

    }
}