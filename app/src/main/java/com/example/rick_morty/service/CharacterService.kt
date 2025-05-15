package com.example.rick_morty.service

import com.example.rick_morty.model.Character
import com.example.rick_morty.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("character")
    fun listAll():Call<Result>

    @GET("character/{id}")
    fun findbyId(@Path("id") id: Int): Call<Character>



}