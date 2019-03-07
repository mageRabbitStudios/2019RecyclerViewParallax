package com.kinzlstanislav.a2019recyclerviewparallax.parallax

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

class ParallaxRecyclerView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    class ParallaxScrollListener : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            for (i in 0 until recyclerView.childCount) {
                (recyclerView.getChildViewHolder(recyclerView.getChildAt(i)) as ParallaxViewHolder)
                        .translate()
            }
        }
    }

    init {
        val parallaxScrollListener = ParallaxScrollListener()
        addOnScrollListener(parallaxScrollListener)
    }

}
