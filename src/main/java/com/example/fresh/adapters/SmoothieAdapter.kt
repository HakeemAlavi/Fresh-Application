package com.example.fresh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.R
import com.example.fresh.data_classes.Meat

class SmoothieAdapter(private val meatList: ArrayList<Meat>) : RecyclerView.Adapter<SmoothieAdapter.SmoothieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmoothieViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.meal_item,parent,false)
        return SmoothieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SmoothieViewHolder, position: Int) {

        holder.Calories.text = meatList[position].calories
        holder.Duration.text = meatList[position].duration
        holder.Recipe.text = meatList[position].recipe
        holder.Procedure.text = meatList[position].procedure


    }

    override fun getItemCount(): Int {
        return meatList.size
    }

    class SmoothieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val Calories : TextView = itemView.findViewById(R.id.tvCalories)
        val Duration : TextView = itemView.findViewById(R.id.tvDuration)
        val Recipe : TextView = itemView.findViewById(R.id.tvRecipe)
        val Procedure : TextView = itemView.findViewById(R.id.tvProcedure)
        //val FoodImg : CircleImageView = itemView.findViewById(R.id.imgFood)
    }
}