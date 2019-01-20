package kurzen.editeurdetexte.dao;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.models.Musique;

/**
 * Classe permettant de faire la liaison avec les donnees de la table Musique en bdd
 */
public class MusiqueDAO {

    /**
     * Object representation la connexion avec la base de donnees, declenche une RunTimeException en cas de probleme
     */
    private RuntimeExceptionDao<Musique, Long> dao;

    /**
     * Constructeur recuperant la connexion à la base de donnees
     * @param helper base de donnees
     */
    public MusiqueDAO(DatabaseHelper helper)
    {
        dao = helper.getRuntimeMusiqueDao();
    }

    /**
     * Retourne un Musique ayant l'id passe en parametre
     * @param id identifiant du Musique recherche en base de donnees
     * @return Musique ayant l'identifiant passe en parametre
     */
    public Musique getById(long id)
    {
        return dao.queryForId(id);
    }

    /**
     * Methode retournant tout les Musique de la base de donnes
     * @return List<Musique> avec tout les Musique stockes en base de donnees
     */
    public List<Musique> getAll()
    {
        return dao.queryForAll();
    }

    /**
     * Permet d'inserer un Musique en base de donnees
     * @param musique Objet Musique à inserer
     */
    public void insert(Musique musique)
    {
        dao.create(musique);
    }

    /**
     * Permet de mettre à jours un Musique en base de donnees
     * @param musique Objet Musique avec ses nouvelles valeurs
     */
    public void update(Musique musique)
    {
        dao.update(musique);
    }

    /**
     * Supprime un Musique passe en parametre de la base de donnees
     * @param musique Musique à supprimer
     */
    public void deleteByMusique(Musique musique)
    {
        dao.delete(musique);
    }

    /**
     * Supprime le Musique en base de donnees avec l'identifiant passe en parametre
     * @param id identifiant du Musique à supprimer
     */
    public void deleteById(long id)
    {
        dao.deleteById(id);
    }
}
