package projet.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.drawable.VectorDrawable;

import java.util.Vector;

/**
 * Created by alex on 09/04/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AndroidSport.db";
    private static final String TABLE_COURSE = "Course";


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DIST = "distance";
    public static final String COLUMN_TEMPS = "temps";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_LATITUDE = "latitude";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_COURSE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_DIST
                + " INTEGER," + COLUMN_TEMPS + " TIME," + COLUMN_LOCATION + " TEXT,"
                + COLUMN_LONGITUDE + " INTEGER," + COLUMN_LATITUDE + " INTEGER)";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    public void addCourse(Course course)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DIST, course.getdist());
        values.put(COLUMN_TEMPS, course.getTime());
        values.put(COLUMN_LOCATION, course.getLocation());
        values.put(COLUMN_LONGITUDE, course.getLongitude());
        values.put(COLUMN_LATITUDE, course.getLatitude());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_COURSE, null, values);
        db.close();
    }

    public Course findCourse(int id) {
        String query = "Select * FROM " + TABLE_COURSE + " WHERE " + COLUMN_ID + " =  \"" + id + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Course course;

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            course=new Course(Integer.parseInt(cursor.getString(0)),
                                Integer.parseInt(cursor.getString(1)),
                                Double.parseDouble(cursor.getString(2)),
                                cursor.getString(3),
                                Integer.parseInt(cursor.getString(4)),
                                Integer.parseInt(cursor.getString(5)));
            cursor.close();
        } else {
            course = null;
        }
        db.close();
        return course;
    }
    public Vector<Course> getCourses()
    {
        Vector<Course> Courses=new Vector<Course>();
        String query="Select * FROM " + TABLE_COURSE;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Course course;
        if(cursor.moveToFirst()) {
            do{
                course=new Course(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        Double.parseDouble(cursor.getString(2)),
                        cursor.getString(3),
                        Integer.parseInt(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(5)));
                Courses.add(course);

            }while(cursor.moveToNext());
        }

        return Courses;
    }
    public boolean deleteCourse(int id) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_COURSE + " WHERE " + COLUMN_ID + " =  \"" + id + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Course course;

        if (cursor.moveToFirst()) {
            db.delete(TABLE_COURSE, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(id) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}
