package com.example.huu.orderfood.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*

import com.example.huu.orderfood.R
import com.example.huu.orderfood.ThemBanAnActivity
import android.widget.GridView
import com.example.huu.orderfood.Adapters.HienThiBanAnAdapter
import com.example.huu.orderfood.Entities.BanAnEntity2
import com.example.huu.orderfood.Services.BanAnService


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HienThiBanAnFragment : Fragment() {
    lateinit var danhSachBanAn:List<BanAnEntity2>
    lateinit var adapter: HienThiBanAnAdapter
    lateinit var gvHienThiBanAn:GridView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hien_thi_ban_an, container, false)
        //Khai báo rằng fragment này có option menu
        setHasOptionsMenu(true)
        gvHienThiBanAn = view.findViewById(R.id.gvHienBanAn) as GridView
        hienThiDanhSachBanAn()
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        //thêm item menu sẵn có không cần inflate menu
        if (menu != null) {
            val itThemBanAn = menu.add(1,R.id.itThemBanAn,1,R.string.thembanan)
            //tạo icon cho menu item
            itThemBanAn.setIcon(R.drawable.thembanan)
            //hiển thị menu item nếu còn chỗ trống trên toolbar
            itThemBanAn.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        }


    }

    override fun onResume() {
        super.onResume()
        hienThiDanhSachBanAn()
    }





    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.itThemBanAn -> themBanAn()
        }
        return true
    }

    private fun themBanAn() {
        val intent = Intent(activity, ThemBanAnActivity::class.java)
        startActivity(intent)
    }

    private fun hienThiDanhSachBanAn() {
        danhSachBanAn = BanAnService.layTatCaBanAn(activity!!)
        adapter = HienThiBanAnAdapter(activity!!,danhSachBanAn)
        gvHienThiBanAn.adapter = adapter
    }
}
