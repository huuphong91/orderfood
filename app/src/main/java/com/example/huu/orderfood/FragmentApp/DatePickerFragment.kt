package com.example.huu.orderfood.FragmentApp

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.Editable
import android.widget.DatePicker
import android.widget.EditText
import com.example.huu.orderfood.R
import kotlinx.android.synthetic.main.activity_dangky.*
import java.util.*

class DatePickerFragment:DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val iNam = calendar.get(Calendar.YEAR)
        val iThang = calendar.get(Calendar.MONTH)+1
        val iNgay = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity,this,iNam,iThang,iNgay)
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
       val edtNgaySinh = activity?.findViewById<EditText>(R.id.edtNgaySinh) as EditText
        val sNgaySinh = "$dayOfMonth/${month+1}/$year"
        edtNgaySinh.setText(sNgaySinh)
    }
}