package hska.eva.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Luke on 12.01.2016.
 */
public class RatingRepository {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase writeableDb;
    private SQLiteDatabase readableDb;

    public RatingRepository(Context context){
        dbHelper = DatabaseHelper.getInstance(context);
        readableDb = dbHelper.getReadableDatabase();
        writeableDb = dbHelper.getWritableDatabase();
    }

    //Detail when User click on a Student Name
    public Cursor createRating(long studentId){
        return null;
    }

}
