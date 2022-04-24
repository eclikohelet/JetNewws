package com.example.jetnewws

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnewws.ui.theme.JetNewwsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // A mutable value holder where reads to the value property during the execution of
            // a Composable function, the current RecomposeScope will be subscribed to changes
            // of that value. When the value property is written to and changed, a recomposition of any subscribed RecomposeScopes will be scheduled.
          //  If value is written to with the same value, no recompositions will be scheduled.
            val myViewModel:MyViewModel by viewModels()
            JetNewwsTheme {
//                 var x by rememberSaveable { mutableStateOf(10) }
//                 var y by rememberSaveable { mutableStateOf(11) }
              //  var x=10
            //    var y=11
                var x=myViewModel.currentX.observeAsState().value
                var y=myViewModel.currentY.observeAsState().value

               // var xVal=

                if (y != null) {
                    if (x != null) {
                        ShowColumsRows(
                            mNumber1 =x,
                            mNumber2 =y,
                            //mNumber1 = myViewModel.number1,
                            // mNumber2 = myViewModel.number2,
                            { myViewModel.addX() }){
                            myViewModel.addY()
                        }
                    }
                }
//                Sbutton {
//                   import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
//                }
//                Column() {
//
//
//                    Sbutton() {
//                        x = x + 1
//                        Log.v("xxx", "" + x)
//                    }
//  Spacer(modifier = Modifier.height(100.dp))
//                    SColumn {
//                        x++
//                        Log.v("xxx", "" + x)
//                    }
//                }

            }



                           }


                        }

    @Composable
    private fun ShowColumsRows(
        mNumber1: Int,
        mNumber2:Int,
        onClick1: () -> Unit,
        onClick2: () -> Unit) {
        val windowInfo = rememberWindowInfo()
        // A surface container using the 'background' color from the theme
        if (windowInfo.screenWidth < 600.dp) {
            Column(
                modifier = Modifier
                    .background(color = Color.Green)
                    .fillMaxSize()
                    .padding(3.dp),
                verticalArrangement = Arrangement.Center
            ) {

//1
                if (mNumber1 != null) {
                    SuperColumn(color = Color.Cyan, textButton = "1", mNumber = mNumber1, onClick = onClick1)
                }
  //2
                if (mNumber2 != null) {
                    SuperColumn(color = Color.Magenta, textButton = "2", mNumber = mNumber2, onClick = onClick2)
                }


            }// central  column
        } else {
            Row(modifier = Modifier.fillMaxSize()) {
    //        Column(modifier = Modifier.weight(1.0f)) {
    //            myLazyColumn(color = Color.Yellow)
    //        }
                //1
                if (mNumber1 != null) {
                    SuperColumn2(color = Color.Green, textButton = "1", mNumber = mNumber1, onClick = onClick1)
                }
                //2
                if (mNumber2 != null) {
                    SuperColumn2(color = Color.Yellow, textButton = "2", mNumber = mNumber2,onClick=onClick2)
                }


            }

        }//
    }

}


        
    

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

   
@Composable
fun ColumnScope.SuperColumn(modifier: Modifier=Modifier.weight(1.0f),
                            color:Color,textButton:String,mNumber: Int,onClick: () -> Unit){
    Column(modifier = modifier) {
        MyButton(text = textButton, onClick = onClick)
        myLazyColumn(color = color, mNumber = mNumber)
    }
}
@Composable
fun RowScope.SuperColumn2(modifier: Modifier=Modifier.weight(1.0f),
                          color: Color,textButton: String,mNumber: Int,onClick: () -> Unit){
    Column(modifier = modifier) {
        MyButton(text = textButton, onClick = onClick)
        myLazyColumn(color = color,mNumber=mNumber)
    }
}

@Composable
fun myLazyColumn( color:Color,mNumber:Int) {
    LazyColumn() {
        items(count = mNumber) {
            Text(
                text = "Item $it",
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = color)
                    .padding(16.dp)
            )
        }

    }
}

@Composable
fun MyButton(text:String,onClick:()->Unit){
    Button(modifier = Modifier.padding(10.dp), onClick = onClick, colors =ButtonDefaults.buttonColors(backgroundColor = Color.Black) , shape = CircleShape)
    {
       Text(text=text,color= Color.White,

       style = MaterialTheme.typography.h4)
    }
}