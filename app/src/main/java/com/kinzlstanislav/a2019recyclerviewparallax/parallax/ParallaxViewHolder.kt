package com.kinzlstanislav.a2019recyclerviewparallax.parallax

import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView

abstract class ParallaxViewHolder(
        private val containerView: View
) : RecyclerView.ViewHolder(containerView) {

    abstract val parallaxImageView: ParallaxImageView

    private fun requireValues(): ParallaxRequiredValues {
        return if (containerView.parent == null) {
            ParallaxRequiredValues(0f, 0f, 0f)
        } else {
            return ParallaxRequiredValues(
                    itemViewY = containerView.y,
                    imageMeasuredHeight = parallaxImageView.measuredHeight.toFloat(),
                    recyclerViewHeight = (containerView.parent as RecyclerView).measuredHeight.toFloat()
            )
        }
    }

    fun translate() {
        parallaxImageView.translate(requireValues())
    }

}