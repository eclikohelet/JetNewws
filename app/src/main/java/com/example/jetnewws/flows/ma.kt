package com.example.jetnewws.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

data class Person(var name: String, var tutorial : String)
var person = Person("Anupam", "Kotlin")
var aa=Person("aa","bb")
var ss="Abeba"
//var l = person.let { it.tutorial = "Android" }
var al = person.also { it.tutorial = "Android" }
val mList:MutableList<String> = mutableListOf("s","d","d")
fun main() {

  val a=runBlocking {
        getSequence().collect {
            //  flow executed  after calling callect
            println("Collected $it")
        }
    }
    hotFlow()
}

fun getSequence(): Flow<Int> {
  val myFlow=  flow<Int> {
        for(i in 1..20)
        {
            println("emit $i")
            delay (10)
        emit(i)
        }
    }
    return myFlow
}

fun hotFlow(){
    runBlocking {
        val f=(1..3).asFlow()
        println("1.Start to collect")
        var d= mutableListOf<Int>()
        val s=f.collect {
            d.add(it)
            println("Collected $it")

        }

    }


}