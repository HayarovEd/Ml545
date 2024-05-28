package credit.calc.com.di

import com.smartloanadvisor.app.data.remote.ApiAnalytic
import com.smartloanadvisor.app.data.remote.ApiServer
import com.smartloanadvisor.app.data.remote.ApiUser
import com.smartloanadvisor.app.domain.utils.BASE_CBR_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.smartloanadvisor.app.domain.utils.URL_ANALYTICS
import com.smartloanadvisor.app.domain.utils.URL_POST_SERVER
import com.smartloanadvisor.app.domain.utils.URL_SERVER
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideApiAnalytic(): ApiAnalytic {
        return Retrofit.Builder()
            .baseUrl(URL_ANALYTICS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiAnalytic::class.java)
    }

    @Provides
    @Singleton
    fun provideApiServer(): ApiServer {
        return Retrofit.Builder()
            .baseUrl(URL_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServer::class.java)
    }

    @Provides
    @Singleton
    fun provideApiUser(): ApiUser {
        return Retrofit.Builder()
            .baseUrl(URL_POST_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiUser::class.java)
    }

    @Provides
    @Singleton
    fun provideApiCbr(): ApiCbr {
        return Retrofit.Builder()
            .baseUrl(BASE_CBR_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCbr::class.java)
    }
}