package com.pprior.quizz.domain.models

import android.graphics.Color

private val barColors = listOf(
    Color.parseColor("#8B0000"),
    Color.parseColor("#006400"),
    Color.parseColor("#00008B"),
    Color.parseColor("#B8860B"),
    Color.parseColor("#4B0082")
)

data class Bar(
    val answer: String,
    var height: Float = 1f,
    var color: Int = barColors.random()
)