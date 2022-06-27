package com.example.libmana.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.libmana.R;
import com.example.libmana.adapter.TopAdapter;
import com.example.libmana.dao.SachDAO;
import com.example.libmana.dao.ThongKeDAO;
import com.example.libmana.model.Sach;
import com.example.libmana.model.Top;

import java.util.ArrayList;
import java.util.List;

public class TopFragment extends Fragment {
    ListView lv;
    ArrayList<Top> list;
    TopAdapter adapter;
    EditText edTim;
    Button btnTim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_top, container, false);
        lv = v.findViewById(R.id.lvTop);
        edTim = v.findViewById(R.id.edTimKiem);
        btnTim = v.findViewById(R.id.btnFind);


        ThongKeDAO thongKeDAO = new ThongKeDAO(getActivity());
        list = (ArrayList<Top>) thongKeDAO.getTop();
        adapter = new TopAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);

        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //timKiem
            }
        });

        return v;
    }
}