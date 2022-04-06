package ru.iliavolkov.loginapp.model

import androidx.annotation.MainThread

interface LoginUsecase {
    fun login(
        login: String, password: String,
        @MainThread callback: (Boolean) -> Unit
    )
}