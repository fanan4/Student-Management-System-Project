package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.User
import com.example.myapplication.requests.UserEndPoint
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.txtView)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val userService: UserEndPoint = retrofit.create(UserEndPoint::class.java)
        val users: Call<List<User>> =userService.getUsers()
        users.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val usersList = response.body()
                    if (usersList != null) {
                        for (user in usersList) {
                            // Do something with the someObject
                            // For example, print some of its properties
                            Log.d("debug", "onResponse:${user.firstName} ")
                          var name=""
                            name+=user.firstName+"\n"
                            textView.setText(name)
                        }
                    }
                } else {
                    // Handle the error
                    println("Error: ${response.code()}")
                    Log.d("debug", "onResponse:${response.code()} ")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Handle the error
                println("Error: ${t.message}")
                Log.d("debug", "onResponse: ${t.message} ")
            }
        })
    }
}