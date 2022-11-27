package com.example.fresh.meal_bases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.R
import com.example.fresh.adapters.MeatAdapter
import com.example.fresh.data_classes.Meat
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class MeatActivity : AppCompatActivity() {

    private var dbref = Firebase.firestore
    private lateinit var meatRecyclerview : RecyclerView
    private lateinit var meatArrayList : ArrayList<Meat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meat)

        meatRecyclerview = findViewById(R.id.meatList)
        meatRecyclerview.layoutManager = LinearLayoutManager(this)

        meatArrayList = arrayListOf()

        dbref = FirebaseFirestore.getInstance()

        dbref.collection("Recipes").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val meat: Meat? = data.toObject(Meat::class.java)
                        if (meat != null) {
                            meatArrayList.add(meat)
                        }
                    }
                    meatRecyclerview.adapter = MeatAdapter(meatArrayList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }

    }
}