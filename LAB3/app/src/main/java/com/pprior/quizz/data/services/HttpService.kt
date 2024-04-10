package com.pprior.quizz.data.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.pprior.quizz.data.constants.SERVER_PORT
import com.pprior.quizz.data.controllers.HttpController
import dagger.hilt.android.AndroidEntryPoint
import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.install
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.embeddedServer
import io.ktor.server.freemarker.FreeMarker
import io.ktor.server.netty.Netty
import io.ktor.server.routing.routing
import javax.inject.Inject


@AndroidEntryPoint
class HttpService: Service() {

    @Inject
    lateinit var controller: HttpController
    private var server: ApplicationEngine? = null

    override fun onCreate() {
        super.onCreate()
        startServer()
    }

    private fun startServer() {
        Thread {
            server = createServer()
            server?.start(wait = false)
        }.start()
    }

    private fun createServer() = embeddedServer(Netty, port = SERVER_PORT) {
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "assets")
        }

        routing { controller.setupRoutes(this) }
    }

    override fun onDestroy() {
        super.onDestroy()
        server?.stop(1000, 5000)
    }

    override fun onBind(intent: Intent?): IBinder? = null
}