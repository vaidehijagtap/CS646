package com.pprior.quizz.data.controllers

import com.pprior.quizz.data.constants.ANSWER_PLACEHOLDER
import com.pprior.quizz.data.constants.ENDPOINT
import com.pprior.quizz.data.constants.ERROR_MESSAGE
import com.pprior.quizz.data.constants.FILES_EXTENSION
import com.pprior.quizz.data.constants.FILES_FOLDER
import com.pprior.quizz.data.constants.FILES_NAME
import com.pprior.quizz.data.constants.QUESTION_PLACEHOLDER
import com.pprior.quizz.data.constants.SUCCESS_MESSAGE
import io.ktor.http.ContentType
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respondRedirect
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import com.pprior.quizz.data.repositories.HttpRepositoryImpl
import com.pprior.quizz.domain.models.Question
import io.ktor.server.application.call
import io.ktor.server.plugins.origin
import java.util.Locale
import javax.inject.Inject


class HttpController @Inject constructor(
    private val repository: HttpRepositoryImpl
) {
    private lateinit var userIP: String
    private lateinit var question: Question

    fun setupRoutes(route: Route) {
        route.handleGetQuestionRoute()
        route.handleSubmitRoute()
        route.handleSuccessRoute()
    }

    private fun Route.handleGetQuestionRoute() = get("$ENDPOINT/{questionName}") {
        userIP = call.request.origin.remoteHost
        question = repository.findQuestion(call.parameters["questionName"] ?: "")
        val fileContent = loadHtmlFile(question.answerType.name)

        call.respondText(
            text = fileContent ?: ERROR_MESSAGE,
            contentType = ContentType.Text.Html
        )
    }

    private fun Route.handleSubmitRoute() = post("/submit") {
        if (repository.userNotExists(userIP)) {
            val choice = call.receiveParameters()["choice"]
            repository.setPostInAnswerCount(question, choice)
            repository.addUserToRespondedList(userIP)
        }

        call.respondRedirect(ENDPOINT)
    }

    private fun Route.handleSuccessRoute() = get(ENDPOINT) {
        call.response.headers.append("Cache-Control", "no-store")

        call.respondText(
            text = SUCCESS_MESSAGE,
            contentType = ContentType.Text.Html
        )
    }


    private fun loadHtmlFile(answerType: String): String? {
        val filePath = "${answerType.lowercase(Locale.ROOT)}$FILES_NAME$FILES_EXTENSION"

        return this::class.java.getResource("$FILES_FOLDER$filePath")?.readText()?.let {
            replacePlaceholders(it, question)
        }
    }


    private fun replacePlaceholders(fileContent: String?, question: Question): String? {
        var content = fileContent

        content = content?.replace(QUESTION_PLACEHOLDER, question.question)

        question.answers.forEachIndexed { index, answer ->
            content = content?.replace("$ANSWER_PLACEHOLDER${index}]", answer.answer.toString())
        }

        return content
    }

}