package com.example.jetnewws.flows

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val y= mutableStateOf("tt")
  val mList:MutableList<String> = mutableListOf("s","d","d")
    val unMlist:List<String> =  mList
    val recipes:MutableState<List<String>> = mutableStateOf(unMlist)

    fun addTomList(){
        mList.add("kkkkk")
    }
init {

}
    fun addToRecipes(){
        //recipes.value.add("aa")
    }
   // State<List<T>>
    // list

    fun addAA(){
       y.value=y.value+"aa"
    }
    val countDownFlow=flow<Int>{
val statringValue=10
        var currentValue=statringValue
        emit(statringValue)
        while (currentValue>0){
            delay(1000L)
            currentValue--
            emit(currentValue)


        }
    }
    init {
        collectFlow()
    }
    private fun collectFlow(){
        viewModelScope.launch {

         val count= countDownFlow
              .filter {time->
                  time%2==0
              }

//              .collect{time->
//              println(time.toString())
//
//          }
              .count {
                  it%2==0
              }
            println("the count is $count")
        }

    }
    
//    private fun collectFlow2(){
//        viewModelScope.launch {
//            val reduceResult=countDownFlow.reduce{
//                accumulator, value ->
//            }
//        }
//
//    }
}