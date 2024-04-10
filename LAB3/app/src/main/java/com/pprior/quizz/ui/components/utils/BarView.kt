package com.pprior.quizz.ui.components.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.pprior.quizz.domain.models.Bar

private const val TEXT_SIZE = 30f
private const val BAR_MARGIN = 50f


class BarView(
    context: Context,
    attributes: AttributeSet
) : View(context, attributes) {

    private val bars = mutableListOf<Bar>()
    private val paint = Paint().apply {
        textSize = TEXT_SIZE
        color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        val barMargin = BAR_MARGIN
        val barWidth = (height - barMargin * (bars.size - 1)) / bars.size
        val maxCount = bars.maxOf { it.height }

        bars.forEachIndexed { index, bar ->
            val top = index * (barWidth + barMargin)
            val bottom = top + barWidth

            val right = if (maxCount > 0) width.toFloat() * (bar.height / maxCount) else 0f

            paint.color = bar.color
            canvas.drawRect(0f, top, right, bottom, paint)

            val x = 5f
            val y = (top + bottom) / 2 - (paint.descent() + paint.ascent()) / 2
            paint.color = if (right == 0f) Color.BLACK else Color.WHITE
            canvas.drawText("${bar.answer}: ${bar.height.toInt()}", x, y, paint)
        }

    }

    fun addBar(bar: Bar) {
        bars.add(bar)
        invalidate()
    }

}