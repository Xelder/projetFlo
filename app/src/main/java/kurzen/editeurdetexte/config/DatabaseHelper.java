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
import kurzen.editeurdetexte.models.Musique;
import kurzen.editeurdetexte.models.Tag;
import kurzen.editeurdetexte.models.Tags;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "ScenariOST.db";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // Tag DAO
    private Dao<Tag, Long> tagDao = null;
    private RuntimeExceptionDao<Tag, Long> tagRuntimeDao = null;

    // Mots DAO
    private Dao<Mot, Long> motDao = null;
    private RuntimeExceptionDao<Mot, Long> motRuntimeDao = null;

    // tags DAO
    private Dao<Tags, Long> tagsDao = null;
    private RuntimeExceptionDao<Tags, Long> tagsRuntimeDao = null;

    // musique DAO
    private Dao<Musique, Long> musiqueDao = null;
    private RuntimeExceptionDao<Musique, Long> musiqueRuntimeDao = null;

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
            TableUtils.createTable(connectionSource, Musique.class);
            TableUtils.createTable(connectionSource, Tags.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

        Tags tags = new Tags(this, "confidence");
        this.getRuntimeTagsDao().create(tags);
        confidence(tags);

        tags = new Tags(this, "joie");
        this.getRuntimeTagsDao().create(tags);
        joie(tags);

        tags = new Tags(this, "peur");
        this.getRuntimeTagsDao().create(tags);
        peur(tags);

        tags = new Tags(this, "tristesse");
        this.getRuntimeTagsDao().create(tags);
        tristesse(tags);

        tags = new Tags(this, "colere");
        this.getRuntimeTagsDao().create(tags);
        colere(tags);

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

    @Override
    public void close() {
        super.close();
        tagDao = null;
        tagRuntimeDao = null;
        motDao = null;
        motRuntimeDao = null;
        tagsDao = null;
        tagsRuntimeDao = null;
        musiqueDao = null;
        musiqueRuntimeDao = null;
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
     * @Return Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our Tags class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Tags, Long> getRuntimeTagsDao() {
        if (tagsRuntimeDao == null) {
            tagsRuntimeDao = getRuntimeExceptionDao(Tags.class);
        }
        return tagsRuntimeDao;
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
     * @Return Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our Mot class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Musique, Long> getRuntimeMusiqueDao() {
        if (musiqueRuntimeDao == null) {
            musiqueRuntimeDao = getRuntimeExceptionDao(Musique.class);
        }
        return musiqueRuntimeDao;
    }


    private void confidence(Tags tags)
    {
        Tag atLoss = new Tag ("atLoss",10,5, tags);
        Tag distrustful = new Tag ("distrustful",20,25,  tags);
        Tag confused = new Tag ("confused",20,85,  tags);
        Tag suspicious = new Tag ("suspicious",30,30, tags);
        Tag takenAback = new Tag ("takenAback",30,70,  tags);
        Tag hesitant = new Tag ("hesitant",40,40, tags);
        Tag descriptive = new Tag ("descriptive",50,50,  tags);
        Tag assured = new Tag ("assured",70,35,  tags);
        Tag confident = new Tag ("confident",70,60,  tags);
        Tag contemplative = new Tag ("contemplative",80,20, tags);
        Tag convinced = new Tag ("convinced",90,80,  tags);
        Tag conceited = new Tag ("conceited",100,90,  tags);

        this.getRuntimeTagDao().create(atLoss);
        this.getRuntimeTagDao().create(distrustful);
        this.getRuntimeTagDao().create(confused);
        this.getRuntimeTagDao().create(suspicious);
        this.getRuntimeTagDao().create(takenAback);
        this.getRuntimeTagDao().create(hesitant);
        this.getRuntimeTagDao().create(descriptive);
        this.getRuntimeTagDao().create(assured);
        this.getRuntimeTagDao().create(confident);
        this.getRuntimeTagDao().create(contemplative);
        this.getRuntimeTagDao().create(convinced);
        this.getRuntimeTagDao().create(conceited);

    }

    /**
     * initiliation de la liste joie
     */
    private void joie(Tags tags)
    {
        Tag reverant = new Tag("reverant",20,00,  tags);
        Tag conscensious =  new Tag("conscensious",20,20, tags);
        Tag pensive = new Tag("pensive",30,25,  tags);
        Tag peaceful = new Tag("peaceful",40,05,  tags);
        Tag longing = new Tag ("longing",40,30,  tags);
        Tag aroused = new Tag ("aroused",40,85,  tags);
        Tag calm = new Tag ("calm",50,10,  tags);
        Tag pleased = new Tag ("pleased",50,50,  tags);
        Tag lightHearted = new Tag ("lightHearted",50,60,  tags);
        Tag relaxed = new Tag ("relaxed", 60,10,  tags);
        Tag glad = new Tag ("glad",60,45,  tags);
        Tag enthusiastic = new Tag ("enthusiastic", 60,70,  tags);
        Tag adventurous = new Tag ("adventurous",60,90,  tags);
        Tag happy = new Tag ("happy",70,55,  tags);
        Tag serene = new Tag ("serene",80,20,  tags);
        Tag satisfied = new Tag ("satisfied",80,25, tags);
        Tag excited = new Tag ("excited",80,70,  tags);
        Tag amorous = new Tag ("amorous",90,35, tags);
        Tag joyous = new Tag ("joyous",90,60,  tags);
        Tag exctasy = new Tag ("exctasy",100,75,  tags);

        this.getRuntimeTagDao().create(reverant);
        this.getRuntimeTagDao().create(conscensious);
        this.getRuntimeTagDao().create(pensive);
        this.getRuntimeTagDao().create(peaceful);
        this.getRuntimeTagDao().create(longing);
        this.getRuntimeTagDao().create(aroused);
        this.getRuntimeTagDao().create(calm);
        this.getRuntimeTagDao().create(pleased);
        this.getRuntimeTagDao().create(lightHearted);
        this.getRuntimeTagDao().create(relaxed);
        this.getRuntimeTagDao().create(glad);
        this.getRuntimeTagDao().create(enthusiastic);
        this.getRuntimeTagDao().create(adventurous);
        this.getRuntimeTagDao().create(happy);
        this.getRuntimeTagDao().create(serene);
        this.getRuntimeTagDao().create(satisfied);
        this.getRuntimeTagDao().create(excited);
        this.getRuntimeTagDao().create(amorous);
        this.getRuntimeTagDao().create(joyous);
        this.getRuntimeTagDao().create(exctasy);

    }

    /**
     * initiliation de la liste colere
     */
    private void colere(Tags tags)
    {
        Tag defiant = new Tag ("defiant",10,40, tags);
        Tag dissatisfied = new Tag ("dissatisfied",20,15, tags);
        Tag indignant = new Tag ("indignat",20,50, tags);
        Tag bitter = new Tag ("bitter",30,30, tags);
        Tag contemptful = new Tag ("contemptful",30,35, tags);
        Tag annoyed = new Tag ("annoyed",50,15, tags);
        Tag angry = new Tag ("angry",50,50, tags);
        Tag frustrated = new Tag ("frustrated",60,35, tags);
        Tag bellicose = new Tag ("bellicose",60,95, tags);
        Tag hostile = new Tag ("hostile",80,70, tags);
        Tag disgusted = new Tag ("disgusted",90,25, tags);
        Tag loathing = new Tag ("loathing",90,40, tags);
        Tag hateful = new Tag ("hateful",90,50, tags);
        Tag enraged = new Tag ("enraged",100,90, tags);

        this.getRuntimeTagDao().create(defiant);
        this.getRuntimeTagDao().create(dissatisfied);
        this.getRuntimeTagDao().create(indignant);
        this.getRuntimeTagDao().create(bitter);
        this.getRuntimeTagDao().create(contemptful);
        this.getRuntimeTagDao().create(annoyed);
        this.getRuntimeTagDao().create(angry);
        this.getRuntimeTagDao().create(frustrated);
        this.getRuntimeTagDao().create(bellicose);
        this.getRuntimeTagDao().create(hostile);
        this.getRuntimeTagDao().create(disgusted);
        this.getRuntimeTagDao().create(loathing);
        this.getRuntimeTagDao().create(hateful);
        this.getRuntimeTagDao().create(enraged);

    }

    /**
     * initiliation de la liste tristesse
     */
    private void tristesse(Tags tags)
    {
        Tag apathetic = new Tag ("apathetic",20,10, tags);
        Tag guilt = new Tag ("guilt",20,30, tags);
        Tag melancholic = new Tag ("melancholic",30,25, tags);
        Tag disapointed = new Tag ("disapointed",30,50, tags);
        Tag droopy = new Tag ("droopy",40,10, tags);
        Tag gloomy = new Tag ("gloomy",50,30, tags);
        Tag sad = new Tag ("sad",50,50, tags);
        Tag miserable = new Tag ("miserable",70,35, tags);
        Tag distress = new Tag ("distress",70,90, tags);
        Tag dejected = new Tag ("dejected",90,50, tags);
        Tag despair = new Tag ("despair",100,70, tags);

        this.getRuntimeTagDao().create(apathetic);
        this.getRuntimeTagDao().create(guilt);
        this.getRuntimeTagDao().create(melancholic);
        this.getRuntimeTagDao().create(disapointed);
        this.getRuntimeTagDao().create(droopy);
        this.getRuntimeTagDao().create(gloomy);
        this.getRuntimeTagDao().create(sad);
        this.getRuntimeTagDao().create(miserable);
        this.getRuntimeTagDao().create(distress);
        this.getRuntimeTagDao().create(dejected);
        this.getRuntimeTagDao().create(despair);

    }

    /**
     * initiliation de la liste peur
     */
    private void peur(Tags tags)
    {
        Tag unconfortable = new Tag ("unconfortable",30,15,tags);
        Tag startled = new Tag ("startled",30,80,tags);
        Tag unneasy = new Tag ("unneasy",40,25,tags);
        Tag worry = new Tag ("worry",50,35,tags);
        Tag fear = new Tag ("fear",50,50,tags);
        Tag anxious = new Tag ("anxious",50,65,tags);
        Tag tense = new Tag ("tense",60,95,tags);
        Tag alarmed = new Tag ("alarmed",70,65,tags);
        Tag afraid = new Tag ("afraid",80,90,tags);
        Tag terror = new Tag ("terror",100,95,tags);

        this.getRuntimeTagDao().create(unconfortable);
        this.getRuntimeTagDao().create(startled);
        this.getRuntimeTagDao().create(unneasy);
        this.getRuntimeTagDao().create(worry);
        this.getRuntimeTagDao().create(fear);
        this.getRuntimeTagDao().create(anxious);
        this.getRuntimeTagDao().create(tense);
        this.getRuntimeTagDao().create(alarmed);
        this.getRuntimeTagDao().create(afraid);
        this.getRuntimeTagDao().create(terror);

    }

}
