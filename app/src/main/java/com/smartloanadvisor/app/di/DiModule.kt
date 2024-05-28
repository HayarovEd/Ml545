package credit.calc.com.di

import com.smartloanadvisor.app.data.repository.RepositoryAnalyticImpl
import com.smartloanadvisor.app.data.repository.RepositoryServerImpl
import com.smartloanadvisor.app.data.repository.ServiceImpl
import com.smartloanadvisor.app.data.repository.SharedKeeperImpl
import com.smartloanadvisor.app.domain.repository.RepositoryAnalytic
import com.smartloanadvisor.app.domain.repository.RepositoryServer
import com.smartloanadvisor.app.domain.repository.Service
import com.smartloanadvisor.app.domain.repository.SharedKeeper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceImpl): Service

    @Binds
    @Singleton
    abstract fun bindKeeper(sharedKeeper: SharedKeeperImpl): SharedKeeper

    @Binds
    @Singleton
    abstract fun bindRepositoryAnalytic(repository: RepositoryAnalyticImpl): RepositoryAnalytic

    @Binds
    @Singleton
    abstract fun bindRepositoryServer(repository: RepositoryServerImpl): RepositoryServer

}