package hska.eva.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/** * Created by Luke on 09.01.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "eva.db";
    public static final String SQL_CREATE_TABLE_STUDENT =
            "CREATE TABLE " + DatabaseSchema.dbStudent.TABLE_NAME + " (" +
                    DatabaseSchema.dbStudent._ID + "INTEGER PRIMARY KEY," +
                    DatabaseSchema.dbStudent.COLUMN_NAME_EMAIL + " TEXT," +
                    DatabaseSchema.dbStudent.COLUMN_NAME_VORNAME + "TEXT," +
                    DatabaseSchema.dbStudent.COLUMN_NAME_NACHNAME + "TEXT," +
                    DatabaseSchema.dbStudent.COLUMN_NAME_PASSWORD + " TEXT" +
                    ");";

    public static final String SQL_CREATE_TABLE_RATING =
            "CREATE TABLE " + DatabaseSchema.Rating.TABLE_NAME + " (" +
                    DatabaseSchema.Rating._ID + " INTEGER PRIMARY KEY," +
                    DatabaseSchema.Rating.COLUMN_NAME_MOTIVATION + " INTEGER," +
                    DatabaseSchema.Rating.COLUMN_NAME_TEAMFAEHIGKEIT + " INTEGER," +
                    DatabaseSchema.Rating.COLUMN_NAME_KOMMUNIKATION + " INTEGER," +
                    DatabaseSchema.Rating.COLUMN_NAME_KNOWHOW + " INTEGER," +
                    DatabaseSchema.Rating.COLUMN_STUDENTB_FK + " INTEGER," +
                    DatabaseSchema.Rating.COLUMN_STUDENT_FK + " INTEGER," +
                    "FOREIGN KEY(" + DatabaseSchema.Rating.COLUMN_STUDENT_FK + ") REFERENCES " + DatabaseSchema.dbStudent.TABLE_NAME + "(" + DatabaseSchema.dbStudent._ID + "), " +
                    "FOREIGN KEY(" + DatabaseSchema.Rating.COLUMN_STUDENT_FK + ") REFERENCES " + DatabaseSchema.dbStudent.TABLE_NAME + "(" + DatabaseSchema.dbStudent._ID + ")" +
                    ");";

    public static final String SQL_DROP_TABLE_RATING = "DROP TABLE IF EXISTS " + DatabaseSchema.Rating.TABLE_NAME + ";";
    public static final String SQL_DROP_TABLE_STUDENT = "DROP TABLE IF EXISTS " + DatabaseSchema.dbStudent.TABLE_NAME + ";";

    public static DatabaseHelper instance = null;
    public Context ctx;

    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 9);
        this.ctx = context;
    }

    public static DatabaseHelper getInstance(Context ctx) {
        if (instance == null) {
            return new DatabaseHelper(ctx.getApplicationContext());
        }
        return instance;
    }
    /**
     * Called when database gets created for first time and used to create tables
     *
     * @param db the database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_STUDENT);
        db.execSQL(SQL_CREATE_TABLE_RATING);
/*
        ContentValues values = new ContentValues();
        values.put(dbStudent.COLUMN_NAME_EMAIL, "lu@hs.de");
        values.put(dbStudent.COLUMN_NAME_VORNAME, "Lukas");
        values.put(dbStudent.COLUMN_NAME_NACHNAME, "Frank");
        values.put(dbStudent.COLUMN_NAME_PASSWORD, "password");
        db.insert(dbStudent.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(dbStudent.COLUMN_NAME_EMAIL, "st@hs.de");
        values.put(dbStudent.COLUMN_NAME_VORNAME, "Stephan");
        values.put(dbStudent.COLUMN_NAME_NACHNAME, "Koch");
        values.put(dbStudent.COLUMN_NAME_PASSWORD, "password");
        db.insert(dbStudent.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(dbStudent.COLUMN_NAME_EMAIL, "no@hs.de");
        values.put(dbStudent.COLUMN_NAME_VORNAME, "Norman");
        values.put(dbStudent.COLUMN_NAME_NACHNAME, "Beyerle");
        values.put(dbStudent.COLUMN_NAME_PASSWORD, "password");
        db.insert(dbStudent.TABLE_NAME, null, values);
*/

        String ROW2 = "INSERT INTO " + DatabaseSchema.dbStudent.TABLE_NAME + " Values (1 , 'frlu1012@hs-karlsruhe.de', 'Lukas', 'Frank', 'password');";
        String ROW3 = "INSERT INTO " + DatabaseSchema.dbStudent.TABLE_NAME + " Values (2 , 'kost1012@hs-karlsruhe.de', 'Stephan', 'Koch', 'password');";
        String ROW4 = "INSERT INTO " + DatabaseSchema.dbStudent.TABLE_NAME + " Values (3 , 'beno1012@hs-karlsruhe.de', 'Norman', 'Beyerle','password');";
        String ROW5 = "INSERT INTO " + DatabaseSchema.Rating.TABLE_NAME + " (" + DatabaseSchema.Rating._ID + ", " + DatabaseSchema.Rating.COLUMN_NAME_MOTIVATION + ", " + DatabaseSchema.Rating.COLUMN_NAME_TEAMFAEHIGKEIT + ", " + DatabaseSchema.Rating.COLUMN_NAME_KOMMUNIKATION + ", " + DatabaseSchema.Rating.COLUMN_NAME_KNOWHOW + ", " + DatabaseSchema.Rating.COLUMN_STUDENTB_FK + ", " + DatabaseSchema.Rating.COLUMN_STUDENT_FK + ")" +
                " Values " +
                "(1, 3, 3, 3, 3, 1, 1)," +
                "(2, 3, 3, 3, 3, 1, 2)," +
                "(3, 3, 3, 3, 3, 1, 3)";

        db.execSQL(ROW2);
        db.execSQL(ROW3);
        db.execSQL(ROW4);
        db.execSQL(ROW5);
        this.db = db;

    }

    public String searchPass(String email)
    {
        db = this.getReadableDatabase();
        String query = "select password from " + DatabaseSchema.dbStudent.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);


                if(a.equals(email)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE_RATING);
        db.execSQL(SQL_DROP_TABLE_STUDENT);
        onCreate(db);
    }
}

