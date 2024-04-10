package com.pprior.quizz.domain.models

import kotlinx.coroutines.flow.MutableStateFlow

data class Answer(
    val answer: Any? = null,
    var count: MutableStateFlow<Int> = MutableStateFlow(0)
)