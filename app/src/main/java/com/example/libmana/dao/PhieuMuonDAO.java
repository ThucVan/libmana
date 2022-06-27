package com.example.libmana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.libmana.database.DbHelper;
import com.example.libmana.model.PhieuMuon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonDAO {

    private SQLiteDatabase db;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public PhieuMuonDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(PhieuMuon obj) {

        ContentValues values = new ContentValues();
        values.put("maTT", obj.maTT);
        values.put("maTV", obj.maTV);
        values.put("maSach", obj.maSach);
        values.put("ngay", sdf.format(obj.ngay));
        values.put("tienThue", obj.tienThue);
        values.put("traSach", obj.traSach);
        values.put("khuyenMai", obj.khuyenMai);


        return db.insert("PhieuMuon", null, values);
    }

    public int update(PhieuMuon obj) {
        ContentValues values = new ContentValues();

        values.put("maTT", obj.maTT);
        values.put("maTV", obj.maTV);
        values.put("maSach", obj.maSach);
        values.put("ngay", sdf.format(obj.ngay));
        values.put("tienThue", obj.tienThue);
        values.put("traSach", obj.traSach);
        values.put("khuyenMai", obj.khuyenMai);


        return db.update("PhieuMuon", values, "maPM=?", new String[]{String.valueOf(obj.maPM)});
    }

    public int delete(String id) {
        return db.delete("PhieuMuon", "maPM=?", new String[]{id});
    }

    //get tat ca data
    public List<PhieuMuon> getAll() {
        String sql = "SELECT * FROM PhieuMuon";
        return getData(sql);
    }

    //get data theo id
    public PhieuMuon getID(String id) {
        String sql = "SELECT * FROM PhieuMuon WHERE maPM=?";
        List<PhieuMuon> list = getData(sql, id);
        return list.get(0);
    }

    //get data nhieu tham so
    private List<PhieuMuon> getData(String sql, String...selectionArgs) {

        List<PhieuMuon> list = new ArrayList<PhieuMuon>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            PhieuMuon obj = new PhieuMuon();
            obj.maPM = Integer.parseInt(c.getString(c.getColumnIndex("maPM")));
            obj.maTT = c.getString(c.getColumnIndex("maTT"));
            obj.maTV = Integer.parseInt(c.getString(c.getColumnIndex("maTV")));
            obj.maSach = Integer.parseInt(c.getString(c.getColumnIndex("maSach")));
            try {
                obj.ngay = sdf.parse(c.getString(c.getColumnIndex("ngay")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            obj.tienThue = Integer.parseInt(c.getString(c.getColumnIndex("tienThue")));
            obj.traSach = Integer.parseInt(c.getString(c.getColumnIndex("traSach")));
            obj.khuyenMai = c.getString(c.getColumnIndex("khuyenMai"));
            list.add(obj);
        }
        return list;
    }
}
