package kurzen.editeurdetexte;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

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
    private static File root = android.os.Environment.getExternalStorageDirectory();;

    public static void chargementFichierLocal(Context mContexte, Page pageActuelle, EditText saisieText, List<Page> texteComplet)
    {
        FileInputStream in = null;

        try {
            in = mContexte.openFileInput(nomFichier);
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

           extrairePage(sb.toString(), texteComplet);
        }catch(FileNotFoundException e){

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
        pageActuelle = texteComplet.get(0);
        saisieText.setText(pageActuelle.getText());
    }

    public static void recupererTextePDF(Page pageActuelle,EditText saisieText, List<Page> texteComplet)
    {
        String cheminAbosluFichierPDF = new String(root.getAbsolutePath() + "/Download/pdf-test.pdf");
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
                for(i = 1 ; i <= document.getNumberOfPages() ; i++)
                {
                    j = i - 1;
                    pdfStripper.setStartPage(j);
                    pdfStripper.setEndPage(i);
                    pageActuelle.setText(pdfStripper.getText(document));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (document != null) document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            saisieText.setText(pageActuelle.getText());
        }
        else
            saisieText.setText("document non trouvé");

        saisieText.setText(pageActuelle.getText());
    }



    private static void extrairePage(String texteAExtraire, List<Page> texteComplet)
    {
        String tmpPage = "", tmpTexte = "";

        if(!texteComplet.isEmpty())
        {
            texteComplet.clear();
        }

        for(int i = 0 ; i < texteAExtraire.length() ; i++)
        {
            if(texteAExtraire.charAt(i) == '/')
            {
                tmpPage = new String("" + texteAExtraire.charAt(i + 1) + texteAExtraire.charAt(i + 2) + texteAExtraire.charAt(i + 3) + texteAExtraire.charAt(i + 4));
                if(tmpPage.equals(new String("page")))
                {
                    Page p = new Page(texteComplet.size(), tmpTexte);
                    texteComplet.add(p);
                    i += 5;
                    tmpTexte = "";
                }
                else
                    tmpTexte = new String(tmpTexte + texteAExtraire.charAt(i));
            }
            else
            {
                tmpTexte = new String(tmpTexte + texteAExtraire.charAt(i));
            }
        }
        texteComplet.add(new Page(texteComplet.size(), tmpTexte));
    }

    public static void sauvegarder(Context mContext, Page pageActuelle, EditText saisieText, List<Page> texteComplet)
    {
        pageActuelle.setText(saisieText.getText().toString());

        FileOutputStream output = null;
        String texteASauvegarger = new String("");

        for(int i = 0 ; i < texteComplet.size() ; i++)
        {
            if(i != texteComplet.size())
                texteASauvegarger = new String(texteASauvegarger + texteComplet.get(i).getText() + "/page/");
            else
                texteASauvegarger = new String(texteASauvegarger + texteComplet.get(i).getText());
        }
        try {
            output = mContext.openFileOutput(nomFichier, mContext.MODE_PRIVATE);
            output.write(texteASauvegarger.getBytes());

            if(output != null)
                output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LancerExploFichier(Context mContext)
    {
        Intent intent = new Intent(mContext, ExplorateurFichiers2.class);
        mContext.startActivity(intent);
    }
}