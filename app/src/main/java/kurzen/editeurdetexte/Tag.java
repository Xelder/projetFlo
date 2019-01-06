package kurzen.editeurdetexte;

public class Tag {

    String nom;
    int mainEmotion;
    int excitementValue;

    public Tag(String nom, int mainEmotion, int excitementValue) {
        this.nom = nom;
        this.mainEmotion = mainEmotion;
        this.excitementValue = excitementValue;
    }

    public String getNom() {
        return nom;
    }

    public int getMainEmotion() {
        return mainEmotion;
    }

    public int getExcitementValue() {
        return excitementValue;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMainEmotion(int mainEmotion) {
        this.mainEmotion = mainEmotion;
    }

    public void setExcitementValue(int excitementValue) {
        this.excitementValue = excitementValue;
    }
}
