package com.example.huu.orderfood

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import com.example.huu.orderfood.Entities.NhanVienEntity
import com.example.huu.orderfood.Fragments.HienThiBanAnFragment
import kotlinx.android.synthetic.main.activity_trang_chu.*

class TrangChuActivity : AppCompatActivity(){
        private lateinit var fragmentManager:FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_trang_chu)
        setSupportActionBar(toolbar)
        val view = navigationview_trangchu.getHeaderView(0)
        val txtTenNhanVien_Navigation:TextView = view.findViewById(R.id.txtTenNhanVien_Navigation)
            txtTenNhanVien_Navigation.setText(NhanVienEntity.TENDN)
        val drawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.mo,R.string.dong)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navigationview_trangchu.itemIconTintList =null
        fragmentManager = supportFragmentManager
        navigationview_trangchu.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itTrangChu -> hienThiFragmentBanAn(menuItem,drawerLayout)


            }
return@setNavigationItemSelectedListener false
        }
    }

    private fun hienThiFragmentBanAn(
        menuItem: MenuItem,
        drawerLayout: DrawerLayout
    ) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        val hienThiBanAnFragment = HienThiBanAnFragment()
        fragmentTransaction.replace(R.id.content, hienThiBanAnFragment)
        fragmentTransaction.commit()
        menuItem.setChecked(true)
        drawerLayout.closeDrawer(Gravity.START)

    }
}


