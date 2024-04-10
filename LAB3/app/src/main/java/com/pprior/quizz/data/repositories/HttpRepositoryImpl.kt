package com.pprior.quizz.data.repositories

import com.pprior.quizz.domain.repositories.QuestionRepositoryImpl
import com.pprior.quizz.domain.repositories.UsersRepositoryImpl
import com.pprior.quizz.domain.models.Question
import javax.inject.Inject


class HttpRepositoryImpl @Inject constructor(
    private val questionRepository: QuestionRepositoryImpl,
    private val usersRepository: UsersRepositoryImpl
): IHttpRepository {
    override fun setPostInAnswerCount(question: Question, answer: String?) { questionRepository.incAnswer(question, answer ?: "") }
    override fun findQuestion(question: String) = questionRepository.findQuestion(question)
    override fun addUserToRespondedList(userIp: String) = usersRepository.addRespondedUser(userIp)
    override fun userNotExists(userIp: String) = !usersRepository.exists(userIp)
}