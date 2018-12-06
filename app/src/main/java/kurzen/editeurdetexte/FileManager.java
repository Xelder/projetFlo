package kurzen.editeurdetexte;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.text.PDFTextStripper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FileManager {

    private static String nomFichier = "testFichier";
    private static File root = android.os.Environment.getExternalStorageDirectory();
    private static String cheminPdf = "";

    public static void chargementFichierLocal(Context mContexte, Page pageActuelle, TextView saisieText, List<Page> texteComplet)
    {
        FileInputStream in = null;
        texteComplet.clear();

        try {
            in = mContexte.openFileInput(nomFichier);
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

           extrairePage(mContexte, sb.toString(), texteComplet);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        EditeurActivity.setPageActuelle(texteComplet.get(0));
        Page.updatePageActuelle(mContexte, saisieText);
    }

    static void recupererTextePDF(Context mContext, Page pageActuelle, EditText saisieText, List<Page> texteComplet)
    {
        String cheminAbosluFichierPDF = "" + cheminPdf;
        PDDocument document = null;

        int i, j; // j = i-1
        try {
            File f = new File(cheminAbosluFichierPDF);
            document = PDDocument.load(f);
        } catch(IOException e) {
            e.printStackTrace();
        }

        if(document != null)
        {
            try {
                PDFTextStripper pdfStripper = new PDFTextStripper();

                texteComplet.clear();
                for(i = 1 ; i <= document.getNumberOfPages() ; i++)
                {
                    pdfStripper.setStartPage(i);
                    pdfStripper.setEndPage(i);

                    String texte = pdfStripper.getText(document);
                    texteComplet.add(new Page(i - 1, texte, ""));

                    System.out.println("Page " + i + " terminée");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            pageActuelle.changerPage(texteComplet.get(0));

            saisieText.setText(pageActuelle.getText());
        }
        else
            saisieText.setText("document non trouve");

        pageActuelle = texteComplet.get(0);
        saisieText.setText(pageActuelle.getText());
        Toast.makeText(mContext, "Importation terminée", Toast.LENGTH_LONG).show();
    }



    private static void extrairePage(Context mContext, String texteAExtraire, List<Page> texteComplet)
    {
        String tmpPage = "";
        String tmpTexte = "";
        String tmpMusique = "";
        String lienMusique = null;

        if(!texteComplet.isEmpty())
        {
            texteComplet.clear();
        }

        for(int i = 0 ; i < texteAExtraire.length() ; i++)
        {
            if(texteAExtraire.charAt(i) == '\\')
            {
                // on recupere les 6 prochain caractere pour voir si c'est musique
                tmpMusique = "" + texteAExtraire.charAt(i + 1);
                tmpMusique += texteAExtraire.charAt(i + 2);
                tmpMusique += texteAExtraire.charAt(i + 3);
                tmpMusique += texteAExtraire.charAt(i + 4);
                tmpMusique += texteAExtraire.charAt(i + 5);
                tmpMusique += texteAExtraire.charAt(i + 6);
                tmpMusique += texteAExtraire.charAt(i + 7);

                if(tmpMusique.equals("musique"))
                {
                    i += 9;
                    lienMusique = "";
                    while(texteAExtraire.charAt(i) != '\\')
                    {
                        lienMusique += texteAExtraire.charAt(i);
                        i++;
                    }
                    tmpMusique = "";
                }

                // on recupere les 4 prochain carateres pour voir si c'est page
                tmpPage = "" + texteAExtraire.charAt(i + 1) ;
                tmpPage += texteAExtraire.charAt(i + 2) ;
                tmpPage += texteAExtraire.charAt(i + 3);
                tmpPage +=texteAExtraire.charAt(i + 4);

                if(tmpPage.equals("page"))
                {
                    Page p = new Page(texteComplet.size(), tmpTexte);
                    p.setMusique(lienMusique);
                    texteComplet.add(p);
                    i += 5;
                    tmpTexte = "";
                    tmpPage = "";
                    lienMusique = "";
                }
                else
                    tmpTexte = tmpTexte + texteAExtraire.charAt(i);
            }
            else
            {
                tmpTexte = tmpTexte + texteAExtraire.charAt(i);
            }
        }
    }

    public static void sauvegarder(Context mContext, Page pageActuelle, EditText saisieText, List<Page> texteComplet)
    {
        pageActuelle.setText(saisieText.getText().toString());

        FileOutputStream output = null;
        String texteASauvegarger = "";

        for(int i = 0 ; i < texteComplet.size() ; i++)
        {
            texteASauvegarger += texteComplet.get(i).getText();
            texteASauvegarger += "\\musique\\";
            texteASauvegarger += texteComplet.get(i).getMusique();
            texteASauvegarger += "\\page\\";
        }

        try
        {
            output = mContext.openFileOutput(nomFichier, mContext.MODE_PRIVATE);
            output.write(texteASauvegarger.getBytes());

            if(output != null) {
                output.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(mContext, "Sauvegarde terminée", Toast.LENGTH_LONG).show();
    }

    public static void LancerExploFichier(Context mContext)
    {
        Intent intent = new Intent(mContext, ExplorateurFichiersActivity.class);
        mContext.startActivity(intent);
    }

    public static void lancerEditeur(Context mContext)
    {
        Intent intent = new Intent(mContext, EditeurActivity.class);
        mContext.startActivity(intent);
    }

    public static void setCheminPdf(String pdf)
    {
        cheminPdf = pdf;
    }
}