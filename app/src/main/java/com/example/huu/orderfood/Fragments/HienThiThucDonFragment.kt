package com.example.huu.orderfood.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.GridView
import com.example.huu.orderfood.Adapters.HienThiLoaiMonAnAdapter
import com.example.huu.orderfood.Entities.LoaiMonAnEntity2

import com.example.huu.orderfood.R
import com.example.huu.orderfood.Services.LoaiMonAnService
import com.example.huu.orderfood.ThemBanAnActivity
import com.example.huu.orderfood.ThemThucDonActivity
import com.example.huu.orderfood.TrangChuActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HienThiThucDonFragment : Fragment() {
    lateinit var danhSachLoaiMonAn:List<LoaiMonAnEntity2>
    lateinit var adapter:HienThiLoaiMonAnAdapter
    lateinit var gvHienThiLoaiMonAn: GridView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hien_thi_thuc_don, container, false)
        setHasOptionsMenu(true)
        val activityTrangChuActivity: TrangChuActivity? = activity as TrangChuActivity?
        activityTrangChuActivity?.supportActionBar!!.setTitle(R.string.thucdon)
        gvHienThiLoaiMonAn = view.findViewById(R.id.gvHienThiThucDon) as GridView
        hienThiDanhSachLoaiMonAn()
        adapter.notifyDataSetChanged()


        return view
    }

    override fun onResume() {
        super.onResume()
        hienThiDanhSachLoaiMonAn()
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        //thêm item menu sẵn có không cần inflate menu
        if (menu != null) {
            val itThemThucDon = menu.add(1,R.id.itThemThucDon,1,R.string.themthucdon)
            //tạo icon cho menu item
            itThemThucDon.setIcon(R.drawable.logodangnhap)
            //hiển thị menu item nếu còn chỗ trống trên toolbar
            itThemThucDon.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.itThemThucDon -> themThucDOn()
        }
        return true

    }

    private fun themThucDOn() {
        val intent = Intent(activity, ThemThucDonActivity::class.java)
        startActivity(intent)
    }

    private fun hienThiDanhSachLoaiMonAn() {
        danhSachLoaiMonAn = LoaiMonAnService.layTatCaLoaiMonAn(activity!!)
        adapter = HienThiLoaiMonAnAdapter(activity!!, danhSachLoaiMonAn)
        gvHienThiLoaiMonAn.adapter = adapter
    }

}
