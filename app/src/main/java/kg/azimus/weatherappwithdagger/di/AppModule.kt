package kg.azimus.weatherappwithdagger.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

        @Singleton
        @Provides

        fun provideRetrofitInstance(): Retrofit? {
            return Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient()!!)
                .build()
        }

        @Singleton
        @Provides
        fun provideOkHttpClient(): OkHttpClient? {
            return OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .build()
        }

        /*@Singleton
        @Provides
        fun provideInterceptorInstance(): Interceptor {
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("appid", APP_KEY)
                .build()
            return chain.request()
                .newBuilder()
                .url(url)
                .build()
        }*/

}