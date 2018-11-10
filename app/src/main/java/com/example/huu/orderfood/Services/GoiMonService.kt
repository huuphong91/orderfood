package com.example.huu.orderfood.Services

import android.content.ContentValues
import android.content.Context
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
}