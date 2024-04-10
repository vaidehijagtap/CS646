package com.pprior.quizz.ui.viewModels

import androidx.lifecycle.ViewModel
import com.pprior.quizz.domain.repositories.UsersRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val repositoryImpl: UsersRepositoryImpl
): ViewModel() {
    fun clearRespondedUsers() = repositoryImpl.clearRespondedUsers()
}