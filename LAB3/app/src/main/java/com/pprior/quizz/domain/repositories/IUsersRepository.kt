package com.pprior.quizz.domain.repositories

interface IUsersRepository {
    fun clearRespondedUsers()

    fun addRespondedUser(user: String)

    fun exists(user: String): Boolean
}