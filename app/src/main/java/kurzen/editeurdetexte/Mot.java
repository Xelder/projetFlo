package kurzen.editeurdetexte;

import java.sql.Array;


public class Mot {


    private String mot;

    private int joy;
    private int anger;
    private int fear;
    private int sadness;
    private int confidence;
    private int excitment;

    private int Tjoy;
    private int Tanger;
    private int Tfear;
    private int Tsadness;
    private int Tconfidence;
    private int Texcitment;

    public Mot(){}

    public Mot(int joy, int anger, int fear, int sadness, int confidence, int excitment, int tjoy, int tanger, int tfear, int tsadness, int tconfidence, int texcitment, int tnumberWords) {
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
    }

    public Mot(int joy, int anger, int fear, int sadness, int confidence, int excitment){
        this.joy = joy;
        this.anger = anger;
        this.fear = fear;
        this.sadness = sadness;
        this.confidence = confidence;
        this.excitment = excitment;
    }

    public void setJoy(int joy) {
        this.joy = joy;
    }

    public void setMot(String mot) {
        this.mot = mot;
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

    public String getMot() {
        return mot;
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
                '}';
    }
}
