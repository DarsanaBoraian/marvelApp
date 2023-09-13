package com.example.marvelapp.data.repository

import com.example.marvelapp.data.model.Marvel
import com.example.marvelapp.data.model.MarvelItemModel
import com.example.marvelapp.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiRequest: ApiRequest
): Repository{

    override suspend fun getMarvelDetails(): MarvelItemModel {
    return apiRequest.getMarvelDetails()
    }
}