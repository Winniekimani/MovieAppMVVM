package com.winnie.moviemvvm.data.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val API_KEY = "012dc9bd25e789a0638459d4c425e7aa"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

const val FIRST_PAGE = 1
const val POST_PER_PAGE = 20

//https://api.themoviedb.org/3/movie/popular?api_key=012dc9bd25e789a0638459d4c425e7aa
//https://api.themoviedb.org/3/movie/547016?api_key=012dc9bd25e789a0638459d4c425e7aa
//https://image.tmdb.org/t/p/w342/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg

class TheMovieDBClient(context: Context) {


    private val myContext = context
    private val cacheSize = (20 * 1024 * 1024).toLong()
    private val myCache = Cache(context.cacheDir, cacheSize)

    fun getClient(): TheMovieDBInterface {
        val requestInterceptor = Interceptor { chain ->

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request = if (hasNetwork(myContext)) chain.request()
                .newBuilder()
                .url(url)
                .build()

            else chain.request().newBuilder().url(url)
                .header("Cache-Control", "public, only-if-cache, max-stale=" + 60 * 60 * 24 * 7)
                .build()

            return@Interceptor chain.proceed(request)

        }
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val okHttpClient = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()


        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(TheMovieDBInterface::class.java)
    }

    private fun hasNetwork(myContext: Context): Boolean {
        val connectivityManager =
            myContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
        return false
    }


}