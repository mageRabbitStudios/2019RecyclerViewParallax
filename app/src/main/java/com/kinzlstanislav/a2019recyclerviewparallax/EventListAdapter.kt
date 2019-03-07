package com.kinzlstanislav.a2019recyclerviewparallax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kinzlstanislav.a2019recyclerviewparallax.parallax.ParallaxImageView
import com.kinzlstanislav.a2019recyclerviewparallax.parallax.ParallaxViewHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_parallax.*
import java.util.*

class EventListAdapter(private val parallaxModelList: List<Event>) :
    RecyclerView.Adapter<EventListAdapter.EventViewHolder>() {

    private val parallaxViewHolderList: MutableList<EventViewHolder> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EventViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_parallax, viewGroup, false)
        val parallaxViewHolder = EventViewHolder(v)
        parallaxViewHolderList.add(parallaxViewHolder)
        return parallaxViewHolder
    }

    override fun onBindViewHolder(parallaxViewHolder: EventViewHolder, i: Int) {
        val parallaxModel = parallaxModelList[i]

        parallaxViewHolder.event_name.text = parallaxModel.name

        var drawableImage = R.drawable.lorempixel
        if (i % 2 == 0) {
            drawableImage = R.drawable.lorempixel2
        } else if (i % 3 == 0) {
            drawableImage = R.drawable.lorempixel3
        }

        parallaxViewHolder.parallaxImageView.setImageResource(drawableImage)
        parallaxViewHolder.itemView.tag = parallaxViewHolder

    }

    override fun getItemCount() = parallaxModelList.size

    /*
     To add parallax, no need to do anything else than set the image using kotlin synthetics here, taking advantage
     of the LayoutContainer capabilities. The functionality of parallax is then separated into classes under "parallax"
     package.
     */
    class EventViewHolder(override val containerView: View) : ParallaxViewHolder(containerView), LayoutContainer {

        override val parallaxImageView: ParallaxImageView = img_event
    }
}