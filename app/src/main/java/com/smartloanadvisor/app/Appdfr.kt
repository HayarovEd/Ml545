package com.smartloanadvisor.app

import android.app.Application
import com.my.tracker.MyTracker
import com.smartloanadvisor.app.domain.utils.APP_METRICA
import com.smartloanadvisor.app.domain.utils.MY_TRACKER
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Appdfr: Application() {
    override fun onCreate() {
        super.onCreate()

        val config = YandexMetricaConfig.newConfigBuilder(APP_METRICA).build()


        MyTracker.initTracker(MY_TRACKER, this)
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        //UserX.init(USER_X)
    }
}