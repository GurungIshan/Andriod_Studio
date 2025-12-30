package np.edu.kathford.sqllite.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import np.edu.kathford.sqllite.models.Student;

public class DbHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "kathford";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tbl_student";

    private static final String ID = "id";
    private static final String FULL_NAME = "full_name";
    private static final String ADDRESS = "address";
    private static final String MOBILE_NUMBER = "mobile_number";
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FULL_NAME + " TEXT NOT NULL, " +
                    ADDRESS + " TEXT NOT NULL, " +
                    MOBILE_NUMBER + " TEXT NOT NULL)";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
    public long addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues =  new ContentValues();
        contentValues.put(FULL_NAME, student.getFullname());
        contentValues.put(ADDRESS, student.getAddress());
        contentValues.put(MOBILE_NUMBER, student.getMobileNumber());

        return db.insert(TABLE_NAME,null, contentValues);
    }
    public int updateStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues =  new ContentValues();
        contentValues.put(ID, student.getId());
        contentValues.put(FULL_NAME, student.getFullname());
        contentValues.put(ADDRESS, student.getAddress());
        contentValues.put(MOBILE_NUMBER, student.getMobileNumber());

        return db.update(TABLE_NAME, contentValues, "id=?", new String[]{String.valueOf(student.getId())});
    }
    public void getAllStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        Student student = new Student();

        while(cursor.moveToNext()){
           int id = Integer.parseInt(cursor.getColumnName(cursor.getColumnIndexOrThrow(ID)));
           String fullname = cursor.getColumnName(cursor.getColumnIndexOrThrow(FULL_NAME));
           String address = cursor.getColumnName(cursor.getColumnIndexOrThrow(ADDRESS));
           String mobileno = cursor.getColumnName(cursor.getColumnIndexOrThrow(MOBILE_NUMBER));

           student.setId(id);
           student.setAddress(address);
           student.setFullname(fullname);
           student.setMobileNumber(mobileno);

           studentArrayList.add(student);
        }
    }
    public int deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
    }

}
