package com.example.libmana.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.libmana.R;
import com.example.libmana.fragment.TopFragment;
import com.example.libmana.model.Top;

import java.util.ArrayList;
import java.util.List;

public class TopAdapter extends ArrayAdapter<Top> {


//    Câu 4 : Bổ sung chức năng tìm kiếm ở màn hình thống kê
//    cho phép tìm kiếm theo tiêu đề thống kê 10 sách bán chạy .
//    Lưu ý chức năng tìm

    private Context context;
    TopFragment fragment;
    private ArrayList<Top> lists;
    TextView tvSach, tvSL;
    ImageView imgDel;

    public TopAdapter(@NonNull Context context, TopFragment fragment, @NonNull ArrayList<Top> lists) {
        super(context, 0, lists);
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
            v = inflater.inflate(R.layout.top_item,null);
        }
        final Top item = lists.get(position);
        if (item != null) {

            tvSach = v.findViewById(R.id.tvSach);
            tvSach.setText("Sách: "+item.tenSach);
            tvSL = v.findViewById(R.id.tvSL);
            tvSL.setText("Số lượng: "+item.soLuong);

            if (item.soLuong > 2 ){
                tvSach.setTextColor(Color.BLUE);
                tvSL.setTextColor(Color.BLUE);
                tvSL.setTextSize(40);
                tvSach.setTextSize(40);
            }

        }
        return v;
    }

}
