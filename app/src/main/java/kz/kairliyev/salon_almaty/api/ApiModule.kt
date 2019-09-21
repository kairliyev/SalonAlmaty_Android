package kz.kairliyev.salon_almaty.api

import dagger.Module
import dagger.Provides
import kz.kairliyev.salon_almaty.BuildConfig
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule{
    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaeUrl(): String = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideSalonApi(retrofit: Retrofit): SalonApi {
        return retrofit.create(SalonApi::class.java)
    }
}