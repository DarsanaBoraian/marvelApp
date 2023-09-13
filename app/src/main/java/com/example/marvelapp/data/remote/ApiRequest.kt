package com.example.marvelapp.data.remote

import com.example.marvelapp.data.model.Marvel
import com.example.marvelapp.data.model.MarvelItemModel
import retrofit2.http.GET

interface ApiRequest{
    @GET(ApiDetails.BASE_URL)
    suspend fun getMarvelDetails(): MarvelItemModel
}