package com.example.libmana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.libmana.dao.ThuThuDAO;
import com.example.libmana.fragment.AddUserFragment;
import com.example.libmana.fragment.ChangePassFragment;
import com.example.libmana.fragment.DoanhThuFragment;
import com.example.libmana.fragment.LoaiSachFragment;
import com.example.libmana.fragment.PhieuMuonFragment;
import com.example.libmana.fragment.SachFragment;
import com.example.libmana.fragment.ThanhVienFragment;
import com.example.libmana.fragment.TopFragment;
import com.example.libmana.model.ThuThu;
import com.google.android.material.navigation.NavigationView;
//Câu 1 : Khi mở chương trình thay vì màn hình chào, đổi thành hiển thị màn hình Home(Menu) rồi hiển thị dòng chữ Toast Chào mừng đến với trang chủ
//        Câu 2 : Tại màn hình danh sách thế loại sách, vị trí chẵn thì in chữ in nghiêng, vị trí lẽ thì in chữ in đậm, vị trí = 0 thì in màu xanh
 //       Câu 3 : Bổ sung cột ghi chú ở  bảng Thành viên  và hiển thị thêm thông tin ghi chú trên màn hình danh sách thành viên
 //       Câu 4 : Bổ sung chức năng tìm kiếm ở màn hình thống kê  cho phép tìm kiếm theo tiêu đề thống kê 10

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    Toolbar toolbar;
    View mHeaderView;
    TextView edUser;
    ThuThuDAO thuThuDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        //set toolbar the the cho actionbar
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.menu);
        ab.setDisplayHomeAsUpEnabled(true);
        //dung fragment_PhieuMuon la home
        FragmentManager manager = getSupportFragmentManager();
        PhieuMuonFragment phieuMuonFragment = new PhieuMuonFragment();
        manager.beginTransaction()
                .replace(R.id.flContent,phieuMuonFragment)
                .commit();

        NavigationView nv = findViewById(R.id.nvView);
        //show user in header
        mHeaderView = nv.getHeaderView(0);
        edUser = mHeaderView.findViewById(R.id.tvUser);
        Intent i = getIntent();
        String user = i.getStringExtra("user");
//        thuThuDAO = new ThuThuDAO(this);
//        ThuThu thuThu = thuThuDAO.getID(user);
//        String username = thuThu.hoTen;
        edUser.setText("Welcome "+user+"!");

        // admin co quyen add user
     // if (user.equalsIgnoreCase("admin")) {
      ///      nv.getMenu().findItem(R.id.sub_AddUser).setVisible(true);
     //  }

        // Dieu huong navigation
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();

                switch (item.getItemId()) {
                    case R.id.nav_PhieuMuon:
                        setTitle("Quản lý phiếu mượn");
                        PhieuMuonFragment phieuMuonFragment = new PhieuMuonFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,phieuMuonFragment)
                                .commit();
                        break;
                    case R.id.nav_LoaiSach:
                        setTitle("Quản lý loại sách");
                        LoaiSachFragment loaiSachFragment = new LoaiSachFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,loaiSachFragment)
                                .commit();
                        break;
                    case R.id.nav_Sach:
                        setTitle("Quản lý sách");
                        SachFragment sachFragment = new SachFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,sachFragment)
                                .commit();
                        break;
                    case R.id.nav_ThanhVien:
                        setTitle("Quản lý thành viên");
                        ThanhVienFragment thanhVienFragment = new ThanhVienFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,thanhVienFragment)
                                .commit();
                        break;
                    case R.id.sub_Top:
                        setTitle("Top 10 sách cho thuê nhiều nhất");
                        TopFragment topFragment = new TopFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,topFragment)
                                .commit();
                        break;
                    case R.id.sub_DoanhThu:
                        setTitle("Thống kê doanh thu");
                        DoanhThuFragment doanhThuFragment = new DoanhThuFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,doanhThuFragment)
                                .commit();
                        break;
                    case R.id.sub_AddUser:
                        setTitle("Thêm người dùng");
                        AddUserFragment addUserFragment = new AddUserFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,addUserFragment)
                                .commit();
                        break;
                    case R.id.sub_Pass:
                        setTitle("Thay đổi mật khẩu");
                        ChangePassFragment changePassFragment = new ChangePassFragment();
                        manager.beginTransaction()
                                .replace(R.id.flContent,changePassFragment)
                                .commit();
                        break;
                    case R.id.sub_Logout:

                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();
                        break;
                }

                drawer.closeDrawers();

                return false;
            }

        });


       Toast.makeText(getApplicationContext(), "Chào mừng đến với trang chủ", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home)
            drawer.openDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }


}