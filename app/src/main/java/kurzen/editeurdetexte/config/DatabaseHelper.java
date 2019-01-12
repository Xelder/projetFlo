package kurzen.editeurdetexte.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import kurzen.editeurdetexte.R;
import kurzen.editeurdetexte.models.Mot;
import kurzen.editeurdetexte.models.Tag;
import kurzen.editeurdetexte.models.Tags;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "ScenariOST14.db";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // Tag DAO
    private Dao<Tag, Long> tagDao = null;
    private RuntimeExceptionDao<Tag, Long> tagRuntimeDao = null;

    // Mots DAO
    private Dao<Mot, Long> motDao = null;
    private RuntimeExceptionDao<Mot, Long> motRuntimeDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    /**
     * Method who create database
     * @param database database object
     * @param connectionSource connection link to database
     */
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource)
    {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Mot.class);
            TableUtils.createTable(connectionSource, Tag.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

        Tags tags = new Tags(this);
    }

    /**
     *  Method who upgrade database
     * @param database database object
     * @param connectionSource connection link to database
     * @param oldVersion old version of database
     * @param newVersion new version of database
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion,
                                   int newVersion) {

    }

    /**
     * @Return Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our Tag class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Tag, Long> getRuntimeTagDao() {
        if (tagRuntimeDao == null) {
            tagRuntimeDao = getRuntimeExceptionDao(Tag.class);
        }
        return tagRuntimeDao;
    }

    /**
     * @Return Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our Mot class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Mot, Long> getRuntimeMotDao() {
        if (motRuntimeDao == null) {
            motRuntimeDao = getRuntimeExceptionDao(Mot.class);
        }
        return motRuntimeDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        tagDao = null;
        tagRuntimeDao = null;
        motDao = null;
        motRuntimeDao = null;
    }
}
