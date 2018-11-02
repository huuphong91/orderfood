package com.example.huu.orderfood.Services

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
        val kiemtra = AuthService.createOrOpenDatabase(context).insert(TB_NHANVIEN,null,contentValues)
        return kiemtra
    }
}