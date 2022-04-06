package ru.iliavolkov.loginapp.model

import ru.iliavolkov.loginapp.model.entities.UserProfile

interface UserRepository {

    fun addUser(user: UserProfile)

    fun getUser(id: String): UserProfile
    fun getAllUser(): List<UserProfile>

    fun changeUser(id: String, user: UserProfile): Boolean

    fun deleteUser(id: String): Boolean
}