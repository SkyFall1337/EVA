package hska.eva.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import hska.eva.dao.DatabaseSchema.dbStudent;

/**
 * Created by Steko on 11.01.2016.
 */
public class StudentRepository {

    private DatabaseHelper dbhelper;
    private SQLiteDatabase writeableDb;
    private SQLiteDatabase readableDb;

    public StudentRepository(Context context){
        dbhelper = DatabaseHelper.getInstance(context);
        writeableDb = dbhelper.getWritableDatabase();
        readableDb = dbhelper.getReadableDatabase();

    }

    public Cursor getAllStudents(){
        Cursor cursor = readableDb.query(dbStudent.TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
}
