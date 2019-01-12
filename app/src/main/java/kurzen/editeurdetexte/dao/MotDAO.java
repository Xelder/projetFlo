package kurzen.editeurdetexte.dao;


import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.models.Mot;

/**
 * Classe permettant de faire la liaison avec les donnees de la table Mot en bdd
 */
public class MotDAO {

    /**
     * Object representation la connexion avec la base de donnees, declenche une RunTimeException en cas de probleme
     */
    private RuntimeExceptionDao<Mot, Long> dao;

    /**
     * Constructeur recuperant la connexion à la base de donnees
     * @param helper base de donnees
     */
    public MotDAO(DatabaseHelper helper)
    {
        dao = helper.getRuntimeMotDao();
    }

    /**
     * Retourne un Mot ayant l'id passe en parametre
     * @param id identifiant du Mot recherche en base de donnees
     * @return Mot ayant l'identifiant passe en parametre
     */
    public Mot getById(long id)
    {
        return dao.queryForId(id);
    }

    /**
     * Methode retournant tout les Mot de la base de donnes
     * @return List<Mot> avec tout les Mot stockes en base de donnees
     */
    public List<Mot> getAll()
    {
        return dao.queryForAll();
    }

    /**
     * Permet d'inserer un Mot en base de donnees
     * @param mot Objet Mot à inserer
     */
    public void insert(Mot mot)
    {
        dao.create(mot);
    }

    /**
     * Permet de mettre à jours un Mot en base de donnees
     * @param mot Objet Mot avec ses nouvelles valeurs
     */
    public void update(Mot mot)
    {
        dao.update(mot);
    }

    /**
     * Supprime un Mot passe en parametre de la base de donnees
     * @param mot Mot à supprimer
     */
    public void deleteByMot(Mot mot)
    {
        dao.delete(mot);
    }

    /**
     * Supprime le Mot en base de donnees avec l'identifiant passe en parametre
     * @param id identifiant du Mot à supprimer
     */
    public void deleteById(long id)
    {
        dao.deleteById(id);
    }
}