package com.example.growigh_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.growigh_task.api.ApiInterface
import com.example.growigh_task.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val recyclerView = findViewById<RecyclerView>(R.id.recylerView)
//        linearLayoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = linearLayoutManager

        getMyData()
    }

    private fun getMyData() {
        val article = ApiService.apiInstance.getHeadlines("in",1)
        article.enqueue(object : Callback<Article>{
            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                val article: Article?= response.body()
                if(article!= null){
                    Log.d("MainActivity", article.toString())
                    myAdapter= MyAdapter(this@MainActivity, article.articles)
                    val recyclerView: RecyclerView= findViewById(R.id.recylerView)
                    recyclerView.adapter= myAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<Article>, t: Throwable) {
                Log.d("MainActivity", "Error in fetcing news",t)
            }
        })
    }
}

