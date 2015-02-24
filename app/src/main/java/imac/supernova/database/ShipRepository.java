package imac.supernova.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import imac.supernova.datamodel.ship.Ship;

/**
 * Created by Audrey on 24/02/2015.
 */
public class ShipRepository extends Repository {

    /**
     * Constructor
     * @param context
     */
    public ShipRepository(Context context) {
        SQLiteOpenHelper = new ShipOpenHelper(context);
    }

    /**
     * Remove a ship
     * @param id
     */
    public void deleteShip(int id) {
        database.delete(ShipOpenHelper.TABLE_NAME, ShipOpenHelper.KEY_ID + "=?",
                new String[] {
                    String.valueOf(id)
                });
    }

    /**
     * Get a list of all the ships
     * @return
     */
    @Override
    public List getAll() {
        Cursor cursor = database.query(ShipOpenHelper.TABLE_NAME,
                new String[] {
                        ShipOpenHelper.KEY_ID,
                        ShipOpenHelper.KEY_MAXHEALTH,
                        ShipOpenHelper.KEY_MAXMOVE
                }, null, null, null, null, null);

        return convertCursorToListObject(cursor);
    }

    /**
     * Get one ship by its id
     * @param id
     * @return
     */
    @Override
    public Object getById(int id) {
        Cursor cursor = database.query(ShipOpenHelper.TABLE_NAME,
                new String[] {
                        ShipOpenHelper.KEY_ID,
                        ShipOpenHelper.KEY_MAXHEALTH,
                        ShipOpenHelper.KEY_MAXMOVE
                },
                ShipOpenHelper.KEY_ID + "=?",
                new String[] {
                        String.valueOf(id)
                }, null, null, null);

        return convertCursorToOneObject(cursor);
    }

    /**
     * Save a ship in the database
     * @param entity
     */
    @Override
    public void save(Object entity) {
        Ship shipEntity = (Ship) entity;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShipOpenHelper.KEY_MAXHEALTH, shipEntity.getMaxHealth());
        contentValues.put(ShipOpenHelper.KEY_MAXMOVE, shipEntity.getMaxMove());

        database.insert(ShipOpenHelper.TABLE_NAME, null, contentValues);
    }

    /**
     * Update a ship in the database
     * @param entity
     */
    @Override
    public void update(Object entity) {
        Ship shipEntity = (Ship) entity;
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShipOpenHelper.KEY_MAXHEALTH, shipEntity.getMaxHealth());
        contentValues.put(ShipOpenHelper.KEY_MAXMOVE, shipEntity.getMaxMove());

        database.update(ShipOpenHelper.TABLE_NAME, contentValues, ShipOpenHelper.KEY_ID + "=?",
                new String[] {
                        String.valueOf(shipEntity.getId())
                });
    }

    /**
     * Remove a ship from the database
     * @param id
     */
    @Override
    public void delete(int id) {
        database.delete(ShipOpenHelper.TABLE_NAME, ShipOpenHelper.KEY_ID + "=?",
                new String[] {
                        String.valueOf(id)
                });
    }

    /**
     * Convert a cursor into a list of ships
     * @param c
     * @return
     */
    @Override
    public List convertCursorToListObject(Cursor c) {
        List list = new ArrayList();
        // If the list is empty
        if (c.getCount() == 0)
            return list;
        // Begin on the first item
        c.moveToFirst();
        do {
            Ship ship = (Ship) convertCursorToObject(c);
            list.add(ship);
        } while (c.moveToNext());
        // Close cursor
        c.close();
        return list;
    }

    /**
     * Convert a cursor into an object
     * @param c
     * @return
     */
    @Override
    public Object convertCursorToObject(Cursor c) {
        Ship ship = new Ship();
        ship.setId(c.getInt(0));
        ship.setHasWeapon(false);

        return ship;
    }

    /**
     * Convert a cursor into a ship
     * @param c
     * @return
     */
    @Override
    public Object convertCursorToOneObject(Cursor c) {
        c.moveToFirst();
        Ship ship = (Ship) convertCursorToObject(c);
        c.close();
        return ship;
    }
    
}
