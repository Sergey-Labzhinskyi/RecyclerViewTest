package com.example.recyclerviewtest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.Animals.Companion.TYPE_CAT
import com.example.recyclerviewtest.Animals.Companion.TYPE_DOG
import com.example.recyclerviewtest.Animals.Companion.TYPE_ELEPHANT
import com.example.recyclerviewtest.Animals.Companion.TYPE_MONKEY
import com.example.recyclerviewtest.Animals.Companion.TYPE_TIGER

class AnimalAdapter(private val data: List<Animals>, private val listener: AnimalClickListener) : RecyclerView.Adapter<BaseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        Log.d("Recycler", "onCreateViewHolder() $viewType")
        return when (viewType) {
            TYPE_DOG -> BaseViewHolder.Dog(setInflate(viewType, parent))
            TYPE_CAT -> BaseViewHolder.Cat(setInflate(viewType, parent))
            TYPE_ELEPHANT -> BaseViewHolder.Elephant(setInflate(viewType, parent))
            TYPE_TIGER -> BaseViewHolder.Tiger(setInflate(viewType, parent))
            TYPE_MONKEY -> BaseViewHolder.Monkey(setInflate(viewType, parent))
            else -> throw IllegalArgumentException("Other type $viewType")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = data[position]
        Log.d("Recycler", "onBindViewHolder() $holder")
        when (item.animalsType) {
            TYPE_DOG -> (holder as BaseViewHolder.Dog).bind(item as Animals.Dog, listener)
            TYPE_CAT -> (holder as BaseViewHolder.Cat).bind(item as Animals.Cat, listener)
            TYPE_ELEPHANT -> (holder as BaseViewHolder.Elephant).bind(item as Animals.Elephant, listener)
            TYPE_TIGER -> (holder as BaseViewHolder.Tiger).bind(item as Animals.Tiger, listener)
            TYPE_MONKEY -> (holder as BaseViewHolder.Monkey).bind(item as Animals.Monkey, listener)
        }
    }

    override fun getItemCount(): Int {
        Log.d("Recycler", "getItemCount() ${data.size}")
        return data.size
    }

    private fun setInflate(layout: Int, parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layout, parent, false)
    }

    override fun getItemViewType(position: Int): Int = data[position].animalsType
}

sealed class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    class Dog(view: View) : BaseViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val age = view.findViewById<TextView>(R.id.tvAge)
        private val weight = view.findViewById<TextView>(R.id.tvWeight)

        fun bind(item: Animals.Dog, listener: AnimalClickListener) {
            name.text = item.name
            age.text = item.age.toString()
            weight.text = item.weight.toString()
            itemView.setOnClickListener { listener.onDogClicked(item) }
        }
    }

    class Cat(view: View) : BaseViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val age = view.findViewById<TextView>(R.id.tvAge)
        private val weight = view.findViewById<TextView>(R.id.tvWeight)

        fun bind(item: Animals.Cat, listener: AnimalClickListener) {
            name.text = item.name
            age.text = item.age.toString()
            weight.text = item.weight.toString()
            itemView.setOnClickListener { listener.onCatClicked(item) }
        }
    }

    class Elephant(view: View) : BaseViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val age = view.findViewById<TextView>(R.id.tvAge)
        private val weight = view.findViewById<TextView>(R.id.tvWeight)

        fun bind(item: Animals.Elephant, listener: AnimalClickListener) {
            name.text = item.name
            age.text = item.age.toString()
            weight.text = item.weight.toString()
            itemView.setOnClickListener { listener.onElephantClicked(item) }
        }
    }

    class Tiger(view: View) : BaseViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val age = view.findViewById<TextView>(R.id.tvAge)
        private val weight = view.findViewById<TextView>(R.id.tvWeight)
        private val country = view.findViewById<TextView>(R.id.tvCountry)


        fun bind(item: Animals.Tiger, listener: AnimalClickListener) {
            name.text = item.name
            age.text = item.age.toString()
            weight.text = item.weight.toString()
            country.text = item.country
            itemView.setOnClickListener { listener.onTigerClicked(item) }
        }
    }

    class Monkey(view: View) : BaseViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val age = view.findViewById<TextView>(R.id.tvAge)
        private val weight = view.findViewById<TextView>(R.id.tvWeight)
        private val country = view.findViewById<TextView>(R.id.tvCountry)

        fun bind(item: Animals.Monkey, listener: AnimalClickListener) {
            name.text = item.name
            age.text = item.age.toString()
            weight.text = item.weight.toString()
            country.text = item.country
            itemView.setOnClickListener { listener.onMonkeyClicked(item) }
        }
    }
}

interface AnimalClickListener {
    fun onDogClicked(dog: Animals.Dog)
    fun onCatClicked(cat: Animals.Cat)
    fun onElephantClicked(elephant: Animals.Elephant)
    fun onMonkeyClicked(monkey: Animals.Monkey)
    fun onTigerClicked(tiger: Animals.Tiger)
}