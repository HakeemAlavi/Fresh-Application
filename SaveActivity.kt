package com.example.fresh

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SaveActivity : AppCompatActivity() {
    private lateinit var etRecipe: EditText
    private lateinit var etDuration: EditText
    private lateinit var etCalories: EditText
    private lateinit var etProcedure: EditText
    private lateinit var btnCreate: Button

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

//Saving logic
        etRecipe = findViewById(R.id.stv_recipe)
        etDuration = findViewById(R.id.stv_duration)
        etCalories = findViewById(R.id.stv_calories)
        etProcedure = findViewById(R.id.stv_procedure)
        btnCreate = findViewById(R.id.button_save)

        btnCreate.setOnClickListener {
            val sRecipe = etRecipe.text.toString()
            val sDuration = etDuration.text.toString()
            val sCalories = etCalories.text.toString()
            val sProcedure = etProcedure.text.toString()

            saveFireStore(sRecipe, sDuration, sCalories, sProcedure)

        }

    }

    fun saveFireStore(recipe: String, duration: String, calories: String, procedure: String) {
//Notification logic
        createNotificationChannel()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Fresh Notification")
            .setContentText("Check out your new recipe in My Recipes! ")
            .setSmallIcon(R.drawable.recipe_icon)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

//Saving logic
        val db = FirebaseFirestore.getInstance()
        val arecipe: MutableMap<String, Any> = HashMap()
        arecipe["sRecipe"] = recipe
        arecipe["sDuration"] = duration
        arecipe["sCalories"] = calories
        arecipe["sProcedure"] = procedure

        db.collection("myRecipes")

            .add(arecipe)
            .addOnSuccessListener {

                if ( ( etRecipe.getText().toString().trim().equals(""))||
                ( etDuration.getText().toString().trim().equals(""))||
                ( etCalories.getText().toString().trim().equals(""))||
                ( etProcedure.getText().toString().trim().equals(""))
                        )
                {
                    Toast.makeText(getApplicationContext(), "Fill in all fields", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(
                        this@SaveActivity,
                        "Record Added Successfully ",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    etRecipe.text.clear()
                    etDuration.text.clear()
                    etCalories.text.clear()
                    etProcedure.text.clear()
                    notificationManager.notify(NOTIFICATION_ID, notification)

                }
            }
            .addOnFailureListener {
                Toast.makeText(this@SaveActivity, "Record Failed To Add ", Toast.LENGTH_SHORT)
                    .show()
            }

    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )

            channel.lightColor = Color.GREEN
            channel.enableLights(true)

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}