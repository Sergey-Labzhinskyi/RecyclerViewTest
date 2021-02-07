package com.example.recyclerviewtest


sealed class Animals(val animalsType: Int) {

    companion object {
        const val TYPE_DOG = R.layout.animal_item_dog
        const val TYPE_CAT = R.layout.animal_item_cat
        const val TYPE_ELEPHANT = R.layout.animal_item_elephant
        const val TYPE_TIGER = R.layout.animal_item_tiger
        const val TYPE_MONKEY = R.layout.animal_item_monkey
    }

    data class Dog(val name: String, val age: Int, val weight: Int) : Animals(TYPE_DOG)
    data class Cat(val name: String, val age: Int, val weight: Int) : Animals(TYPE_CAT)
    data class Elephant(val name: String, val age: Int, val weight: Int) : Animals(TYPE_ELEPHANT)
    data class Tiger(val name: String, val age: Int, val weight: Int, val country: String) : Animals(TYPE_TIGER)
    data class Monkey(val name: String, val age: Int, val weight: Int = 0, val country: String) : Animals(TYPE_MONKEY)
}



