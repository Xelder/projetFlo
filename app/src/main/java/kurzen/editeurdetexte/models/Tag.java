package kurzen.editeurdetexte.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

public class Tag {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private String nom;

    @DatabaseField
    private int mainEmotion;

    @DatabaseField
    private int excitementValue;

    @DatabaseField
    private String nomMainEmotion;

    public Tag(){

    }


    public Tag(String nom, int mainEmotion, int excitementValue, String nomMainEmotion) {
        this.nom = nom;
        this.mainEmotion = mainEmotion;
        this.excitementValue = excitementValue;
        this.nomMainEmotion = nomMainEmotion;
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

    public String getNomMainEmotion() {
        return nomMainEmotion;
    }

    public void setNomMainEmotion(String nomMainEmotion) {
        this.nomMainEmotion = nomMainEmotion;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", mainEmotion=" + mainEmotion +
                ", excitementValue=" + excitementValue +
                ", nomMainEmotion='" + nomMainEmotion + '\'' +
                '}';
    }
}
