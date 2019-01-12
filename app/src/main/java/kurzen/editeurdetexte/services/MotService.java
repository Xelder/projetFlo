package kurzen.editeurdetexte.services;

import java.util.ArrayList;
import java.util.List;

import kurzen.editeurdetexte.models.Mot;

public class MotService {

    public Mot valeurTexte(String text){

        /** Parse text for the current page **/
        String [] words = text.split(" ");
        int nombreMotsTexte = words.length;
        List<Mot> listeMots = new ArrayList<Mot>();

        for (String s : words){
           Mot m = new Mot();
           m.setMot(s);
           listeMots.add(m);
        }

        /** Set start values **/
        int Tjoy = 0;
        int Tanger = 0;
        int Tfear = 0;
        int Tsadness = 0;
        int Tconfidence = 50;
        int Texcitment = 0;

        for(Mot m : listeMots){
            Tjoy = Tjoy + m.getJoy();
            Tanger = Tanger + m.getAnger();
            Tfear = Tfear + m.getFear();
            Tsadness = Tsadness + m.getSadness();
            Tconfidence = Tconfidence + m.getConfidence();
            Texcitment = Texcitment + m.getExcitment();
        }

        /** Normalise values **/
        Tjoy = Tjoy / nombreMotsTexte;
        Tanger = Tanger / nombreMotsTexte;
        Tfear = Tfear / nombreMotsTexte;
        Tsadness = Tsadness / nombreMotsTexte;
        Tconfidence = Tconfidence / nombreMotsTexte;
        Texcitment = Texcitment / nombreMotsTexte;

        /** return values for tag analysis **/

        return new Mot(Tjoy,Tanger,Tfear,Tsadness,Tconfidence,Texcitment);
    }

}
