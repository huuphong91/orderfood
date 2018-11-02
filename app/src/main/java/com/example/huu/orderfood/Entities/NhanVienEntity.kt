package com.example.huu.orderfood.Entities
//Đối tượng singleton này dùng để lưu giá trị tạm thời của các trường trong table NHANVIEN
//mà người dùng đã tương tác. Có chức năng hỗ trợ các phương thức , thao tác CRUD vào SQLiteDatabase
//liên quan đến NHANVIEN
object NhanVienEntity {
    var MANV:Int = 0
    var TENDN = ""
    var MATKHAU = ""
    var GIOITINH = ""
    var NGAYSINH = ""
    var CMND:Int = 0
//Reset lại data về mặc định nếu cần thiết
    fun resetData() {
         MANV = 0
         TENDN = ""
         MATKHAU = ""
         GIOITINH = ""
         NGAYSINH = ""
         CMND = 0
    }
}