package com.realm.example

import android.app.Application
import com.realm.example.ui.mainModule
import employeeModule
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 */
class RealmApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initRealm()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(mainModule, employeeModule
            ))
        }
    }

    private fun initRealm() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("employeesDatabase")
            .schemaVersion(1) // Incremented during migration
            .deleteRealmIfMigrationNeeded() // Recreates the db if any changes are made to the structure. Should be used before first prod release
            .build()
        Realm.setDefaultConfiguration(config);
    }
}