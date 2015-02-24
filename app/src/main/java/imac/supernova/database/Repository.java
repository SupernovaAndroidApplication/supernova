package imac.supernova.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Audrey on 24/02/2015.
 */
public abstract class Repository implements IRepository {
    // Database
    protected SQLiteDatabase database;
    // SQLite helper
    protected SQLiteOpenHelper SQLiteOpenHelper;

    /**
     * Default constructor
     */
    public Repository() {}

    /**
     * Open the connexion to the database
     */
    public void openConnexion() {
        database = SQLiteOpenHelper.getWritableDatabase();
    }

    /**
     * Close the connexion to the database
     */
    public void closeConnexion() {
        database.close();
    }

}
