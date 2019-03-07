package com.kinzlstanislav.a2019recyclerviewparallax.parallax

import android.content.Context
import android.graphics.Matrix
import android.util.AttributeSet
import android.widget.ImageView

class ParallaxImageView @JvmOverloads constructor(
        context: Context?,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    init {
        scaleType = ImageView.ScaleType.MATRIX
    }

    fun translate(values: ParallaxRequiredValues) {
        val translate = -values.itemViewY * (values.imageMeasuredHeight / values.recyclerViewHeight)
        val matrix = Matrix()
        matrix.postTranslate(0f, translate)

        imageMatrix = matrix
    }

}