package editeurdetexte.otageek.reader;

import java.sql.Array;


public class Mots {


    String mot;

    int joy;
    int anger;
    int fear;
    int sadness;
    int confidence;
    int excitment;

    int Tjoy;
    int Tanger;
    int Tfear;
    int Tsadness;
    int Tconfidence;
    int Texcitment;
    int TnumberWords;

    public Mots(int joy, int anger, int fear, int sadness, int confidence, int excitment, int tjoy, int tanger, int tfear, int tsadness, int tconfidence, int texcitment, int tnumberWords) {
        this.joy = joy;
        this.anger = anger;
        this.fear = fear;
        this.sadness = sadness;
        this.confidence = confidence;
        this.excitment = excitment;
        Tjoy = tjoy;
        Tanger = tanger;
        Tfear = tfear;
        Tsadness = tsadness;
        Tconfidence = tconfidence;
        Texcitment = texcitment;
        TnumberWords = tnumberWords;
    }

    public void setJoy(int joy) {
        this.joy = joy;
    }

    public void setAnger(int anger) {
        this.anger = anger;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    public void setSadness(int sadness) {
        this.sadness = sadness;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public void setExcitment(int excitment) {
        this.excitment = excitment;
    }

    public void setTjoy(int tjoy) {
        Tjoy = tjoy;
    }

    public void setTanger(int tanger) {
        Tanger = tanger;
    }

    public void setTfear(int tfear) {
        Tfear = tfear;
    }

    public void setTsadness(int tsadness) {
        Tsadness = tsadness;
    }

    public void setTconfidence(int tconfidence) {
        Tconfidence = tconfidence;
    }

    public void setTexcitment(int texcitment) {
        Texcitment = texcitment;
    }

    public void setTnumberWords(int tnumberWords) {
        TnumberWords = tnumberWords;
    }

    public int getJoy() {
        return joy;
    }

    public int getAnger() {
        return anger;
    }

    public int getFear() {
        return fear;
    }

    public int getSadness() {
        return sadness;
    }

    public int getConfidence() {
        return confidence;
    }

    public int getExcitment() {
        return excitment;
    }

    public int getTjoy() {
        return Tjoy;
    }

    public int getTanger() {
        return Tanger;
    }

    public int getTfear() {
        return Tfear;
    }

    public int getTsadness() {
        return Tsadness;
    }

    public int getTconfidence() {
        return Tconfidence;
    }

    public int getTexcitment() {
        return Texcitment;
    }

    public int getTnumberWords() {
        return TnumberWords;
    }

    @Override
    public String toString() {
        return "Mots{" +
                "joy=" + joy +
                ", anger=" + anger +
                ", fear=" + fear +
                ", sadness=" + sadness +
                ", confidence=" + confidence +
                ", excitment=" + excitment +
                ", Tjoy=" + Tjoy +
                ", Tanger=" + Tanger +
                ", Tfear=" + Tfear +
                ", Tsadness=" + Tsadness +
                ", Tconfidence=" + Tconfidence +
                ", Texcitment=" + Texcitment +
                ", TnumberWords=" + TnumberWords +
                '}';
    }

    public float[] valeurTexte(String text){

        /** Parse text for the current page **/
        String [] words = text.split(" ");
        int size = words.length;

        /** Set start values **/
        Tjoy = 0;
        Tanger = 0;
        Tfear = 0;
        Tsadness = 0;
        Tconfidence = 50;
        Texcitment = 0;
        TnumberWords = 0;

        for(int i = 0; i < size ; i++ ){
            Tjoy = Tjoy + joy;
            Tanger = Tanger + anger;
            Tfear = Tfear + fear;
            Tsadness = Tsadness + sadness;
            Tconfidence = Tconfidence + confidence;
            Texcitment = Texcitment + excitment;
            TnumberWords = TnumberWords + 1;
        }

        /** Normalise values **/
        Tjoy = Tjoy / TnumberWords;
        Tanger = Tanger / TnumberWords;
        Tfear = Tfear / TnumberWords;
        Tsadness = Tsadness / TnumberWords;
        Tconfidence = Tconfidence / TnumberWords;
        Texcitment = Texcitment / TnumberWords;

        /** return values for tag analysis **/
        float[] result = {Tjoy,Tanger,Tfear,Tsadness,Tconfidence,Texcitment};
        return result;
    }
}
