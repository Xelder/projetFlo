package kurzen.editeurdetexte.models;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;

import java.util.List;

import kurzen.editeurdetexte.EditeurActivity;
import kurzen.editeurdetexte.MusiqueManager;


public class Page {
    private String text;
    private String musique;
    private int numeroPage;
    Mot valeurEmotionnelle = new Mot();

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


    public static void pageSuivante(Context mContext, TextView saisieText, List<Page> texteComplet, boolean creationNouvellePage)
    {
        Page pageActuelle = EditeurActivity.getPageActuelle();
        pageActuelle.setText(saisieText.getText().toString());
        String musiquePrecedente = pageActuelle.getMusique();

        if(pageActuelle.getNumeroPage() < texteComplet.size() -1)
        {
            // on charge une page existante
            int num = pageActuelle.getNumeroPage() + 1;
            pageActuelle = texteComplet.get(num);

        } else if (creationNouvellePage && pageActuelle.getNumeroPage() == texteComplet.size() - 1)
        {
            // on créé la derniere page
            texteComplet.add(new Page(texteComplet.size(), "Page " + texteComplet.size()));
            pageActuelle = texteComplet.get(texteComplet.size()-1);
        }
        saisieText.setText(pageActuelle.getText());
        EditeurActivity.setPageActuelle(pageActuelle);
        updatePageActuelle(mContext, saisieText, musiquePrecedente, pageActuelle.getMusique());
    }


    public static void pagePrecedente(Context mContext, TextView saisieText, List<Page> texteComplet)
    {
        Page pageActuelle = EditeurActivity.getPageActuelle();
        pageActuelle.setText(saisieText.getText().toString());
        String musiquePrecedente = pageActuelle.getMusique();

        if(pageActuelle.getNumeroPage() > 0)
        {
            int numPage = pageActuelle.getNumeroPage() - 1;

            pageActuelle = texteComplet.get(numPage);
            saisieText.setText(pageActuelle.getText());
        }

        EditeurActivity.setPageActuelle(pageActuelle);
        updatePageActuelle(mContext,saisieText, musiquePrecedente, pageActuelle.getMusique());
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

    @Override
    public String toString() {
        return "Page{" +
                "text='" + text + '\'' +
                ", musique='" + musique + '\'' +
                ", numeroPage=" + numeroPage +
                '}' + '\n';
    }

    public static void updatePageActuelle(Context mContext, TextView saisieText, String musiquePagePrecedente, String musiquePageActuelle)
    {
        saisieText.setText(EditeurActivity.getPageActuelle().getText());
        updatePageActuelle(mContext, musiquePagePrecedente, musiquePageActuelle);
    }

    public static void updatePageActuelle(Context mContext, String musiquePagePrecedente, String musiquePageActuelle)
    {
        Page p = EditeurActivity.getPageActuelle();
        if(p.getMusique().trim().isEmpty())
        {
            MusiqueManager.stopperMusique(mContext);
        }
        else
        {
            if(!(musiquePageActuelle.equals(musiquePagePrecedente)))
            {
                MusiqueManager.lancerMusique(mContext, musiquePageActuelle);
            }
        }
    }
}
