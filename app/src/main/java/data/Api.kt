package data

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import vlados.dudos.pixelseller.CategoryResponse
import vlados.dudos.pixelseller.ShopResponce

interface Api {

    @GET("/goods-category-dictionary")
    fun category(): Observable<List<CategoryResponse>>


    @GET("/goods")
    fun phones(): Observable<List<ShopResponce>>



    companion object {
        fun createApi(): Api {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://c47fc10f-d7e2-4fff-9fd1-db139e6f4337.mock.pstmn.io")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}