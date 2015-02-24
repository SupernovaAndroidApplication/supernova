package imac.supernova.database;

import android.database.Cursor;

import java.util.List;

/**
 * Created by Audrey on 24/02/2015.
 */
public interface IRepository<T> {

    public List getAll();
    public T getById(int id);

    public void save(T entity);
    public void update(T entity);
    public void delete(int id);

    public List convertCursorToListObject(Cursor c);
    public T convertCursorToObject(Cursor c);
    public T convertCursorToOneObject(Cursor c);
}
