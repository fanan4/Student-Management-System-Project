package com.example.myapplication.requests
import com.example.myapplication.models.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

public interface UserEndPoint  {
 @GET("getUsers")
 fun  getUsers() :Call<List <User>>


 @POST("addUser")
 suspend fun addUser(@Body user: User): Response<ResponseBody>


 @DELETE("users/{userId}")
 fun deleteUser(@Path("userId") userId : String ) :  User



 @PUT("users")
fun updateUser(@Body user: User): Response<ResponseBody>




 @GET("users/{userId}")
  fun getUser(@Path("userId") userId: String): Call<User>



}