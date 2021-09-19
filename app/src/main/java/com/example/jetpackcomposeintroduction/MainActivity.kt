package com.example.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      UserList()
    }
  }
}

data class User(
  val id: Int
)

val users = listOf(
  User(1),
  User(1),
  User(1),
  User(1),
  User(1),
  User(1),
  User(1),
  User(1),
)

@Composable
fun UserList(){
//  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//    for(i in 1..10){
//      UserCard()
//    }
//  }
  LazyColumn{
    items(users){ user ->
      UserCard()
    }
  }
}

@Composable
fun UserCard() {
  Card(
    elevation = 4.dp,
    modifier = Modifier
      .padding(12.dp)
      .fillMaxWidth()
      .wrapContentHeight()
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(12.dp)
        .padding(12.dp)
    ) {
      Image(
        painter = painterResource(id = R.drawable.ic_face),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .size(120.dp)
          .clip(CircleShape)
      )
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = stringResource(id = R.string.dummy_text),
          fontSize = 12.sp,
          color = Color.Gray,
          modifier = Modifier.padding(12.dp)
        )
        Button(onClick = {
          //perform button click action here
        }) {
          Text(text = "View Profile")
        }
      }
    }
  }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  Surface(Modifier.fillMaxSize()) {
    UserList()
  }
}
