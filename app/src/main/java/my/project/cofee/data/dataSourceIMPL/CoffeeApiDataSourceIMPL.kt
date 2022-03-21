package my.project.cofee.data.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import my.project.cofee.data.api.ApiClient
import my.project.cofee.data.dataSource.CoffeeApiDataSource
import my.project.cofee.data.dataSource.CoffeeDataSource
import my.project.cofee.data.models.CoffeeApiModel
import my.project.cofee.data.models.CoffeeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoffeeApiDataSourceIMPL (private val coffeeDataSource: CoffeeDataSource):
    CoffeeApiDataSource {



    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.loadCoffeeApi()
        call?.enqueue(object: Callback<ArrayList<CoffeeApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<CoffeeApiModel>>,
                response: Response<ArrayList<CoffeeApiModel>>
            ) {


                var loadCoffee: ArrayList<CoffeeApiModel>? = null

                loadCoffee?.clear()

                loadCoffee = (response.body() as ArrayList<CoffeeApiModel>?)!!



                for (audit in loadCoffee) {

                    audit.id?.let {
                        CoffeeModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString(),
                            audit.description.toString(),
                            audit.price.toString()
                        )
                    }?.let {
                        coffeeDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<CoffeeApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

}