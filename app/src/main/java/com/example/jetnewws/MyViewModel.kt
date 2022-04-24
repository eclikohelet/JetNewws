package com.example.jetnewws

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {

    var number1 : Int by mutableStateOf(9)
    var number2 : Int by mutableStateOf(8)
    fun addNumber1(){
        number1++
    }
    fun addNumber2(){
        number2++
    }
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("yy")
    }
    val currentX: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(10)
    }
    val currentY: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(10)
    }
    fun addX(){
     var s:Int?=currentX.value
        if (s != null) {
            s=s+1
        }
        currentX.value=s

    }
    fun addY(){
     var s:Int?=currentX.value
        if (s != null) {
            s=s+1
        }
        currentY.value=s

    }
}