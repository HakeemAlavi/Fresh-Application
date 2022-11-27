package com.example.fresh.meal_bases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.R
import com.example.fresh.adapters.BreakfastAdapter
import com.example.fresh.adapters.SmoothieAdapter
import com.example.fresh.data_classes.Meat
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SmoothieActivity : AppCompatActivity() {
    private var dbref = Firebase.firestore
    private lateinit var smoothieRecyclerview : RecyclerView
    private lateinit var smoothieArrayList : ArrayList<Meat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smoothie)

        smoothieRecyclerview = findViewById(R.id.smoothieList)
        smoothieRecyclerview.layoutManager = LinearLayoutManager(this)

        smoothieArrayList = arrayListOf()

        dbref = FirebaseFirestore.getInstance()

        dbref.collection("FruitSmoothies").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val smoothie: Meat? = data.toObject(Meat::class.java)
                        if (smoothie != null) {
                            smoothieArrayList.add(smoothie)
                        }
                    }
                    smoothieRecyclerview.adapter = SmoothieAdapter(smoothieArrayList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}