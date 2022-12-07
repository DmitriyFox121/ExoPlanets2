package com.example.exoplanets

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import com.example.exoplanets.R
import java.lang.ClassCastException




class ListFragment : Fragment() {
    private lateinit var text: TextView


    internal interface OnFragmentSendDataListener {
        fun onSendData(data: String?)
    }
    private var fragmentSendDataListener: OnFragmentSendDataListener? = null
    var countries = arrayOf<String?>("Испаряющаяся_планета", "Самая_темная_планета",
        "Дождь_из_расплавленного_стекла", "Алмазные_залежи","Невероятно_жарко","Ледяной_шар","Каменные_дожди","Огромные_кольца",
        "Старейшая_планета","Триллион_километров_от_звезды","Земля_2.0")
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentSendDataListener = context as OnFragmentSendDataListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " должен реализовывать интерфейс OnFragmentInteractionListener"
            )
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container,
            false)
        // получаем элемент ListView
        val countriesList = view.findViewById<ListView>(R.id.countriesList)
        // создаем адаптер
        val adapter: ArrayAdapter<String?> =
            ArrayAdapter(context as Context, android.R.layout.simple_list_item_1,
                countries)


        // устанавливаем для списка адаптер
        countriesList.adapter = adapter
        // добавляем для списка слушатель
        countriesList.onItemClickListener =
            OnItemClickListener { parent, v, position, id ->
                // получаем выбранный элемент
                val selectedItem: String = parent.getItemAtPosition(position)
                        as String
                // Посылаем данные Activity
                fragmentSendDataListener!!.onSendData(selectedItem)
            }
        return view
    }

}