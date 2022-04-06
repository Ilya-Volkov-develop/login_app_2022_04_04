package ru.iliavolkov.loginapp

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import ru.iliavolkov.loginapp.data.LoginUsecaseImpl
import ru.iliavolkov.loginapp.data.MockLoginApiImpl
import ru.iliavolkov.loginapp.model.LoginApi
import ru.iliavolkov.loginapp.model.LoginUsecase

class App : Application() {
    private val loginApi: LoginApi by lazy { MockLoginApiImpl() }
    val loginUsecase: LoginUsecase by lazy {
        LoginUsecaseImpl(
            loginApi,
            Handler(Looper.getMainLooper())
        )
    }
}

val Context.app: App
    get() {
        return applicationContext as App
    }