package com.example.huu.orderfood.Entities

object BanAnEntity {
    var MABAN:Int = 0
    var TENBAN = ""
    var TINHTRANG = "false"


    fun createBanAnEntity(): BanAnEntity2 {
        return BanAnEntity2(MABAN, TENBAN)
    }
}

class BanAnEntity2(var maban:Int,var tenban:String)