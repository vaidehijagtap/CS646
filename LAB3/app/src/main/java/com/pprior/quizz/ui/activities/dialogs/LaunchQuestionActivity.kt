package com.pprior.quizz.ui.activities.dialogs

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pprior.quizz.data.constants.ENDPOINT
import com.pprior.quizz.data.constants.SERVER_PORT
import com.pprior.quizz.data.constants.URL_ENTRY
import com.pprior.quizz.data.constants.host
import com.pprior.quizz.data.services.HttpService
import com.pprior.quizz.databinding.ActivityLaunchQuestionBinding
import com.pprior.quizz.domain.models.Bar
import com.pprior.quizz.domain.models.Question
import com.pprior.quizz.ui.components.utils.QRCodeGenerator
import com.pprior.quizz.ui.viewModels.QuestionViewModel
import com.pprior.quizz.ui.viewModels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.net.URLEncoder


@AndroidEntryPoint
class LaunchQuestionActivity: AppCompatActivity() {

    private val questionViewModel by viewModels<QuestionViewModel>()
    private val userViewModel by viewModels<UserViewModel>()

    private lateinit var binding: ActivityLaunchQuestionBinding
    private lateinit var question: Question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        question = questionViewModel.findQuestion(intent.getStringExtra("question") ?: "")
        questionViewModel.clearAnswer(question)

        startService(Intent(this, HttpService::class.java))

        lifecycleScope.launch {
            bindQuestion(question)
        }
    }

    private suspend fun bindQuestion(question: Question) {
        with(binding) {
            questionTypeIcon.setImageResource(question.icon)

            qrCode.setImageBitmap(generateQRCode())

            this.question.text = question.question

            closeButton.setOnClickListener { finish() }

            question.answers.forEach { answer ->
                val bar = Bar(answer.answer.toString(), height = answer.count.value.toFloat())
                barView.addBar(bar)

                lifecycleScope.launch {
                    answer.count.collect { newCount ->
                        bar.height = newCount.toFloat()
                        barView.invalidate()
                    }
                }
            }

        }
    }

    private fun generateQRCode(): Bitmap? {
        val qrCodeGenerator = QRCodeGenerator()
        val encodedQuestion = URLEncoder.encode(question.question, "UTF-8")

        return qrCodeGenerator.encodeAsBitmap(
            url = "$URL_ENTRY$host:$SERVER_PORT$ENDPOINT/$encodedQuestion"
        )
    }

    override fun onDestroy() {
        stopService(Intent(this, HttpService::class.java))

        userViewModel.clearRespondedUsers()
        super.onDestroy()
    }

}