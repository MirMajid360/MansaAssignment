package com.example.movieassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

import com.myapplication.databinding.ItemNumberBinding
import com.myapplication.models.NumberModel


class AdapterNumbers(var list:ArrayList<NumberModel>, val listener:IClickListener): RecyclerView.Adapter<AdapterNumbers.MoviesViewHolder>() {


   interface  IClickListener{
       fun onItemClicked(pos:Int)
   }
 inner   class MoviesViewHolder(val binding:ItemNumberBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(model: NumberModel,pos: Int){
             binding.value.text=""+model.value
            binding.plus.setOnClickListener {
                model.value++
                binding.value.text=""+model.value
            }
            binding.minus.setOnClickListener {
                model.value--
                binding.value.text=""+model.value
            }


            binding.print.setOnClickListener {
                listener.onItemClicked(pos)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemBinding =
            ItemNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
           holder.bind(list.get(position),position)
           holder.itemView.setOnLongClickListener {
               listener.onItemClicked(position)
               true
           }

    }




    override fun getItemCount(): Int {
        return list.size
    }
}