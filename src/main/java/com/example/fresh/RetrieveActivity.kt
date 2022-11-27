package com.example.fresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.adapters.RetrieveAdapter
import com.example.fresh.adapters.VegAdapter
import com.example.fresh.data_classes.Meat
import com.example.fresh.data_classes.Meat2
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RetrieveActivity : AppCompatActivity() {
    private var dbref = Firebase.firestore
    private lateinit var retrieveRecyclerview : RecyclerView
    private lateinit var retrieveArrayList : ArrayList<Meat2>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve)

        retrieveRecyclerview = findViewById(R.id.retrieveList)
        retrieveRecyclerview.layoutManager = LinearLayoutManager(this)

        retrieveArrayList = arrayListOf()

        dbref = FirebaseFirestore.getInstance()

        dbref.collection("myRecipes").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val ret: Meat2? = data.toObject(Meat2::class.java)
                        if (ret != null) {
                            retrieveArrayList.add(ret)
                        }
                    }
                    retrieveRecyclerview.adapter = RetrieveAdapter(retrieveArrayList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }


    }
}