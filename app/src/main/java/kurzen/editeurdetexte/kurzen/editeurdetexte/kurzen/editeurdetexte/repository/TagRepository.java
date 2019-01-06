package kurzen.editeurdetexte.kurzen.editeurdetexte.kurzen.editeurdetexte.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import kurzen.editeurdetexte.Tag;
import kurzen.editeurdetexte.kurzen.editeurdetexte.config.BDD;

public class TagRepository {

    private BDD bdd = new BDD();
    Dao<Tag, String> tagDao = null;

    public TagRepository() {

        try {
            tagDao = DaoManager.createDao(BDD.getConnectionSource(), Tag.class);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void insert(Tag tag){

            try {
                tagDao.create(tag);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
    }
}
