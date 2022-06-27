package com.example.libmana.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.libmana.R;
import com.example.libmana.fragment.LoaiSachFragment;
import com.example.libmana.model.LoaiSach;

import java.util.ArrayList;

public class LoaiSachAdapter extends ArrayAdapter<LoaiSach> {

    private Context context;
    LoaiSachFragment fragment;
    private ArrayList<LoaiSach> lists;
    TextView tvMaLoai, tvTenLoai;
    ImageView imgDel;

    public LoaiSachAdapter(@NonNull Context context, LoaiSachFragment fragment, ArrayList<LoaiSach> lists) {
        super(context,0,lists);
        this.context = context;
        this.lists = lists;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.loai_sach_item,null);
        }
        final LoaiSach item = lists.get(position);
        if (item != null) {
            tvMaLoai = v.findViewById(R.id.tvMaLoaiSach);
            tvMaLoai.setText("Mã lọai: " + item.maLoai);
            tvTenLoai = v.findViewById(R.id.tvTenLoaiSach);
            tvTenLoai.setText("Tên loại: " + item.tenLoai);
            imgDel = v.findViewById(R.id.imgDeleteLS);
//            if (item.maLoai % 2 == 0) {
//                tvMaLoai.setTypeface(null, Typeface.ITALIC);
//                tvTenLoai.setTypeface(null, Typeface.ITALIC);
//            } else if (item.maLoai == 0) {
//                tvMaLoai.setTextColor(Color.BLUE);
//                tvTenLoai.setTextColor(Color.BLUE);
//            } else if (item.maLoai % 2 != 0) {
//                tvMaLoai.setTypeface(null, Typeface.BOLD);
//                tvTenLoai.setTypeface(null, Typeface.BOLD);
//            }

        }

        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.xoa(String.valueOf(item.maLoai));
            }
        });
        return v;
    }
}
