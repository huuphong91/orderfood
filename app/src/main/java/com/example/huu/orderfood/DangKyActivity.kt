package com.example.huu.orderfood

import android.app.DatePickerDialog
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.huu.orderfood.Entities.NhanVienEntity
import com.example.huu.orderfood.FragmentApp.DatePickerFragment
import com.example.huu.orderfood.Services.NhanVienService
import kotlinx.android.synthetic.main.activity_dangky.*
import java.util.*

class DangKyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dangky)
        edtNgaySinh.setOnFocusChangeListener { _, hasFocus ->

                if (hasFocus) {
                    val datePickerFragment = DatePickerFragment()
                    datePickerFragment.show(supportFragmentManager,"Ngày Sinh")
                    //xuất popup ngày sinh
                }


        }
        rbNam.isChecked = true
    }

    fun onClickedBtnDongY(view: View) {
        NhanVienEntity.TENDN = edtTenDNDK.text.toString()
        NhanVienEntity.MATKHAU = edtMatKhau.text.toString()
        NhanVienEntity.NGAYSINH = edtNgaySinh.text.toString()
        if (!edtCMND.text.toString().equals("")) {
            NhanVienEntity.CMND = edtCMND.text.toString().toInt()
        }

        NhanVienEntity.GIOITINH = when (rgGioiTinh.checkedRadioButtonId) {
            R.id.rbNam -> "Nam"
            else-> "Nữ"
        }
        if (NhanVienEntity.TENDN.equals("")) {
            Toast.makeText(this,"Bạn cần nhập tên đăng nhập",Toast.LENGTH_SHORT).show()
        }else if (NhanVienEntity.MATKHAU.equals("")) {
            Toast.makeText(this, "Bạn cần nhập mật khẩu", Toast.LENGTH_SHORT).show()
        } else {
            val kiemtra = NhanVienService.themNhanVien(this)
            if (kiemtra != 0L) {
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onClickedBtnThoat(view: View) {
finish()
    }


}
