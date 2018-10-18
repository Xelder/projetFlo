package kurzen.editeurdetexte;

import android.net.Uri;
import android.widget.EditText;

import java.util.List;

/**
 * Created by kurzen on 25/07/2018.
 */

public class Page {
    private String text;
    private Uri musique;
    private int numeroPage;



    public Page(int numeroPage, String text)
    {
        this(numeroPage, text, "");
    }

    public Page(int numeroPage, String text, String cheminAbosluMusique)
    {
        this.numeroPage = numeroPage;
        this.text = text;
        this.musique = Uri.parse(cheminAbosluMusique);
    }


    public static Page pageSuivante(Page pageActuelle, EditText saisieText, List<Page> texteComplet)
    {
        pageActuelle.setText(saisieText.getText().toString());
        if(pageActuelle.getNumeroPage() < texteComplet.size() -1)
        {
            // on charge une page existante
            pageActuelle = texteComplet.get(pageActuelle.getNumeroPage() + 1);
        } else if (pageActuelle.getNumeroPage() == texteComplet.size() - 1)
        {
            // on créé la derniere page
            texteComplet.add(new Page(texteComplet.size(), "Page " + texteComplet.size()));
            pageActuelle = texteComplet.get(texteComplet.size()-1);
        }

        saisieText.setText(pageActuelle.getText());
        return pageActuelle;
    }


    public static Page pagePrecedente(Page pageActuelle, EditText saisieText, List<Page> texteComplet)
    {
        pageActuelle.setText(saisieText.getText().toString());
        if(pageActuelle.getNumeroPage() > 0)
        {
            int numPage = pageActuelle.getNumeroPage() - 1;

            pageActuelle = texteComplet.get(numPage);
            saisieText.setText(pageActuelle.getText());
        }

        return pageActuelle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Uri getMusique() {
        return musique;
    }

    public void setMusique(Uri musique) {
        this.musique = (Uri)musique;
    }

    public int getNumeroPage() {
        return numeroPage;
    }

    public void setNumeroPage(int numeroPage) {
        this.numeroPage = numeroPage;
    }
}
