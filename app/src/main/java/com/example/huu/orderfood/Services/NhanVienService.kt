package com.example.huu.orderfood.Services

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.example.huu.orderfood.Entities.NhanVienEntity
import com.example.huu.orderfood.Utilities.*

object NhanVienService {
    fun themNhanVien(context: Context): Long {
        val contentValues = ContentValues()
        contentValues.put(TB_NHANVIEN_TENDN, NhanVienEntity.TENDN)
        contentValues.put(TB_NHANVIEN_CMND, NhanVienEntity.CMND)
        contentValues.put(TB_NHANVIEN_GIOITINH, NhanVienEntity.GIOITINH)
        contentValues.put(TB_NHANVIEN_MATKHAU, NhanVienEntity.MATKHAU)
        contentValues.put(TB_NHANVIEN_NGAYSINH, NhanVienEntity.NGAYSINH)
        return AuthService.createOrOpenDatabase(context).insert(TB_NHANVIEN,null,contentValues)
    }

    @SuppressLint("Recycle")
    fun kiemTraNhanVienTonTai(context: Context, complete:(Boolean)-> Unit) {
        val truyvan = "SELECT * FROM $TB_NHANVIEN"
        val cursor = AuthService.createOrOpenDatabase(context).rawQuery(truyvan,null)
        if (cursor.count != 0) {
            complete(true)
        } else {
            complete(false)
        }
    }



    @SuppressLint("Recycle")
    fun kiemTraDangNhap(context: Context, complete: (Boolean) -> Unit) {
        val truyvan = "SELECT * FROM $TB_NHANVIEN WHERE $TB_NHANVIEN_TENDN = '${NhanVienEntity.TENDN}' " +
                "AND $TB_NHANVIEN_MATKHAU = '${NhanVienEntity.MATKHAU}'"
        val cursor = AuthService.createOrOpenDatabase(context).rawQuery(truyvan, null)
        if (cursor.count != 0) {
            complete(true)

        } else {
            complete(false)
        }
    }
}