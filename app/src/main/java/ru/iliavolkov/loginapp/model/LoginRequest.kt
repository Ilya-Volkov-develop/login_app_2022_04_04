package ru.iliavolkov.loginapp.model

class LoginRequest {
    fun request(login: String, password: String): Boolean {
        return login == password
    }
}