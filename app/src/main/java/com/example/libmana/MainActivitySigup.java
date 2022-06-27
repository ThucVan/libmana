package com.example.libmana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.libmana.dao.ThuThuDAO;
import com.example.libmana.model.ThuThu;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivitySigup extends AppCompatActivity {

    TextInputEditText edUser, edHoTen, edPass, edRePass;
    Button btnSave, btnCancel;
    ThuThuDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_user);
        edUser = findViewById(R.id.edUser);
        edHoTen = findViewById(R.id.edHoTen);
        edPass = findViewById(R.id.edPass);
        edRePass = findViewById(R.id.edRePass);
        btnCancel = findViewById(R.id.btnCancelUser);
        btnSave = findViewById(R.id.btnSaveUser);

        dao = new ThuThuDAO(getBaseContext());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUser.setText("");
                edHoTen.setText("");
                edPass.setText("");
                edRePass.setText("");
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThuThu thuThu = new ThuThu();
                thuThu.maTT = edUser.getText().toString();
                thuThu.hoTen = edHoTen.getText().toString();
                thuThu.matKhau = edPass.getText().toString();
                if (validate()>0) {
                    if (dao.insert(thuThu) > 0) {
                        Toast.makeText(getBaseContext(),"Lưu thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivitySigup.this, MainActivity.class);
                        startActivity(intent);
                        edUser.setText("");
                        edHoTen.setText("");
                        edPass.setText("");
                        edRePass.setText("");
                    } else {
                        Toast.makeText(getBaseContext(),"Lưu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public int validate() {
        int check = 1;
        if (edUser.getText().length()==0 || edHoTen.getText().length()==0 || edPass.getText().length()==0
                || edRePass.getText().length()==0) {
            Toast.makeText(getBaseContext(),"Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getBaseContext(),"Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }

        return check;
    }
}