package com.example.huu.orderfood.Services

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.huu.orderfood.Utilities.*

object AuthService {
    fun createOrOpenDatabase(context: Context):SQLiteDatabase {
        val openDatabase = object : SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
            override fun onCreate(db: SQLiteDatabase?) {
            val tbNhanVien = "CREATE TABLE $TB_NHANVIEN ($TB_NHANVIEN_MANV INTEGER PRIMARY KEY AUTOINCREMENT, $TB_NHANVIEN_TENDN TEXT," +
                    "$TB_NHANVIEN_MATKHAU TEXT, $TB_NHANVIEN_GIOITINH TEXT, $TB_NHANVIEN_NGAYSINH TEXT, $TB_NHANVIEN_CMND INTEGER)"
                val tbBanAn =
                    "CREATE TABLE $TB_BANAN ($TB_BANAN_MABAN INTEGER PRIMARY KEY AUTOINCREMENT, $TB_BANAN_TENBAN TEXT, $TB_BANAN_TINHTRANG TEXT)"
                val tbLoaiMon =
                    "CREATE TABLE $TB_LOAIMONAN ($TB_LOAIMONAN_MALOAI INTEGER PRIMARY KEY AUTOINCREMENT, $TB_LOAIMONAN_TENLOAI TEXT)"
                val tbMonAn =
                    "CREATE TABLE $TB_MONAN ($TB_MONAN_MAMON INTEGER PRIMARY KEY AUTOINCREMENT, $TB_MONAN_TENMONAN TEXT," +
                            "$TB_MONAN_MALOAI INTEGER, $TB_MONAN_GIATIEN TEXT)"
                val tbGoiMon =
                    "CREATE TABLE $TB_GOIMON($TB_GOIMON_MAGOIMON INTEGER PRIMARY KEY AUTOINCREMENT, $TB_GOIMON_MABAN INTEGER," +
                            "$TB_GOIMON_MANV INTEGER, $TB_GOIMON_NGAYGOI TEXT, $TB_GOIMON_TINHTRANG TEXT)"

                val tbChiTietGoiMon =
                    "CREATE TABLE $TB_CHITIETGOIMON($TB_CHITIETGOIMON_MAGOIMON INTEGER, $TB_CHITIETGOIMON_MAMONAN INTEGER," +
                            "$TB_CHITIETGOIMON_SOLUONG INTEGER, PRIMARY KEY($TB_CHITIETGOIMON_MAGOIMON,$TB_CHITIETGOIMON_MAMONAN))"
                if (db != null) {
                    db.execSQL(tbNhanVien)
                    db.execSQL(tbBanAn)
                    db.execSQL(tbChiTietGoiMon)
                    db.execSQL(tbGoiMon)
                    db.execSQL(tbMonAn)
                    db.execSQL(tbLoaiMon)
                }


            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

            }

        }
        return openDatabase.writableDatabase
    }
}