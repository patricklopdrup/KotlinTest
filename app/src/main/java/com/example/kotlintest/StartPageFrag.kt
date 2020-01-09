package com.example.kotlintest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class StartPageFrag : Fragment() {

    lateinit var image: ImageView
    lateinit var button1: Button
    lateinit var button2: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_start_page, container, false);

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = view.findViewById(R.id.start_page_img)
        button1 = view.findViewById(R.id.start_page_button1)
        button2 = view.findViewById(R.id.start_page_button2)

        image.setImageResource(R.drawable.ic_launcher_background)
    }
}