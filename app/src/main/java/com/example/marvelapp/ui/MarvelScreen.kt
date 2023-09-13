package com.example.marvelapp.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.marvelapp.data.model.Marvel
import com.example.marvelapp.data.model.MarvelItemModel

@Composable
fun MarvelScreen(){
    val viewModel = hiltViewModel<MarvelViewModel>()
    viewModel.getMarvelDetails()
    val marvelDetails by viewModel.marvelDetails.collectAsState()


    MarvelListContent(marvelDetails = marvelDetails)

}

@Composable
fun MarvelListContent(marvelDetails: MarvelItemModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 30.dp)
    ) {

        items(marvelDetails.size) { index ->
            // Each item in the LazyColumn
            val marvelItem = marvelDetails.get(index)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Gray, RectangleShape)
                    .padding(8.dp), // Add padding to make the elevation visible
                    // Optionally clip the card shape
                    elevation = 4.dp// Add elevation here
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {

                    marvelItem.name?.let {
                        Text(
                            text = it.capitalize(),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    AsyncImage(
                        model = marvelItem.imageurl,
                        contentDescription = "Image Marvel",
                        modifier = Modifier
                            .size(180.dp)
                    )

                    Text(
                        text = marvelItem.bio.toString(),
                        fontSize = 16.sp
                    )
                    Text("Real Name : "+ marvelItem.realname.toString())
                    Text("Created by : " + marvelItem.createdby.toString())
                    Text("First Appearance : "+marvelItem.firstappearance.toString())
                    Text("Publisher : " +marvelItem.publisher.toString())
                }
            }
            Spacer(Modifier.height(5.dp))
        }
    }
}

