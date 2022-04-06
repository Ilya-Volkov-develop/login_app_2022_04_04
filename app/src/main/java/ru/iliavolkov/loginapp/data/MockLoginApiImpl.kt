package ru.iliavolkov.loginapp.data

import ru.iliavolkov.loginapp.model.LoginApi

class MockLoginApiImpl : LoginApi {
    override fun login(login: String, password: String): Boolean {
        Thread.sleep(1000)
        return login == password
    }

    override fun register(
        name: String,
        surname: String,
        login: String,
        password: String,
        repeatPassword: String
    ): Boolean {
        return name.isNotEmpty() &&
                surname.isNotEmpty() &&
                login.isNotEmpty() &&
                password.isNotEmpty() &&
                repeatPassword.isNotEmpty()
    }

    override fun userExit(): Boolean {
        return true
    }

    override fun forgotPassword(login: String): Boolean {
        return true
    }
}