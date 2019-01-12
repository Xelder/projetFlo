package kurzen.editeurdetexte.services;

import java.util.List;

import kurzen.editeurdetexte.models.Mot;
import kurzen.editeurdetexte.models.Tag;
import kurzen.editeurdetexte.models.Tags;

public class TagsService {

    private List<Tag> joie;
    private List<Tag> colere;
    private List<Tag> confidence;
    private List<Tag> tristesse;
    private List<Tag> peur;

    public TagsService(List<Tag> joie, List<Tag> colere, List<Tag> confidence, List<Tag> tristesse, List<Tag> peur) {
        this.joie = joie;
        this.colere = colere;
        this.confidence = confidence;
        this.tristesse = tristesse;
        this.peur = peur;
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
