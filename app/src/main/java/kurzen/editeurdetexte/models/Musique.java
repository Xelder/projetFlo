package kurzen.editeurdetexte.models;

import com.j256.ormlite.field.DatabaseField;

public class Musique {


    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private String nom;

    @DatabaseField
    private int numero;

    @DatabaseField(foreign = true)
    protected Tag tag;

    public Musique(){}

    public Musique(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Musique{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", numero=" + numero +
                '}';
    }
}

