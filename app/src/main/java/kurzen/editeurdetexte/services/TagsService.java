package kurzen.editeurdetexte.services;

import kurzen.editeurdetexte.models.Mot;
import kurzen.editeurdetexte.models.Tag;
import kurzen.editeurdetexte.models.Tags;

public class TagsService {

    private Tags tags = new Tags();

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

            for (int i = 0; i < tags.getJoie().size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

        if (mainEmotion == "colère") {

            for (int i = 0; i < tags.getColere().size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

        if (mainEmotion == "peur") {

            for (int i = 0; i < tags.getPeur().size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

        if (mainEmotion == "tristesse") {

            for (int i = 0; i < tags.getTristesse().size(); i++ ){

                /** Calcul de la distance entre le point [i] et le point du Texte actuel **/

            }
        }

        return emotionTexte;

    }
}
