package com.example.libmana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.libmana.database.DbHelper;
import com.example.libmana.model.ThanhVien;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAO {

    private SQLiteDatabase db;

    public ThanhVienDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(ThanhVien obj) {

        ContentValues values = new ContentValues();
        values.put("hoTen", obj.hoTen);
        values.put("namSinh", obj.namSinh);
        values.put("ghiChu",obj.ghiChu);

        return db.insert("ThanhVien", null, values);
    }

    public int update(ThanhVien obj) {
        ContentValues values = new ContentValues();

        values.put("hoTen", obj.hoTen);
        values.put("namSinh", obj.namSinh);
       values.put("ghiChu",obj.ghiChu);


        return db.update("ThanhVien", values, "maTV=?", new String[]{String.valueOf(obj.maTV)});
    }

    public int delete(String id) {
        return db.delete("ThanhVien", "maTV=?", new String[]{id});
    }

    //get tat ca data
    public List<ThanhVien> getAll() {
        String sql = "SELECT * FROM ThanhVien";
        return getData(sql);
    }

    //get data theo id
    public ThanhVien getID(String id) {
        String sql = "SELECT * FROM ThanhVien WHERE maTV=?";
        List<ThanhVien> list = getData(sql, id);
        return list.get(0);
    }

    //get data nhieu tham so
    private List<ThanhVien> getData(String sql, String...selectionArgs) {

        List<ThanhVien> list = new ArrayList<ThanhVien>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            ThanhVien obj = new ThanhVien();
            obj.maTV = Integer.parseInt(c.getString(c.getColumnIndex("maTV")));
            obj.hoTen = c.getString(c.getColumnIndex("hoTen"));
            obj.namSinh = c.getString(c.getColumnIndex("namSinh"));
            obj.ghiChu = c.getString(c.getColumnIndex("ghiChu"));
            list.add(obj);
        }
        return list;
    }
}
