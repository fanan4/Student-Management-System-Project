package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.models.User
import com.example.myapplication.requests.UserEndPoint

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class EditActivity : AppCompatActivity() {

    private lateinit var userService: UserEndPoint
    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        userId = intent.getStringExtra("userId").toString()
        setupRetrofit()
        setupRetrofit()
    }

    private fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userService = retrofit.create(UserEndPoint::class.java)

        userService.getUser(userId).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    if (user != null) {
                        println("--------------------------------------------------------")
                        println(user.firstName)
                    } else {
                        // Handle error
                    }
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // Handle error
            }
        })
    }
}