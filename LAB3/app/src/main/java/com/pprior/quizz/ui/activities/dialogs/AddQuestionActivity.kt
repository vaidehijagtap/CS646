package com.pprior.quizz.ui.activities.dialogs

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pprior.quizz.R
import com.pprior.quizz.domain.models.Question
import com.pprior.quizz.databinding.ActivityAddQuestionBinding
import com.pprior.quizz.ui.viewModels.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class AddQuestionActivity: AppCompatActivity() {

    protected val viewModel by viewModels<QuestionViewModel>()
    protected lateinit var binding: ActivityAddQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            saveButton.setOnClickListener { saveQuestion() }
            closeButton.setOnClickListener { finish() }
        }
    }

    protected open fun saveQuestion() {
        val question = createQuestionFromInput()

        if (question.question.isEmpty()) {
            return
        }

        if (viewModel.existsQuestion(question)) {
            binding.errorMessage.text = getString(R.string.questions_exists)
        } else {
            viewModel.addQuestion(question)
            finish()
            clear()
        }
    }

    protected open fun createQuestionFromInput() = Question(
        binding.questionQuestion.text.toString()
    )

    private fun clear() {
        with(binding) {
            questionQuestion.text.clear()
            errorMessage.text = ""
        }
    }

}