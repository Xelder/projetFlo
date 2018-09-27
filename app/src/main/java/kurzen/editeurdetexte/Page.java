package kurzen.editeurdetexte;

/**
 * Created by kurzen on 25/07/2018.
 */

public class Page {
    private String text;
    private String musique;
    private int numeroPage;

    // mettre un test dans le cas que musique est egale a -1

    public Page(int numeroPage, String text)
    {
        this.numeroPage = numeroPage;
        this.text = text;
        musique = null;
    }

    public Page(int numeroPage, String text, String cheminAbosluMusique)
    {
        this.numeroPage = numeroPage;
        this.text = text;
        this.musique = cheminAbosluMusique;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMusique() {
        return musique;
    }

    public void setMusique(String musique) {
        this.musique = new String(musique);
    }

    public int getNumeroPage() {
        return numeroPage;
    }

    public void setNumeroPage(int numeroPage) {
        this.numeroPage = numeroPage;
    }
}
