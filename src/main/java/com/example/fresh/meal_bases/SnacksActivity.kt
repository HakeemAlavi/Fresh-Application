package com.example.fresh.meal_bases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.R
import com.example.fresh.adapters.SmoothieAdapter
import com.example.fresh.adapters.SnacksAdapter
import com.example.fresh.data_classes.Meat
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SnacksActivity : AppCompatActivity() {
    private var dbref = Firebase.firestore
    private lateinit var snacksRecyclerview : RecyclerView
    private lateinit var snacksArrayList : ArrayList<Meat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snacks)

        snacksRecyclerview = findViewById(R.id.snacksList)
        snacksRecyclerview.layoutManager = LinearLayoutManager(this)

        snacksArrayList = arrayListOf()

        dbref = FirebaseFirestore.getInstance()

        dbref.collection("Snacks").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val snacks: Meat? = data.toObject(Meat::class.java)
                        if (snacks != null) {
                            snacksArrayList.add(snacks)
                        }
                    }
                    snacksRecyclerview.adapter = SnacksAdapter(snacksArrayList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}