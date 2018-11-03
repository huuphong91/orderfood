package com.example.huu.orderfood.Services

import android.content.ContentValues
import android.content.Context
import com.example.huu.orderfood.Entities.BanAnEntity
import com.example.huu.orderfood.Entities.BanAnEntity2
import com.example.huu.orderfood.Utilities.TB_BANAN
import com.example.huu.orderfood.Utilities.TB_BANAN_MABAN
import com.example.huu.orderfood.Utilities.TB_BANAN_TENBAN
import com.example.huu.orderfood.Utilities.TB_BANAN_TINHTRANG

object BanAnService {
    fun themBanAn(context: Context): Long {
        val contentValues = ContentValues()
        contentValues.put(TB_BANAN_TENBAN, BanAnEntity.TENBAN)
        contentValues.put(TB_BANAN_TINHTRANG, BanAnEntity.TINHTRANG)
        return AuthService.createOrOpenDatabase(context).insert(TB_BANAN,null,contentValues)
    }

    fun layTatCaBanAn(context: Context): List<BanAnEntity2> {
        val danhSachBanAn = arrayListOf<BanAnEntity2>()
        val truyvan = "SELECT * FROM $TB_BANAN"
        val cursor = AuthService.createOrOpenDatabase(context).rawQuery(truyvan,null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            BanAnEntity.MABAN = cursor.getInt(cursor.getColumnIndex(TB_BANAN_MABAN))
            BanAnEntity.TENBAN = cursor.getString(cursor.getColumnIndex(TB_BANAN_TENBAN))
            val banAnEntity2 = BanAnEntity.createBanAnEntity()
            danhSachBanAn.add(banAnEntity2)
            cursor.moveToNext()
        }
        return danhSachBanAn

    }
}