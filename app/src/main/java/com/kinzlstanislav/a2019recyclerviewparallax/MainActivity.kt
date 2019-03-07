package com.kinzlstanislav.a2019recyclerviewparallax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var parallaxModelArrayList: ArrayList<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parallaxModelArrayList = ArrayList(20)
        for (i in 0..300) {
            val parallaxModel = Event()
            parallaxModel.name = "Row$i"
            parallaxModelArrayList.add(parallaxModel)
        }

        loadParallax()
    }

    private fun loadParallax() {
        val parallaxAdapter = EventListAdapter(parallaxModelArrayList)
        recyclerview.adapter = parallaxAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}
