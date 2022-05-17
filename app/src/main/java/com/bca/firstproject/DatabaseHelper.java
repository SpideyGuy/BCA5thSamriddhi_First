package com.bca.firstproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "studentDb";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Student.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insertStudent(String name, String nickname, String phone, String photo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Student.COLUMN_NAME, name);
        values.put(Student.COLUMN_NICKNAME, nickname);
        values.put(Student.COLUMN_PHONE, phone);
        values.put(Student.COLUMN_PHOTO, photo);

        long id = db.insert(Student.TABLE_NAME, null, values);

        db.close();

        return id;

    }

    public long updateStudent(int id, String name, String nickname, String phone, String photo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Student.COLUMN_NAME, name);
        values.put(Student.COLUMN_NICKNAME, nickname);
        values.put(Student.COLUMN_PHONE, phone);
        values.put(Student.COLUMN_PHOTO, photo);

        String whereClause = Student.COLUMN_ID + " = " + id;

        long updated_id = db.update(Student.TABLE_NAME, values , whereClause, null);

        db.close();

        return updated_id;
    }

    public ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Student.TABLE_NAME,
                new String[]{Student.COLUMN_ID,
                        Student.COLUMN_NAME,
                        Student.COLUMN_NICKNAME,
                        Student.COLUMN_PHONE,
                        Student.COLUMN_PHOTO,
                        Student.COLUMN_TIMESTAMP},
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor!=null){
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                do{
                    @SuppressLint("Range") Student user = new Student(
                            cursor.getString(cursor.getColumnIndex(Student.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(Student.COLUMN_NICKNAME)),
                            cursor.getString(cursor.getColumnIndex(Student.COLUMN_PHONE)),
                            cursor.getString(cursor.getColumnIndex(Student.COLUMN_PHOTO)));
                    students.add(user);
                }while(cursor.moveToNext());
            }
        }

        db.close();
        return students;
    }

}
