package kurzen.editeurdetexte;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tags")
public class Tag {

    @DatabaseField(id = true, generatedId=true)
    private long id;

    @DatabaseField(canBeNull = true)
    private String nom;
    @DatabaseField(canBeNull = true)
    private int mainEmotion;
    @DatabaseField(canBeNull = true)
    private int excitementValue;

    public Tag(){

    }


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
