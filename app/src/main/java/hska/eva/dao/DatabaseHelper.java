package hska.eva.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import hska.eva.dao.DatabaseSchema.dbRating;
import hska.eva.dao.DatabaseSchema.dbStudent;

/**
 * Created by Luke on 08.01.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "eva.db";

    /*****************/
    /**   STUDENT   **/
    /*****************/
    private static final String SQL_CREATE_STUDENT_TABLE =
            "CREATE TABLE " + dbStudent.TABLE_NAME + " (" +
                    dbStudent._ID + " INTEGER PRIMARY KEY," +
                    dbStudent.COLUMN_NAME_EMAIL + " TEXT," +
                    dbStudent.COLUMN_NAME_VORNAME + " TEXT," +
                    dbStudent.COLUMN_NAME_NACHNAME + " TEXT," +
                    dbStudent.COLUMN_NAME_PASSWORD + " TEXT" +
                    ");";

    public static final String SQL_DELETE_STUDENT_TABLE =
            "DROP TABLE IF EXISTS " + dbStudent.TABLE_NAME;

    /*****************/
    /**    RATING   **/
    /*****************/
    private static final String SQL_CREATE_RATING_TABLE =
            "CREATE TABLE " + dbRating.TABLE_NAME + " (" +
                    dbRating._ID + " INTEGER PRIMARY KEY," +
                    dbRating.COLUMN_NAME_MOTIVATION + " INTEGER," +
                    dbRating.COLUMN_NAME_TEAMFAEHIGKEIT + " INTEGER," +
                    dbRating.COLUMN_NAME_KOMMUNIKATION + " INTEGER," +
                    dbRating.COLUMN_NAME_KNOWHOW + " INTEGER," +
                    dbRating.COLUMN_NAME_STUDENTB_FK + " INTEGER," +
                    dbRating.COLUMN_NAME_STUDENT_FK + " INTEGER," +
                    "FOREIGN KEY(" + DatabaseSchema.dbRating.COLUMN_NAME_STUDENTB_FK + ") REFERENCES " + dbStudent.TABLE_NAME + "(" + dbStudent._ID + "), " +
                    "FOREIGN KEY(" + DatabaseSchema.dbRating.COLUMN_NAME_STUDENT_FK + ") REFERENCES " + dbStudent.TABLE_NAME + "(" + dbStudent._ID + ")" +
                    ");";

    public static final String SQL_DELETE_RATING_TABLE =
            "DROP TABLE IF EXISTS " + dbRating.TABLE_NAME;

    private static DatabaseHelper instance;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Context ctx = context;
    }

    public static DatabaseHelper getInstance(Context ctx){
        if(instance == null){
            instance = new DatabaseHelper(ctx);
            return instance;
        }
        return instance;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_STUDENT_TABLE);
        db.execSQL(SQL_CREATE_RATING_TABLE);

        /*****************/
        /** STUDENT ADD **/
        /*****************/
        ContentValues values = new ContentValues();
        values.put(dbStudent.COLUMN_NAME_EMAIL, "frlu1012@hs-karlsruhe.de");
        values.put(dbStudent.COLUMN_NAME_VORNAME, "Lukas");
        values.put(dbStudent.COLUMN_NAME_NACHNAME, "Frank");
        values.put(dbStudent.COLUMN_NAME_PASSWORD, "password");
        db.insert(dbStudent.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(dbStudent.COLUMN_NAME_EMAIL, "kost1012@hs-karlsruhe.de");
        values.put(dbStudent.COLUMN_NAME_VORNAME, "Stephan");
        values.put(dbStudent.COLUMN_NAME_NACHNAME, "Koch");
        values.put(dbStudent.COLUMN_NAME_PASSWORD, "password");
        db.insert(dbStudent.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(dbStudent.COLUMN_NAME_EMAIL, "beno1012@hs-karlsruhe.de");
        values.put(dbStudent.COLUMN_NAME_VORNAME, "Norman");
        values.put(dbStudent.COLUMN_NAME_NACHNAME, "Beyerle");
        values.put(dbStudent.COLUMN_NAME_PASSWORD, "password");
        db.insert(dbStudent.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(dbStudent.COLUMN_NAME_EMAIL, "muma1012@hs-karlsruhe.de");
        values.put(dbStudent.COLUMN_NAME_VORNAME, "Matthias");
        values.put(dbStudent.COLUMN_NAME_NACHNAME, "Müller");
        values.put(dbStudent.COLUMN_NAME_PASSWORD, "password");
        db.insert(dbStudent.TABLE_NAME, null, values);

        /****************/
        /** RATING ADD **/
        /****************/
        values.clear();
        values.put(dbRating.COLUMN_NAME_MOTIVATION, "3");
        values.put(dbRating.COLUMN_NAME_TEAMFAEHIGKEIT, "2");
        values.put(dbRating.COLUMN_NAME_KOMMUNIKATION, "1");
        values.put(dbRating.COLUMN_NAME_KNOWHOW, "4");
        values.put(dbRating.COLUMN_NAME_STUDENTB_FK, "2");
        values.put(dbRating.COLUMN_NAME_STUDENT_FK, "1");
        db.insert(dbRating.TABLE_NAME, null, values);

        values.put(dbRating.COLUMN_NAME_MOTIVATION, "3");
        values.put(dbRating.COLUMN_NAME_TEAMFAEHIGKEIT, "2");
        values.put(dbRating.COLUMN_NAME_KOMMUNIKATION, "1");
        values.put(dbRating.COLUMN_NAME_KNOWHOW, "4");
        values.put(dbRating.COLUMN_NAME_STUDENTB_FK, "3");
        values.put(dbRating.COLUMN_NAME_STUDENT_FK, "1");
        db.insert(dbRating.TABLE_NAME, null, values);

        values.put(dbRating.COLUMN_NAME_MOTIVATION, "3");
        values.put(dbRating.COLUMN_NAME_TEAMFAEHIGKEIT, "2");
        values.put(dbRating.COLUMN_NAME_KOMMUNIKATION, "1");
        values.put(dbRating.COLUMN_NAME_KNOWHOW, "4");
        values.put(dbRating.COLUMN_NAME_STUDENTB_FK, "4");
        values.put(dbRating.COLUMN_NAME_STUDENT_FK, "1");

        db.insert(dbRating.TABLE_NAME, null, values);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_STUDENT_TABLE);
        db.execSQL(SQL_DELETE_RATING_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

