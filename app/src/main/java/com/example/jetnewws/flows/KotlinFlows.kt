package com.example.jetnewws.flows

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnewws.flows.ui.theme.JetNewwsTheme

class KotlinFlows : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNewwsTheme {
                val viewModel:MainViewModel= viewModel<MainViewModel>()
                val time=viewModel.countDownFlow.collectAsState(initial = 10)
                // A surface container using the 'background' color from the theme
                        Column(modifier =Modifier.fillMaxSize(),
                            horizontalAlignment =Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                            ){
                             Text(text =time.value.toString(),
                             fontSize = 30.sp,
                             modifier = Modifier.padding(10.dp))
                             Text(text =viewModel.y.value                      ,
                                 fontSize = 30.sp,
                                 modifier = Modifier
                                     .padding(bottom = 100.dp))

                             Button(onClick = { viewModel.addAA()
                                viewModel.addTomList()
                                 Log.v("xxx","size of mutable list is"+viewModel.mList.size)
                                 Log.v("xxx","size of unmutable list is"+viewModel.unMlist.size)
                             Log.v("xxx",viewModel.y.value)
                             }) {
                                 Text(text = "add aa")
                             }

                            LazyColumn{
                              items(viewModel.unMlist){item->
                                  Text(item)

                              }

                            }
                         }


            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNewwsTheme {
        Greeting2("Android")
    }
}