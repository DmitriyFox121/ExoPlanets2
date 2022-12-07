package com.example.exoplanets

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.text.method.ScrollingMovementMethod

import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {


    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)

       textView=infoTextrr
        textView.movementMethod=ScrollingMovementMethod()

    }




    fun setSelectedItem(selectedItem: String?) {
        val title = view?.findViewById<TextView>(R.id.detailsText)
        val details = view?.findViewById<TextView>(R.id.infoTextrr)
        val picture = view?.findViewById<ImageView>(R.id.imageView1)
        title?.text = selectedItem
        when(selectedItem) {
            "Испаряющаяся_планета" -> {
                details?.text = getString(R.string.Испаряющаяся_планета)
                picture?.setImageResource(R.drawable.first)

            }

            "Самая_темная_планета" -> { details?.text = getString(R.string.Самая_темная_планета)
                picture?.setImageResource(R.drawable.second)}

            "Дождь_из_расплавленного_стекла" -> {details?.text = getString(R.string.Дождь_из_расплавленного_стекла)
                picture?.setImageResource(R.drawable.third)}
            "Алмазные_залежи" -> {details?.text = getString(R.string.Алмазные_залежи)
                picture?.setImageResource(R.drawable.fourth)}
            "Невероятно_жарко" ->{ details?.text = getString(R.string.Невероятно_жарко)
                picture?.setImageResource(R.drawable.fifth)}
            "Ледяной_шар" -> {details?.text = getString(R.string.Ледяной_шар)
                    picture?.setImageResource(R.drawable.sixth)}
            "Каменные_дожди" -> { details?.text = getString(R.string.Каменные_дожди)
                picture?.setImageResource(R.drawable.seventh)}
            "Огромные_кольца" -> { details?.text = getString(R.string.Огромные_кольца)
                picture?.setImageResource(R.drawable.eight)}
            "Старейшая_планета" -> { details?.text = getString(R.string.Старейшая_планета)
                picture?.setImageResource(R.drawable.nineth)}
            "Триллион_километров_от_звезды" -> { details?.text = getString(R.string.Триллион_километров_от_звезды)
                picture?.setImageResource(R.drawable.tenth)}
            "Земля_2.0" -> { details?.text = getString(R.string.Земля_2_0)
                picture?.setImageResource(R.drawable.eleventh)}
        }
    }

}