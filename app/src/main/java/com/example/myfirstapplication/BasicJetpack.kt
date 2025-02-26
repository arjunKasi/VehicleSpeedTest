package com.example.myfirstapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicJetpack(modifier: Modifier){
Column(
    Modifier.padding(horizontal = 16.dp)
){
    Row(
        modifier = Modifier.padding(top = 56.dp)
    ) {

        Image(
            painter = painterResource(id = R.mipmap.download),
            contentDescription = "test",
           // modifier = Modifier.padding(top = 80.dp, start = 80.dp)
        )
    Column(
       modifier = Modifier.padding(top = 16.dp)
    ) {

    }
        Text(text = "Hello Android",
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 22.sp
        )
        Text(text = "Hello Android")

                                                                                                                                                                                                                                                                                                                                                            }


    Text(text = "This is our second line of text. This box is to represent how we can add a description to the whole project")
    Button(
        Modifier.padding(top = 16.dp



















































































































































































            


        )
    ) {
        Text(text = "Click me")
    }
}
}
@Preview
@Composable
fun basicDemo(){
    BasicJetpack(modifier = Modifier)
}