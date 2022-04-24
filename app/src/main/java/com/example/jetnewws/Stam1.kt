package com.example.jetnewws

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Sbutton(onClick:()->Unit){
    Button(onClick = {onClick()} ){
       Text("Walla")
    }

}
//
@Composable
fun SColumn(onClick: () -> Unit){
    Sbutton() {
      onClick()
    }

}