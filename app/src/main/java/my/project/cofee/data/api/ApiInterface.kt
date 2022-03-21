package my.project.cofee.data.api

import my.project.cofee.data.models.CoffeeApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("loadCoffee.php")
    fun loadCoffeeApi(): Call<ArrayList<CoffeeApiModel>>
}