package com.example.fresh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.R
import com.example.fresh.data_classes.Meat

class SnacksAdapter(private val meatList: ArrayList<Meat>) : RecyclerView.Adapter<SnacksAdapter.SnacksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnacksViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.meal_item,parent,false)
        return SnacksViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SnacksViewHolder, position: Int) {

        holder.Calories.text = meatList[position].calories
        holder.Duration.text = meatList[position].duration
        holder.Recipe.text = meatList[position].recipe
        holder.Procedure.text = meatList[position].procedure


    }

    override fun getItemCount(): Int {
        return meatList.size
    }

    class SnacksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val Calories : TextView = itemView.findViewById(R.id.tvCalories)
        val Duration : TextView = itemView.findViewById(R.id.tvDuration)
        val Recipe : TextView = itemView.findViewById(R.id.tvRecipe)
        val Procedure : TextView = itemView.findViewById(R.id.tvProcedure)
        //val FoodImg : CircleImageView = itemView.findViewById(R.id.imgFood)
    }
}