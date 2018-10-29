package kurzen.editeurdetexte;

import android.net.Uri;
import android.widget.EditText;

import java.util.List;


public class Page {
    private String text;
    private String musique;
    private int numeroPage;

    public Page(int numeroPage, String text)
    {
        this(numeroPage, text, "");
    }

    public Page(int numeroPage, String text, String cheminAbosluMusique)
    {
        this.text = text;
        this.numeroPage = numeroPage;
        this.musique = cheminAbosluMusique;
    }


    public static Page pageSuivante(Page pageActuelle, EditText saisieText, List<Page> texteComplet)
    {
        pageActuelle.setText(saisieText.getText().toString());
        if(pageActuelle.getNumeroPage() < texteComplet.size() -1)
        {
            // on charge une page existante
            System.out.println("avant = " + pageActuelle.getNumeroPage());
            int num = pageActuelle.getNumeroPage() + 1;
            System.out.println("num = " + num);
            pageActuelle = texteComplet.get(num);

            System.out.println("apres = " + pageActuelle.getNumeroPage());
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

    public void changerPage(Page p)
    {
        this.numeroPage = p.getNumeroPage();
        this.text = p.getText();
        this.musique = p.getText();
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
