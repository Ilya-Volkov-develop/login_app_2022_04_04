package ru.iliavolkov.loginapp.data

import android.os.Handler
import ru.iliavolkov.loginapp.model.LoginApi
import ru.iliavolkov.loginapp.model.LoginUsecase

class LoginUsecaseImpl(
    private val apiLogin: LoginApi,
    private val uiHandler: Handler
) : LoginUsecase {
    override fun login(login: String, password: String, callback: (Boolean) -> Unit) {
        Thread {
            val request = apiLogin.login(login, password)
            uiHandler.post {
                callback(request)
            }
        }.start()
    }
}