package ru.iliavolkov.loginapp.model.entities

data class UserProfile(
    val id: String,
    val name: String,
    val surname: String,
    val login: String,
    val avatarUrl: String
)
