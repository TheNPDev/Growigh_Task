package com.example.growigh_task.api

import com.example.growigh_task.Article
import com.example.growigh_task.ArticleX
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "38db4d8335444d1ba42aacb8d1bb7e53"
interface ApiInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String , @Query("page") page: Int):Call<Article>
}

object ApiService{
    val apiInstance: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInstance = retrofit.create(ApiInterface::class.java)
    }
}