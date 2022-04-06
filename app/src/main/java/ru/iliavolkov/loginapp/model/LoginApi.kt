package ru.iliavolkov.loginapp.model

import androidx.annotation.WorkerThread

interface LoginApi {
    @WorkerThread
    fun login(login: String, password: String): Boolean

    @WorkerThread
    fun register(name: String, surname: String, login: String, password: String): Boolean

    @WorkerThread
    fun userExit(): Boolean

    @WorkerThread
    fun forgotPassword(login: String): Boolean
}