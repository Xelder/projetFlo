package kurzen.editeurdetexte.dao;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.models.Tags;

/**
 * Classe permettant de faire la liaison avec les donnees de la table Tags en bdd
 */
public class TagsDAO {

    /**
     * Object representation la connexion avec la base de donnees, declenche une RunTimeException en cas de probleme
     */
    private RuntimeExceptionDao<Tags, Long> dao;

    /**
     * Constructeur recuperant la connexion à la base de donnees
     * @param helper base de donnees
     */
    public TagsDAO(DatabaseHelper helper)
    {
        dao = helper.getRuntimeTagsDao();
    }

    /**
     * Retourne un Tags ayant l'id passe en parametre
     * @param id identifiant du Tags recherche en base de donnees
     * @return Tags ayant l'identifiant passe en parametre
     */
    public Tags getById(long id)
    {
        return dao.queryForId(id);
    }

    /**
     * Methode retournant tout les Tags de la base de donnes
     * @return List<Tags> avec tout les Tags stockes en base de donnees
     */
    public List<Tags> getAll()
    {
        return dao.queryForAll();
    }

    /**
     * Permet d'inserer un Tags en base de donnees
     * @param tags Objet Tags à inserer
     */
    public void insert(Tags tags)
    {
        dao.create(tags);
    }

    /**
     * Permet de mettre à jours un Tags en base de donnees
     * @param tags Objet Tags avec ses nouvelles valeurs
     */
    public void update(Tags tags)
    {
        dao.update(tags);
    }

    /**
     * Supprime un Tags passe en parametre de la base de donnees
     * @param tags Tags à supprimer
     */
    public void deleteByTags(Tags tags)
    {
        dao.delete(tags);
    }

    /**
     * Supprime le Tags en base de donnees avec l'identifiant passe en parametre
     * @param id identifiant du Tags à supprimer
     */
    public void deleteById(long id)
    {
        dao.deleteById(id);
    }
}