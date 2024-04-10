package com.pprior.quizz.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pprior.quizz.databinding.ActivityQuestionTypeBinding
import com.pprior.quizz.ui.fragments.HeadFragment
import com.pprior.quizz.ui.fragments.TypesFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class QuestionTypeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        printFragments()
    }

    private fun printFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.headerFragment.id, HeadFragment::class.java, null)
            replace(binding.cardsTypes.id, TypesFragment::class.java, null)
            commit()
        }
    }

}