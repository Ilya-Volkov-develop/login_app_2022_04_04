package ru.iliavolkov.loginapp

import android.app.Application
import android.content.Context

class App : Application() {

}

val Context.app: App
    get() {
        return applicationContext as App
    }