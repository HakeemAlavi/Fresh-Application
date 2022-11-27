package com.example.fresh.meal_bases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.R
import com.example.fresh.adapters.BreakfastAdapter
import com.example.fresh.adapters.VegAdapter
import com.example.fresh.data_classes.Meat
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BreakfastActivity : AppCompatActivity() {
    private var dbref = Firebase.firestore
    private lateinit var BFRecyclerview : RecyclerView
    private lateinit var BFArrayList : ArrayList<Meat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)

        BFRecyclerview = findViewById(R.id.BFList)
        BFRecyclerview.layoutManager = LinearLayoutManager(this)

        BFArrayList = arrayListOf()

        dbref = FirebaseFirestore.getInstance()

        dbref.collection("RecipesBF").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val bf: Meat? = data.toObject(Meat::class.java)
                        if (bf != null) {
                            BFArrayList.add(bf)
                        }
                    }
                    BFRecyclerview.adapter = BreakfastAdapter(BFArrayList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}