package com.example.marvelapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
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
                    .border(0.dp, Color.Transparent, RectangleShape)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .semantics(mergeDescendants = true) {}) {


                        marvelItem.name?.let {
                            Text(
                                text = it.capitalize(),
                                fontSize = 25.sp
                            )}

                            Text(
                                text = marvelItem.bio.toString(),
                                fontSize = 25.sp
                            )
                            Text(marvelItem.createdby.toString())
                            Text(marvelItem.firstappearance.toString())
                            Text(marvelItem.publisher.toString())
                            Text(marvelItem.realname.toString())




                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.Gray // Set the color to gray
                    )


            }
        }
    }
}
