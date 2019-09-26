package com.jcmo.main


import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_eventos.view.*
import java.text.SimpleDateFormat
import java.util.*


class EventosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        var cal = Calendar.getInstance()
        var textview_date: TextView? = null

        val root = inflater.inflate(R.layout.fragment_eventos, container, false)
        textview_date = root.text_view_date_1
        //textview_date!!.text = "--/--/----"
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
            private fun updateDateInView() {
                val myFormat = "MM/dd/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                textview_date.text = sdf.format(cal.getTime())
            }
        }

        root.fab4.setOnClickListener { view ->
            context?.let {
                DatePickerDialog(
                    it,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //  .setAction("Action", null).show()
        }

        return root
    }

    }
