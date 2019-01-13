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

    @DatabaseField(foreign = true)
    protected Tags tags;

    public Tag(){

    }


    public Tag(String nom, int mainEmotion, int excitementValue, Tags tags) {
        this.nom = nom;
        this.mainEmotion = mainEmotion;
        this.excitementValue = excitementValue;
        this.tags = tags;
    }


    public Tag(String nom, int mainEmotion, int excitementValue ) {
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

    @Override
    public String toString() {
        return "Tag{" +
                "nom='" + nom + '\'' +
                ", mainEmotion=" + mainEmotion +
                ", excitementValue=" + excitementValue +
                '}';
    }
}
