package com.pprior.quizz.ui.components.utils

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix

private const val DEFAULT_SIZE = 200
private const val BLACK = -0x1000000
private const val WHITE = -0x1


class QRCodeGenerator {


    fun encodeAsBitmap(
        url: String,
        width: Int = DEFAULT_SIZE,
        height: Int = DEFAULT_SIZE
    ): Bitmap? {
        val bitMatrix = try {
            MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, null)
        } catch (e: IllegalArgumentException) {
            return null
        }

        return createBitmapFromBitMatrix(bitMatrix)
    }


    private fun createBitmapFromBitMatrix(bitMatrix: BitMatrix): Bitmap {
        val pixels = IntArray(bitMatrix.width * bitMatrix.height) { index ->
            if (bitMatrix[index % bitMatrix.width, index / bitMatrix.width]) BLACK else WHITE
        }

        return Bitmap.createBitmap(bitMatrix.width, bitMatrix.height, Bitmap.Config.ARGB_8888).apply {
            setPixels(pixels, 0, bitMatrix.width, 0, 0, bitMatrix.width, bitMatrix.height)
        }
    }
}