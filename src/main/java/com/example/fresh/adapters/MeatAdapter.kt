package com.example.fresh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fresh.data_classes.Meat
import com.example.fresh.R

class MeatAdapter(private val meatList: ArrayList<Meat>) : RecyclerView.Adapter<MeatAdapter.MeatViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeatViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.meal_item,parent,false)
        return MeatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MeatViewHolder, position: Int) {

        holder.Calories.text = meatList[position].calories
        holder.Duration.text = meatList[position].duration
        holder.Recipe.text = meatList[position].recipe
        holder.Procedure.text = meatList[position].procedure


    }

    override fun getItemCount(): Int {
        return meatList.size
    }

    class MeatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val Calories : TextView = itemView.findViewById(R.id.tvCalories)
        val Duration : TextView = itemView.findViewById(R.id.tvDuration)
        val Recipe : TextView = itemView.findViewById(R.id.tvRecipe)
        val Procedure : TextView = itemView.findViewById(R.id.tvProcedure)
        //val FoodImg : CircleImageView = itemView.findViewById(R.id.imgFood)
    }
}