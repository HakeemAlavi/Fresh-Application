package com.example.fresh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.R
import com.example.fresh.data_classes.Meat
import com.example.fresh.data_classes.Meat2

class RetrieveAdapter(private val meatList: ArrayList<Meat2>) : RecyclerView.Adapter<RetrieveAdapter.RetrieveViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrieveViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.meal_item,parent,false)
        return RetrieveViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RetrieveViewHolder, position: Int) {

        holder.Calories.text = meatList[position].sCalories
        holder.Duration.text = meatList[position].sDuration
        holder.Recipe.text = meatList[position].sRecipe
        holder.Procedure.text = meatList[position].sProcedure


    }

    override fun getItemCount(): Int {
        return meatList.size
    }

    class RetrieveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val Calories : TextView = itemView.findViewById(R.id.tvCalories)
        val Duration : TextView = itemView.findViewById(R.id.tvDuration)
        val Recipe : TextView = itemView.findViewById(R.id.tvRecipe)
        val Procedure : TextView = itemView.findViewById(R.id.tvProcedure)
        //val FoodImg : CircleImageView = itemView.findViewById(R.id.imgFood)
    }
}