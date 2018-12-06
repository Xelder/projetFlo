package kurzen.editeurdetexte;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

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


    public static void pageSuivante(Context mContext, TextView saisieText, List<Page> texteComplet)
    {
        Page pageActuelle = EditeurActivity.getPageActuelle();
        pageActuelle.setText(saisieText.getText().toString());
        if(pageActuelle.getNumeroPage() < texteComplet.size() -1)
        {
            // on charge une page existante
            int num = pageActuelle.getNumeroPage() + 1;
            pageActuelle = texteComplet.get(num);

        } else if (pageActuelle.getNumeroPage() == texteComplet.size() - 1)
        {
            // on créé la derniere page
            texteComplet.add(new Page(texteComplet.size(), "Page " + texteComplet.size()));
            pageActuelle = texteComplet.get(texteComplet.size()-1);
        }
        saisieText.setText(pageActuelle.getText());
        EditeurActivity.setPageActuelle(pageActuelle);
        updatePageActuelle(mContext, saisieText);
    }


    public static void pagePrecedente(Context mContext, TextView saisieText, List<Page> texteComplet)
    {
        Page pageActuelle = EditeurActivity.getPageActuelle();
        pageActuelle.setText(saisieText.getText().toString());
        if(pageActuelle.getNumeroPage() > 0)
        {
            int numPage = pageActuelle.getNumeroPage() - 1;

            pageActuelle = texteComplet.get(numPage);
            saisieText.setText(pageActuelle.getText());
        }

        EditeurActivity.setPageActuelle(pageActuelle);
        updatePageActuelle(mContext,saisieText);
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

    public static void updatePageActuelle(Context mContext, TextView saisieText)
    {
        saisieText.setText(EditeurActivity.getPageActuelle().getText());
        updatePageActuelle(mContext);
    }

    public static void updatePageActuelle(Context mContext)
    {
        Page p = EditeurActivity.getPageActuelle();
        if(p.getMusique().isEmpty())
        {
            MusiqueManager.stoppperMusique();
        }
        else
        {
            System.out.println("test");
            MusiqueManager.lancerMusique(mContext, p.getMusique());
        }
    }
}
