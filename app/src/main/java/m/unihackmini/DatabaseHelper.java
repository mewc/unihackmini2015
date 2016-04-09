package m.unihackmini;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by David on 9/04/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    // database properties
    public static final String DATABASE_NAME = "App.db";
    public static final int DATABASE_VERSION = 1;

    // constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Review.CREATE_STATEMENT);
        

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
