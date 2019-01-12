package kurzen.editeurdetexte.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.dao.TagDAO;
import kurzen.editeurdetexte.models.Tag;

public class Tags {

    /**
     * dao de la class Tag
     */
    private TagDAO tagDAO;

    public Tags(DatabaseHelper helper){
        tagDAO = new TagDAO(helper);

        confidence();
        peur();
        tristesse();
        colere();
        joie();
    }

    private void confidence()
    {
        Tag atLoss = new Tag ("atLoss",10,5, "confidence");
        Tag distrustful = new Tag ("distrustful",20,25, "confidence");
        Tag confused = new Tag ("confused",20,85, "confidence");
        Tag suspicious = new Tag ("suspicious",30,30, "confidence");
        Tag takenAback = new Tag ("takenAback",30,70, "confidence");
        Tag hesitant = new Tag ("hesitant",40,40, "confidence");
        Tag descriptive = new Tag ("descriptive",50,50, "confidence");
        Tag assured = new Tag ("assured",70,35, "confidence");
        Tag confident = new Tag ("confident",70,60, "confidence");
        Tag contemplative = new Tag ("contemplative",80,20, "confidence");
        Tag convinced = new Tag ("convinced",90,80, "confidence");
        Tag conceited = new Tag ("conceited",100,90, "confidence");

        tagDAO.insert(atLoss);
        tagDAO.insert(distrustful);
        tagDAO.insert(confused);
        tagDAO.insert(suspicious);
        tagDAO.insert(takenAback);
        tagDAO.insert(hesitant);
        tagDAO.insert(descriptive);
        tagDAO.insert(assured);
        tagDAO.insert(confident);
        tagDAO.insert(contemplative);
        tagDAO.insert(convinced);
        tagDAO.insert(conceited);

    }

    /**
     * initiliation de la liste peur
     */
    private void peur()
    {
        Tag unconfortable = new Tag ("unconfortable",30,15, "peur");
        Tag startled = new Tag ("startled",30,80, "peur");
        Tag unneasy = new Tag ("unneasy",40,25, "peur");
        Tag worry = new Tag ("worry",50,35, "peur");
        Tag fear = new Tag ("fear",50,50, "peur");
        Tag anxious = new Tag ("anxious",50,65, "peur");
        Tag tense = new Tag ("tense",60,95, "peur");
        Tag alarmed = new Tag ("alarmed",70,65, "peur");
        Tag afraid = new Tag ("afraid",80,90, "peur");
        Tag terror = new Tag ("terror",100,95, "peur");

        tagDAO.insert(unconfortable);
        tagDAO.insert(startled);
        tagDAO.insert(unneasy);
        tagDAO.insert(worry);
        tagDAO.insert(fear);
        tagDAO.insert(anxious);
        tagDAO.insert(tense);
        tagDAO.insert(alarmed);
        tagDAO.insert(afraid);
        tagDAO.insert(terror);

    }

    /**
     * initiliation de la liste tristesse
     */
    private void tristesse()
    {
        Tag apathetic = new Tag ("apathetic",20,10, "tristesse");
        Tag guilt = new Tag ("guilt",20,30, "tristesse");
        Tag melancholic = new Tag ("melancholic",30,25, "tristesse");
        Tag disapointed = new Tag ("disapointed",30,50, "tristesse");
        Tag droopy = new Tag ("droopy",40,10, "tristesse");
        Tag gloomy = new Tag ("gloomy",50,30, "tristesse");
        Tag sad = new Tag ("sad",50,50, "tristesse");
        Tag miserable = new Tag ("miserable",70,35, "tristesse");
        Tag distress = new Tag ("distress",70,90, "tristesse");
        Tag dejected = new Tag ("dejected",90,50, "tristesse");
        Tag despair = new Tag ("despair",100,70, "tristesse");

        tagDAO.insert(apathetic);
        tagDAO.insert(guilt);
        tagDAO.insert(melancholic);
        tagDAO.insert(disapointed);
        tagDAO.insert(droopy);
        tagDAO.insert(gloomy);
        tagDAO.insert(sad);
        tagDAO.insert(miserable);
        tagDAO.insert(distress);
        tagDAO.insert(dejected);
        tagDAO.insert(despair);

    }

    /**
     * initiliation de la liste colere
     */
    private void colere()
    {
        Tag defiant = new Tag ("defiant",10,40, "colere");
        Tag dissatisfied = new Tag ("dissatisfied",20,15, "colere");
        Tag indignant = new Tag ("indignat",20,50, "colere");
        Tag bitter = new Tag ("bitter",30,30, "colere");
        Tag contemptful = new Tag ("contemptful",30,35, "colere");
        Tag annoyed = new Tag ("annoyed",50,15, "colere");
        Tag angry = new Tag ("angry",50,50, "colere");
        Tag frustrated = new Tag ("frustrated",60,35, "colere");
        Tag bellicose = new Tag ("bellicose",60,95, "colere");
        Tag hostile = new Tag ("hostile",80,70, "colere");
        Tag disgusted = new Tag ("disgusted",90,25, "colere");
        Tag loathing = new Tag ("loathing",90,40, "colere");
        Tag hateful = new Tag ("hateful",90,50, "colere");
        Tag enraged = new Tag ("enraged",100,90, "colere");

        tagDAO.insert(defiant);
        tagDAO.insert(dissatisfied);
        tagDAO.insert(indignant);
        tagDAO.insert(bitter);
        tagDAO.insert(contemptful);
        tagDAO.insert(annoyed);
        tagDAO.insert(angry);
        tagDAO.insert(frustrated);
        tagDAO.insert(bellicose);
        tagDAO.insert(hostile);
        tagDAO.insert(disgusted);
        tagDAO.insert(loathing);
        tagDAO.insert(hateful);
        tagDAO.insert(enraged);

    }

    /**
     * initiliation de la liste joie
     */
    private void joie()
    {
        Tag reverant = new Tag("reverant",20,00, "joie");
        Tag conscensious =  new Tag("conscensious",20,20, "joie");
        Tag pensive = new Tag("pensive",30,25, "joie");
        Tag peaceful = new Tag("peaceful",40,05, "joie");
        Tag longing = new Tag ("longing",40,30, "joie");
        Tag aroused = new Tag ("aroused",40,85, "joie");
        Tag calm = new Tag ("calm",50,10, "joie");
        Tag pleased = new Tag ("pleased",50,50, "joie");
        Tag lightHearted = new Tag ("lightHearted",50,60, "joie");
        Tag relaxed = new Tag ("relaxed", 60,10, "joie");
        Tag glad = new Tag ("glad",60,45, "joie");
        Tag enthusiastic = new Tag ("enthusiastic", 60,70, "joie");
        Tag adventurous = new Tag ("adventurous",60,90, "joie");
        Tag happy = new Tag ("happy",70,55, "joie");
        Tag serene = new Tag ("serene",80,20, "joie");
        Tag satisfied = new Tag ("satisfied",80,25, "joie");
        Tag excited = new Tag ("excited",80,70, "joie");
        Tag amorous = new Tag ("amorous",90,35, "joie");
        Tag joyous = new Tag ("joyous",90,60, "joie");
        Tag exctasy = new Tag ("exctasy",100,75, "joie");

        tagDAO.insert(reverant);
        tagDAO.insert(conscensious);
        tagDAO.insert(pensive);
        tagDAO.insert(peaceful);
        tagDAO.insert(longing);
        tagDAO.insert(aroused);
        tagDAO.insert(calm);
        tagDAO.insert(pleased);
        tagDAO.insert(lightHearted);
        tagDAO.insert(relaxed);
        tagDAO.insert(glad);
        tagDAO.insert(enthusiastic);
        tagDAO.insert(adventurous);
        tagDAO.insert(happy);
        tagDAO.insert(serene);
        tagDAO.insert(satisfied);
        tagDAO.insert(excited);
        tagDAO.insert(amorous);
        tagDAO.insert(joyous);
        tagDAO.insert(exctasy);

    }

}
