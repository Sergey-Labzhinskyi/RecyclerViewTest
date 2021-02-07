package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.Animals
import com.example.recyclerviewtest.Animals.*

class MainActivity : AppCompatActivity(), AnimalClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimalAdapter
    private val animalList by lazy { getAnimals() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = AnimalAdapter(animalList, this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    private fun getAnimals(): List<Animals>{
        val list = mutableListOf<Animals>()
        list.add(Dog("Dog", 5, 15))
        list.add(Cat("Cat", 10, 10))
        list.add(Elephant("Elephant", 50, 120))
        list.add(Tiger("Tiger", 20, 50, "China"))
        list.add(Monkey("Monkey", 50,country = "India"))
        list.add(Dog("Dog", 25, 45))
        return list
    }

    override fun onDogClicked(dog: Dog) {
        Log.d("Recycler", "onDogClicked()")
    }

    override fun onCatClicked(cat: Cat) {
        Log.d("Recycler", "onCatClicked()")
    }

    override fun onElephantClicked(elephant: Elephant) {
        Log.d("Recycler", "onElephantClicked()")
    }

    override fun onMonkeyClicked(monkey: Monkey) {
        Log.d("Recycler", "onMonkeyClicked()")
    }

    override fun onTigerClicked(tiger: Tiger) {
        Log.d("Recycler", "onTigerClicked()")
    }

}