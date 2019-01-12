package kurzen.editeurdetexte.dao;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.models.Tag;

/**
 * Classe permettant de faire la liaison avec les donnees de la table Tag en bdd
 */
public class TagDAO {

    /**
     * Object representation la connexion avec la base de donnees, declenche une RunTimeException en cas de probleme
     */
    private RuntimeExceptionDao<Tag, Long> dao;

    /**
     * Constructeur recuperant la connexion à la base de donnees
     * @param helper base de donnees
     */
    public TagDAO(DatabaseHelper helper)
    {
        dao = helper.getRuntimeTagDao();
    }

    /**
     * Retourne un Tag ayant l'id passe en parametre
     * @param id identifiant du Tag recherche en base de donnees
     * @return Tag ayant l'identifiant passe en parametre
     */
    public Tag getById(long id)
    {
        return dao.queryForId(id);
    }

    /**
     * Methode retournant tout les Tag de la base de donnes
     * @return List<Tag> avec tout les Tags stockes en base de donnees
     */
    public List<Tag> getAll()
    {
        return dao.queryForAll();
    }

    /**
     * Permet d'inserer un Tag en base de donnees
     * @param tag
     */
    public void insert(Tag tag)
    {
        dao.create(tag);
    }

    /**
     * Permet de mettre à jours un Tag en base de donnees
     * @param tag Objet Tag avec ses nouvelles valeurs
     */
    public void update(Tag tag)
    {
        dao.update(tag);
    }

    /**
     * Supprime un Tag passe en parametre de la base de donnees
     * @param tag Tag à supprimer
     */
    public void deleteByTag(Tag tag)
    {
        dao.delete(tag);
    }

    /**
     * Supprime le Tag en base de donnees avec l'identifiant passe en parametre
     * @param id identifiant du Tag à supprimer
     */
    public void deleteById(long id)
    {
        dao.deleteById(id);
    }
}
