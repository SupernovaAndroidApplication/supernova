package imac.supernova.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Audrey on 24/02/2015.
 */
public class ShipOpenHelper extends SQLiteOpenHelper {

    // Database version and name
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SupernovaDB";

    // Table "Ships"
    static final String TABLE_NAME = "Ship";
    // Table keys (fields or columns)
    static final String KEY_ID = "id";
    static final String KEY_MAXHEALTH = "maxHealth";
    static final String KEY_MAXMOVE = "maxMove";
    //static final String[] COLUMNS = { KEY_ID, KEY_MAXHEALTH, KEY_MAXMOVE };

    // SQL query for creating database
    private static final String QUERY_DB_CREATION = "CREATE TABLE "
            + TABLE_NAME + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_MAXHEALTH + " INTEGER NOT NULL, "
            + KEY_MAXMOVE + " INTEGER NOT NULL);";

    /**
     * Database handler constructor
     * @param context
     */
    public ShipOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("SQLite DB : Constructeur ", "Constructeur");
    }

    /**
     * Create the database (only called if it doesn't exist)
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_DB_CREATION);
        Log.i("SQLite DB", "Creation");
    }

    /**
     * Update the database
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        this.onCreate(db);
        Log.i("SQLite DB", "Upgrade");
    }

}
