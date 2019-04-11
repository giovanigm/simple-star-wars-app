package br.org.venturus.starwarsapp

import android.app.Application
import br.org.venturus.data.dataModule
import br.org.venturus.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import kotlin.system.measureTimeMillis

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        val koinStartupTime = measureTimeMillis {
            startKoin {
                androidContext(this@App)
                modules(listOf(applicationModule, dataModule, domainModule))
            }
        }

        Timber.d("Koin took $koinStartupTime to build")

    }

}