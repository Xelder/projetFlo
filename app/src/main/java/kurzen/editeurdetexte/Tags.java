package editeurdetexte.otageek.reader;

public class Tags {

    /**Variables pour l'algo de conversion en tags **/

        /** utilisées pour sortir les valeurs du tableau et les manipuler plus facilement **/

    float joyVal,angVal,feaVal,sadVal;

        /** utilisées pour le calcul **/

    String mainEmotion;
    float valueMainEmotion, valueConfidence, valueExcitement;


    /**Tags Joie **/

    String joie[] = {"reverant","conscencious","pensive","peaceful","longuing","aroused","calm","pleased","lightHearted","relaxed","glad","enthusiastic","adventurous","happy","satisfied","serene","excited","amorous","joyous"};

    int reverant[] = {20,00};
    int conscensious[] = {20,20};
    int pensive[] = {30,25};
    int peaceful[] = {40,5};
    int longing[] = {40,30};
    int aroused[] = {40,85};
    int calm[] = {50,10};
    int pleased[] = {50,50};
    int lightHearted[] = {50,60};
    int relaxed[] = {60,10};
    int glad[] = {60,45};
    int enthusiastic[] = {60,70};
    int adventurous[] = {60,90};
    int happy[] = {70,55};
    int serene[] = {80,20};
    int satisfied[] = {80,25};
    int excited[] = {80,70};
    int amorous[] = {90,35};
    int joyous[] = {90,60};
    int exctasy[] = {100,75};

    /** Tags Colère **/

    String colère[] = {"defiant","dissatisfied","indignant","bitter","contemptful","Annoyed","angry","frustrated","bellicose","hostile","disgusted","loathing","hateful","enraged"};

    int defiant[] = {10,40};
    int dissatisfied[] = {20,15};
    int indignant[] = {20,50};
    int bitter[] = {30,30};
    int contemptful[] = {30,35};
    int annoyed[] = {50,15};
    int angry[] = {50,50};
    int frustrated[] = {60,35};
    int bellicose[] = {60,95};
    int hostile[] = {80,70};
    int disgusted[] = {90,25};
    int loathing[] = {90,40};
    int hateful[] = {90,50};
    int enraged[] = {100,90};

    /** Tags tristesse **/

    String tristesse[] = {"apathetic","guilt","melancholic","disapointed","droopy","gloomy","sad","miserable","distress","dejected","despair"};

    int apathetic[] = {20,10};
    int guilt[] = {20,30};
    int melancholic[] = {30,25};
    int disapointed[] = {30,50};
    int droopy[] = {40,10};
    int gloomy[] = {50,30};
    int sad[] = {50,50};
    int miserable[] = {70,35};
    int distress[] = {70,90};
    int dejected[] = {90,50};
    int despair[] = {100,70};

    /** Tags peur **/

    String peur[] = {"unconfortable","startled","unneasy","worry","fear","anxious","tense","afraid","terror"};

    int unconfortable[] = {30,15};
    int startled[] = {30,80};
    int unneasy[] = {40,25};
    int worry[] = {50,35};
    int fear[] = {50,50};
    int anxious[] = {50,65};
    int tense[] = {60,95};
    int alarmed[] = {70,65};
    int afraid[] = {80,90};
    int terror[] = {100,95};

    /** Tags confidence **/

    String confidence[] = {"atLoss","distrustful","confused","suspicious","takenAback","hesitant","descriptive","assured","confident","contemplative","convinced","conceited"};

    int atLoss[] = {10,5};
    int distrustful[] = {20,25};
    int confused[] = {20,85};
    int suspicious[] = {30,30};
    int takenAback[] = {30,70};
    int hesitant[] = {40,40};
    int descriptive[] = {50,50};
    int assured[] = {70,35};
    int confident[] = {70,60};
    int contemplative[] = {80,20};
    int convinced[] = {90,80};
    int conceited[] = {100,90};


    public Tags(){}

    public Tags(float[] TextValue) {

        /** récupération des données du tableau **/

        joyVal = TextValue[0];
        angVal = TextValue[1];
        feaVal = TextValue[2];
        sadVal = TextValue[3];
        valueConfidence = TextValue[4];
        valueExcitement = TextValue[5];

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

            for (int i = 0; i < joie.length; i++ ){



            }
        }

        if (mainEmotion == "colère") {

            for (int i = 0; i < colère.length; i++ ){



            }
        }

        if (mainEmotion == "peur") {

            for (int i = 0; i < peur.length; i++ ){



            }
        }

        if (mainEmotion == "tristesse") {

            for (int i = 0; i < tristesse.length; i++ ){



            }
        }



    }

}
