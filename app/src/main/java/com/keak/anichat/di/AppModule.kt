package com.keak.geniusai.di

import android.content.Context
import com.adapty.Adapty
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(
        @ApplicationContext
        app: Context
    ): AniChatApplication {
        return app as AniChatApplication
    }



    @Provides
    @Singleton
    fun provideAdaptyInstance(): Adapty {
        return Adapty
    }





//    @Singleton
//    @Provides
//    fun provideOpenAIService(
//        @PpOkHttpClient ppOkHttpClient: OkHttpClient
//    ): OpenAIService {
//        return Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://api.openai.com/v1/")
//            .client(ppOkHttpClient)
//            .build()
//            .create(OpenAIService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    @PpOkHttpClient
//    fun provideOkHttpClient(
//        networkInterceptor: NetworkInterceptor
//    ): OkHttpClient {
//        val logging = HttpLoggingInterceptor()
//        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
//        val client = OkHttpClient.Builder().cache(null).connectTimeout(40, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(50, TimeUnit.SECONDS).addInterceptor(networkInterceptor)
//            .addInterceptor(logging)
//        return client.build()
//
//    }


}

@Retention
@Qualifier
annotation class PpOkHttpClient