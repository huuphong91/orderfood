package com.example.huu.orderfood

import android.app.DatePickerDialog
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import com.example.huu.orderfood.Entities.NhanVienEntity
import kotlinx.android.synthetic.main.activity_dangky.*
import java.util.*

class DangKyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dangky)
        edtNgaySinh.setOnFocusChangeListener { v, hasFocus ->
            val id = v.id
            if (id == R.id.edtNgaySinh) {
                if (hasFocus) {
                    val calendar = Calendar.getInstance()
                    val iNam = calendar.get(Calendar.YEAR)
                    val iThang = calendar.get(Calendar.MONTH)+1
                    val iNgay = calendar.get(Calendar.DAY_OF_MONTH)
                    val dpd = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        edtNgaySinh.setText("$dayOfMonth/$month/$year")
                        },iNam,iThang,iNgay)

                    dpd.show()
                    //xuất popup ngày sinh
                }
            }

        }
    }

    fun onClickedBtnDongY(view: View) {
        NhanVienEntity.TENDN = edtTenDNDK.text.toString()
        NhanVienEntity.MATKHAU = edtMatKhau.text.toString()
    }

    fun onClickedBtnThoat(view: View) {

    }


}
