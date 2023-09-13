package com.example.marvelapp.data.repository

import com.example.marvelapp.data.model.Marvel
import com.example.marvelapp.data.model.MarvelItemModel

interface Repository {

    suspend fun getMarvelDetails() : MarvelItemModel
}