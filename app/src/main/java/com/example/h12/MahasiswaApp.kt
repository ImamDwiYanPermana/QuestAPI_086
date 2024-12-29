package com.example.h12

import android.app.Application
import com.example.h12.dependenciesinjection.AppContainer
import com.example.h12.dependenciesinjection.MahasiswaContainer

class MahasiswaApp: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}