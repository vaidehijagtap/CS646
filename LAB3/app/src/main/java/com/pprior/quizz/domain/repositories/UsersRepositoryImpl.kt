package com.pprior.quizz.domain.repositories

import kotlinx.coroutines.flow.MutableSharedFlow


class UsersRepositoryImpl private constructor(): IUsersRepository {
    companion object {
        @Volatile
        private var INSTANCE: UsersRepositoryImpl? = null


        fun getInstance(): UsersRepositoryImpl {
            return INSTANCE ?: synchronized(this) {
                UsersRepositoryImpl().also { INSTANCE = it }
            }
        }
    }

    private var respondedUsers = MutableSharedFlow<MutableList<String>>(replay = 1)

    override fun exists(user: String) = respondedUsers.replayCache.firstOrNull()?.contains(user) ?: false
    override fun clearRespondedUsers() { respondedUsers.tryEmit(mutableListOf()) }
    override fun addRespondedUser(user: String) {
        val users = respondedUsers.replayCache.firstOrNull() ?: mutableListOf()
        users.add(user)
        respondedUsers.tryEmit(users)
    }

}