package com.pprior.quizz.domain.repositories

import com.pprior.quizz.domain.models.Question
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow


class QuestionRepositoryImpl private constructor(): IQuestionRepository {
    companion object {
        @Volatile
        private var INSTANCE: QuestionRepositoryImpl? = null


        fun getInstance(): QuestionRepositoryImpl {
            return INSTANCE ?: synchronized(this) {
                QuestionRepositoryImpl().also { INSTANCE = it }
            }
        }
    }

    private var _questionsList = MutableStateFlow<MutableList<Question>>(mutableListOf())
    private val _questionUpdated = MutableSharedFlow<Unit>(replay = 1)

    val questionsList: StateFlow<MutableList<Question>> = _questionsList
    val questionUpdated: SharedFlow<Unit> = _questionUpdated

    override fun exists(question: Question) = _questionsList.value.any { it.question == question.question }
    override fun findQuestion(question: String) = _questionsList.value.find { it.question == question } ?: Question("")

    override fun addQuestion(question: Question) {
        _questionsList.value.add(question)
        _questionUpdated.tryEmit(Unit)
    }
    override fun deleteQuestion(question: Question) {
        _questionsList.value.remove(question)
        _questionUpdated.tryEmit(Unit)
    }
    fun updateQuestion(oldQuestion: String, newQuestion: Question) {
        val index = _questionsList.value.indexOfFirst { it.question == oldQuestion }

        if (index != -1) {
            _questionsList.value[index].question = newQuestion.question
            _questionUpdated.tryEmit(Unit)
        }
    }

    override fun clearAnswer(question: Question) {
        val existingQuestion = _questionsList.value.firstOrNull { it.question == question.question }
        existingQuestion?.answers?.forEach { it.count.tryEmit(0) }
    }
    override fun incAnswer(question: Question, answer: String) {
        for (ans in question.answers) {
            if (ans.answer?.toString()?.equals(answer) == true) {
                ans.count.tryEmit(ans.count.value + 1)
            }
        }
    }

}