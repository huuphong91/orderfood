package com.example.huu.orderfood.Services

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.example.huu.orderfood.Entities.ChiTietGoiMonEntity2
import com.example.huu.orderfood.Entities.GoiMonEntity
import com.example.huu.orderfood.Utilities.*

object GoiMonService {
    fun themGoiMon(context: Context, complition:(Boolean) -> Unit) {
        val contentValues = ContentValues()
        contentValues.put(TB_GOIMON_MABAN, GoiMonEntity.MABAN)
        contentValues.put(TB_GOIMON_MANV, GoiMonEntity.MANV)
        contentValues.put(TB_GOIMON_TINHTRANG, GoiMonEntity.TINHTRANG)
        contentValues.put(TB_GOIMON_NGAYGOI, GoiMonEntity.NGAYGOI)
        val kiemtra = AuthService.createOrOpenDatabase(context).insert(TB_GOIMON,null,contentValues)
        if (kiemtra != 0L) {
            complition(true)
        } else {
            complition(false)
        }
    }

    fun layMaGoiMonTheoMaBan(context: Context, maban:Int): Long {
        val truyvan = "SELECT * FROM $TB_GOIMON WHERE $TB_GOIMON_MABAN = ${maban} " +
                    "AND $TB_GOIMON_TINHTRANG = 'false'"
        val cursor = AuthService.createOrOpenDatabase(context).rawQuery(truyvan, null)
        var magoimon = 0L
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            magoimon = cursor.getLong(cursor.getColumnIndex(TB_GOIMON_MAGOIMON))
            cursor.moveToNext()
        }
        return magoimon
    }

    @SuppressLint("Recycle")
    fun kiemTraMonAnDaTonTai(context: Context, magoimon: Int, mamonan: Int, complition: (Boolean) -> Unit) {
        val truyvan = "SELECT * FROM $TB_CHITIETGOIMON WHERE $TB_CHITIETGOIMON_MAMONAN = $mamonan AND " +
                "$TB_GOIMON_MAGOIMON = $magoimon"
        val cursor = AuthService.createOrOpenDatabase(context).rawQuery(truyvan, null)
        if (cursor.count != 0) {
            complition(true)
        } else {
            complition(false)
        }

    }

    fun laySoLuongMonAnTheoMaGoiMon(context: Context, magoimon: Int):Int {
        var soluong = 0
        val truyvan = "SELECT * FROM $TB_CHITIETGOIMON WHERE $TB_CHITIETGOIMON_MAGOIMON = $magoimon"
        val cursor = AuthService.createOrOpenDatabase(context).rawQuery(truyvan, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            soluong = cursor.getInt(cursor.getColumnIndex(TB_CHITIETGOIMON_SOLUONG))
            cursor.moveToNext()
        }
        return soluong
    }

    fun capNhatSoLuongMonAn(context: Context, chiTietGoiMonEntity2: ChiTietGoiMonEntity2,complition: (Boolean) -> Unit) {
        val contentValues = ContentValues()
        contentValues.put(TB_CHITIETGOIMON_SOLUONG, chiTietGoiMonEntity2.soluong)
        val kiemtra= AuthService.createOrOpenDatabase(context).update(TB_CHITIETGOIMON,contentValues,"$TB_CHITIETGOIMON_MAGOIMON = ${chiTietGoiMonEntity2.magoimon} " +
                "AND $TB_CHITIETGOIMON_MAMONAN = ${chiTietGoiMonEntity2.mamonan}",null)
        if (kiemtra != 0) {
            complition(true)
        } else {
            complition(false)
        }
    }

    fun themChiTietGoiMon(context: Context, chiTietGoiMonEntity2: ChiTietGoiMonEntity2, complition: (Boolean) -> Unit) {
        val contentValues = ContentValues()
        contentValues.put(TB_CHITIETGOIMON_MAMONAN, chiTietGoiMonEntity2.mamonan)
        contentValues.put(TB_GOIMON_MAGOIMON, chiTietGoiMonEntity2.magoimon)
        contentValues.put(TB_CHITIETGOIMON_SOLUONG, chiTietGoiMonEntity2.soluong)
        val kiemtra = AuthService.createOrOpenDatabase(context).insert(TB_CHITIETGOIMON, null, contentValues)
        if (kiemtra != 0L) {
            complition(true)
        } else {
            complition(false)
        }
    }
    }