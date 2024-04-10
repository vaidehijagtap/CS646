package com.pprior.quizz.domain.repositories

import com.pprior.quizz.domain.models.Question

interface IQuestionRepository {
    fun exists(question: Question): Boolean

    fun findQuestion(question: String): Question

    fun addQuestion(question: Question)

    fun deleteQuestion(question: Question)

    fun incAnswer(question: Question, answer: String)

    fun clearAnswer(question: Question)
}