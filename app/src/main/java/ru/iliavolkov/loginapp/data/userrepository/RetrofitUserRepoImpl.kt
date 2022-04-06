package ru.iliavolkov.loginapp.data.userrepository

import ru.iliavolkov.loginapp.model.UserRepository
import ru.iliavolkov.loginapp.model.entities.UserProfile

class RetrofitUserRepoImpl : UserRepository {
    override fun addUser(user: UserProfile) {

    }

    override fun getUser(id: String): UserProfile {
        return UserProfile("1", "Name", "Surname", "***@mail.ru", "https://***.png")
    }

    override fun getAllUser(): List<UserProfile> {
        return listOf(UserProfile("1", "Name", "Surname", "***@mail.ru", "https://***.png"))
    }

    override fun changeUser(id: String, user: UserProfile): Boolean {
        return false
    }

    override fun deleteUser(id: String): Boolean {
        return false
    }
}