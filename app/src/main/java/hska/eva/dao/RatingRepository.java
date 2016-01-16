package hska.eva.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import hska.eva.dao.DatabaseSchema.dbRating;
import hska.eva.domain.Rating;

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

    public Cursor findAllRatingsForStudent(long studentID){
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(dbRating.TABLE_NAME
        );
        return qb.query(readableDb,
                null,
                dbRating.TABLE_NAME + "." + dbRating.COLUMN_NAME_STUDENT_FK + "=" + studentID,
                null, null, null, null);
    }

    public Rating addRating(Rating rating){
        ContentValues values = new ContentValues();
        values.put(dbRating.COLUMN_NAME_MOTIVATION, rating.getMotivation());
        values.put(dbRating.COLUMN_NAME_TEAMFAEHIGKEIT, rating.getTeamfaehigkeit());
        values.put(dbRating.COLUMN_NAME_KOMMUNIKATION, rating.getKommunikation());
        values.put(dbRating.COLUMN_NAME_KNOWHOW, rating.getKnowhow());
        values.put(dbRating.COLUMN_NAME_STUDENTB_FK, rating.getStudentb_fk());
        values.put(dbRating.COLUMN_NAME_STUDENT_FK, rating.getStudent_fk());

        long id = writeableDb.insert(dbRating.TABLE_NAME, null, values);
        if(id == -1){
            return null;
        }
        rating.setId(id);
        return rating;
    }
}
