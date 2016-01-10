package hska.eva;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import hska.eva.DatabaseSchema.Student;
import hska.eva.DatabaseSchema.Rating;

/** * Created by Luke on 09.01.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "eva.db";
    public static final String SQL_CREATE_TABLE_STUDENT =
            "CREATE TABLE " + Student.TABLE_NAME + " (" +
                    Student._ID + "INTEGER PRIMARY KEY," +
                    Student.COLUMN_NAME_EMAIL + " TEXT," +
                    Student.COLUMN_NAME_PASSWORD + " TEXT" +
                    Student.COLUM_NAME_VORNAME + "TEXT" +
                    Student.COLUM_NAME_NACHNAME + "TEXT" +
                    ");";

    public static final String SQL_CREATE_TABLE_RATING =
            "CREATE TABLE " + Rating.TABLE_NAME + " (" +
                    Rating._ID + " INTEGER PRIMARY KEY," +
                    Rating.COLUMN_NAME_MOTIVATION + " INTEGER," +
                    Rating.COLUMN_NAME_TEAMFAEHIGKEIT + " INTEGER," +
                    Rating.COLUMN_NAME_KOMMUNIKATION + " INTEGER," +
                    Rating.COLUMN_NAME_KNOWHOW + " INTEGER," +
                    Rating.COLUMN_STUDENTB_FK + " INTEGER," +
                    Rating.COLUMN_STUDENT_FK + " INTEGER," +
                    "FOREIGN KEY(" + Rating.COLUMN_STUDENT_FK + ") REFERENCES " + Student.TABLE_NAME + "(" + Student._ID + "), " +
                    "FOREIGN KEY(" + Rating.COLUMN_STUDENT_FK + ") REFERENCES " + Student.TABLE_NAME + "(" + Student._ID + ")" +
                    ");";

    public static final String SQL_DROP_TABLE_RATING = "DROP TABLE IF EXISTS " + Rating.TABLE_NAME + ";";
    public static final String SQL_DROP_TABLE_STUDENT = "DROP TABLE IF EXISTS " + Student.TABLE_NAME + ";";

    public static DatabaseHelper instance = null;
    public Context ctx;

    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
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

        String ROW2 = "INSERT INTO " + Student.TABLE_NAME + " Values (1 , 'frlu1012@hs-karlsruhe.de', 'Lukas', 'Frank', 'password');";
        String ROW3 = "INSERT INTO " + Student.TABLE_NAME + " Values (2 , 'kost1012@hs-karlsruhe.de', 'Stephan', 'Koch', 'password');";
        String ROW4 = "INSERT INTO " + Student.TABLE_NAME + " Values (3 , 'beno1012@hs-karlsruhe.de', 'Norman', 'Beyerle','password');";
        String ROW5 = "INSERT INTO " + Rating.TABLE_NAME + " (" + Rating._ID + ", " + Rating.COLUMN_NAME_MOTIVATION + ", " + Rating.COLUMN_NAME_TEAMFAEHIGKEIT + ", " + Rating.COLUMN_NAME_KOMMUNIKATION + ", " + Rating.COLUMN_NAME_KNOWHOW + ", " + Rating.COLUMN_STUDENTB_FK + ", " + Rating.COLUMN_STUDENT_FK + ")" +
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
        String query = "select * from " + Student.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(1);


                if(a.equals(email)){
                    b = cursor.getString(2);
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

