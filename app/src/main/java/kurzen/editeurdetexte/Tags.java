package kurzen.editeurdetexte;

import java.util.ArrayList;
import java.util.List;

public class Tags {

    /**Variables pour l'algo de conversion en tags **/

    /**Tags Joie **/

    List<Tag> joie = new ArrayList<Tag>();

    Tag reverant = new Tag("reverant",20,00);
    Tag conscensious =  new Tag("conscensious",20,20);
    Tag pensive = new Tag("pensive",30,25);
    Tag peaceful = new Tag("peaceful",40,05);
    Tag longing = new Tag ("longing",40,30);
    Tag aroused = new Tag ("aroused",40,85);
    Tag calm = new Tag ("calm",50,10);
    Tag pleased = new Tag ("pleased",50,50);
    Tag lightHearted = new Tag ("lightHearted",50,60);
    Tag relaxed = new Tag ("relaxed", 60,10);
    Tag glad = new Tag ("glad",60,45);
    Tag enthusiastic = new Tag ("enthusiastic", 60,70);
    Tag adventurous = new Tag ("adventurous",60,90);
    Tag happy = new Tag ("happy",70,55);
    Tag serene = new Tag ("serene",80,20);
    Tag satisfied = new Tag ("satisfied",80,25);
    Tag excited = new Tag ("excited",80,70);
    Tag amorous = new Tag ("amorous",90,35);
    Tag joyous = new Tag ("joyous",90,60);
    Tag exctasy = new Tag ("exctasy",100,75);

    /** Tags Colère **/

    List<Tag> colere = new ArrayList<Tag>();

    Tag defiant = new Tag ("defiant",10,40);
    Tag dissatisfied = new Tag ("dissatisfied",20,15);
    Tag indignant = new Tag ("indignat",20,50);
    Tag bitter = new Tag ("bitter",30,30);
    Tag contemptful = new Tag ("contemptful",30,35);
    Tag annoyed = new Tag ("annoyed",50,15);
    Tag angry = new Tag ("angry",50,50);
    Tag frustrated = new Tag ("frustrated",60,35);
    Tag bellicose = new Tag ("bellicose",60,95);
    Tag hostile = new Tag ("hostile",80,70);
    Tag disgusted = new Tag ("disgusted",90,25);
    Tag loathing = new Tag ("loathing",90,40);
    Tag hateful = new Tag ("hateful",90,50);
    Tag enraged = new Tag ("enraged",100,90);

    /** Tags tristesse **/

    List<Tag> tristesse = new ArrayList<Tag>();

    Tag apathetic = new Tag ("apathetic",20,10);
    Tag guilt = new Tag ("guilt",20,30);
    Tag melancholic = new Tag ("melancholic",30,25);
    Tag disapointed = new Tag ("disapointed",30,50);
    Tag droopy = new Tag ("droopy",40,10);
    Tag gloomy = new Tag ("gloomy",50,30);
    Tag sad = new Tag ("sad",50,50);
    Tag miserable = new Tag ("miserable",70,35);
    Tag distress = new Tag ("distress",70,90);
    Tag dejected = new Tag ("dejected",90,50);
    Tag despair = new Tag ("despair",100,70);

    /** Tags peur **/

    List<Tag> peur = new ArrayList<Tag>();

    Tag unconfortable = new Tag ("unconfortable",30,15);
    Tag startled = new Tag ("startled",30,80);
    Tag unneasy = new Tag ("unneasy",40,25);
    Tag worry = new Tag ("worry",50,35);
    Tag fear = new Tag ("fear",50,50);
    Tag anxious = new Tag ("anxious",50,65);
    Tag tense = new Tag ("tense",60,95);
    Tag alarmed = new Tag ("alarmed",70,65);
    Tag afraid = new Tag ("afraid",80,90);
    Tag terror = new Tag ("terror",100,95);

    /** Tags confidence **/

    List<Tag> confidence = new ArrayList<Tag>();

    Tag atLoss = new Tag ("atLoss",10,5);
    Tag distrustful = new Tag ("distrustful",20,25);
    Tag confused = new Tag ("confused",20,85);
    Tag suspicious = new Tag ("suspicious",30,30);
    Tag takenAback = new Tag ("takenAback",30,70);
    Tag hesitant = new Tag ("hesitant",40,40);
    Tag descriptive = new Tag ("descriptive",50,50);
    Tag assured = new Tag ("assured",70,35);
    Tag confident = new Tag ("confident",70,60);
    Tag contemplative = new Tag ("contemplative",80,20);
    Tag convinced = new Tag ("convinced",90,80);
    Tag conceited = new Tag ("conceited",100,90);


    public Tags(){

        confidence.add(atLoss);
        confidence.add(distrustful);
        confidence.add(confused);
        confidence.add(suspicious);
        confidence.add(takenAback);
        confidence.add(hesitant);
        confidence.add(descriptive);
        confidence.add(assured);
        confidence.add(confident);
        confidence.add(contemplative);
        confidence.add(convinced);
        confidence.add(conceited);

        peur.add(unconfortable);
        peur.add(startled);
        peur.add(unneasy);
        peur.add(worry);
        peur.add(fear);
        peur.add(anxious);
        peur.add(tense);
        peur.add(alarmed);
        peur.add(afraid);
        peur.add(terror);

        tristesse.add(apathetic);
        tristesse.add(guilt);
        tristesse.add(melancholic);
        tristesse.add(disapointed);
        tristesse.add(droopy);
        tristesse.add(gloomy);
        tristesse.add(sad);
        tristesse.add(miserable);
        tristesse.add(distress);
        tristesse.add(dejected);
        tristesse.add(despair);

        colere.add(defiant);
        colere.add(dissatisfied);
        colere.add(indignant);
        colere.add(bitter);
        colere.add(contemptful);
        colere.add(annoyed);
        colere.add(angry);
        colere.add(frustrated);
        colere.add(bellicose);
        colere.add(hostile);
        colere.add(disgusted);
        colere.add(loathing);
        colere.add(hateful);
        colere.add(enraged);

        joie.add(reverant);
        joie.add(conscensious);
        joie.add(pensive);
        joie.add(peaceful);
        joie.add(longing);
        joie.add(aroused);
        joie.add(calm);
        joie.add(pleased);
        joie.add(lightHearted);
        joie.add(relaxed);
        joie.add(glad);
        joie.add(enthusiastic);
        joie.add(adventurous);
        joie.add(happy);
        joie.add(serene);
        joie.add(satisfied);
        joie.add(excited);
        joie.add(amorous);
        joie.add(joyous);
        joie.add(exctasy);

    }

    public Tag rechercheTag(Mot TextValue) {

        /** récupération des données du tableau **/

        int joyVal = TextValue.getJoy();
        int angVal = TextValue.getAnger();
        int feaVal = TextValue.getFear();
        int sadVal = TextValue.getSadness();
        int ValueConfidence = TextValue.getConfidence();
        int valueExcitement = TextValue.getExcitment();

        String mainEmotion;
        int valueMainEmotion;

        Tag emotionTexte = null;

        /** détermination de l'émotion principale **/

        if (joyVal < angVal) {

            mainEmotion = "colère";
            valueMainEmotion = angVal;

            if (angVal < feaVal) {

                mainEmotion = "peur";
                valueMainEmotion = feaVal;

                if (feaVal < sadVal) {

                    mainEmotion = "tristesse";
                    valueMainEmotion = sadVal;

                }

            } else {

                if (angVal < sadVal) {

                    mainEmotion = "tristesse";
                    valueMainEmotion = sadVal;

                }

            }
        } else {

            mainEmotion = "joie";
            valueMainEmotion = joyVal;

            if (joyVal < feaVal) {

                mainEmotion = "peur";
                valueMainEmotion = feaVal;

                if (feaVal < sadVal) {

                    mainEmotion = "tristesse";
                    valueMainEmotion = sadVal;

                }
            } else {

                if (joyVal < sadVal) {

                    mainEmotion = "tristesse";
                    valueMainEmotion = sadVal;

                }

            }
        }

        /** Je sais c'est pas beau mais j'savais pas comment faire autrement XD **/

        /** Calcul des tags **/

        if (mainEmotion == "joie") {

            for (int i = 0; i < joie.size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

        if (mainEmotion == "colère") {

            for (int i = 0; i < colere.size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

        if (mainEmotion == "peur") {

            for (int i = 0; i < peur.size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

        if (mainEmotion == "tristesse") {

            for (int i = 0; i < tristesse.size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

    return emotionTexte;

    }


}
