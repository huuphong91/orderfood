package com.example.huu.orderfood.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.huu.orderfood.Entities.BanAnEntity2
import com.example.huu.orderfood.R
import android.widget.TextView
import android.support.design.widget.CoordinatorLayout.Behavior.setTag
import com.example.huu.orderfood.Entities.NhanVienEntity2


class HienThiBanAnAdapter(val context: Context, val danhSachBanAn:List<BanAnEntity2>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_layout_hienthibanan, parent, false)
            viewHolder = ViewHolder()
            viewHolder.imBanAn = view.findViewById(R.id.imBanAn) as ImageView
            viewHolder.imGoiMon = view.findViewById(R.id.imGoiMon) as ImageView
            viewHolder.imThanhToan = view.findViewById(R.id.imThanhToan) as ImageView
            viewHolder.imAnButton = view.findViewById(R.id.imAnButton) as ImageView
            viewHolder.txtTenBanAn = view.findViewById(R.id.txtTenBanAn) as TextView

            view.tag = viewHolder

        } else {
            viewHolder = convertView.getTag() as ViewHolder
            view = convertView
        }
        viewHolder.txtTenBanAn!!.setText(danhSachBanAn.get(position).tenban);
        view.setOnClickListener { v ->

                viewHolder.imGoiMon?.visibility = View.VISIBLE
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return danhSachBanAn.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return danhSachBanAn.count()
    }

    private class ViewHolder {
        var imBanAn: ImageView? = null
        var imGoiMon:ImageView? = null
        var imThanhToan:ImageView? = null
        var imAnButton:ImageView? = null
        var txtTenBanAn: TextView? = null
    }
}