package kurzen.editeurdetexte;

// Chose a faire
// mettre une boite de dialog qui affiche si le texte et sauvegarde
// lancerexploFichier ne fonctionne pas en API 23
// tester avec des autres API, 19 minimum pour accepter les pdf

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.text.PDFTextStripper;
import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class MainActivity extends AppCompatActivity{
	
    private int ecranLargeur, ecranHauteur;
    private EditText saisieText;
    private String texteExemple = "", nomFichier = "testFichier";
    private Vector<Page> texteComplet = new Vector<Page>();
    private int nombreDePage = 0, pageActuelle = 0;
    private FileExplore fe;

    /** attributs pour la gestion des pdf **/
    File root;
    AssetManager assetManager;



    /**Attributs pour l'interfacce graphique **/
    private ImageButton pagePrecedente, pageSuivante, menu, boutonImport, boutonExport, sauvegarder, retour, choixMusique;
    private ImageView rouleauEnroule, rouleauDeroule;

    /** Attributs pour la lecture de musique **/
    MediaPlayer musiqueEnCours;

    @Override
    protected void onStart() {
        super.onStart();
        initialisationPage();
        mainCode();
    }

    private void initialisationPage()
    {
        //super.onStart();
        PDFBoxResourceLoader.init(getApplicationContext());
        root = android.os.Environment.getExternalStorageDirectory();
        assetManager = getAssets();

        texteComplet.add(new Page(0, "page vide"));
    }

    private void chargementFichierLocal()
    {
        FileInputStream in = null;

        try {
            in = openFileInput(nomFichier);
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

           extrairePage(sb.toString());
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
        pageActuelle = 0;
        changerTextePrincipal(texteComplet.elementAt(0).getText());
    }

    private void recupererTextePDF()
    {
        String cheminAbosluFichierPDF = new String(root.getAbsolutePath() + "/Download/test-pdf.pdf");
        PDDocument document = null;

        int i, j; // j = i-1

        try {
            File f = new File(cheminAbosluFichierPDF);
            document = PDDocument.load(f);
            nombreDePage = document.getNumberOfPages();
        } catch(IOException e) {
            e.printStackTrace();
        }

        if(document != null)
        {
            try {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                for(i = 1 ; i <= nombreDePage ; i++)
                {
                    j = i - 1;
                    pdfStripper.setStartPage(j);
                    pdfStripper.setEndPage(i);
                    texteComplet.add(new Page(j, pdfStripper.getText(document)));
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
            saisieText.setText(new String(texteComplet.elementAt(0).getText()));
        }
        else
            saisieText.setText("document est null");

    }

    private void extrairePage(String texteAExtraire)
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
                    Page p = new Page(nombreDePage, tmpTexte);
                    texteComplet.add(p);
                    nombreDePage++;
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
        texteComplet.add(new Page(nombreDePage, tmpTexte));
        nombreDePage++;
    }

    private void sauvegarder()
    {
        /** sauvegarde des dernieres modifications **/
        texteComplet.elementAt(pageActuelle).setText(saisieText.getText().toString());

        FileOutputStream output = null;
        String texteASauvegarger = new String("");

        for(int i = 0 ; i <= nombreDePage ; i++)
        {
            if(i != nombreDePage)
                texteASauvegarger = new String(texteASauvegarger + texteComplet.elementAt(i).getText() + "/page/");
            else
                texteASauvegarger = new String(texteASauvegarger + texteComplet.elementAt(i).getText());
        }
        try {
            output = openFileOutput(nomFichier, MODE_PRIVATE);
            output.write(texteASauvegarger.getBytes());

            if(output != null)
                output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changerTextePrincipal(String texte)
    {
        Page p = new Page(pageActuelle, texte);
        texteComplet.elementAt(pageActuelle).setText(texte);
        saisieText.setText(texteComplet.elementAt(pageActuelle).getText());
    }

    private void pageSuivante()
    {
        texteComplet.elementAt(pageActuelle).setText(saisieText.getText().toString());
        if(pageActuelle < nombreDePage - 1)
        {
            pageActuelle++;
        }
        else
        {
            pageActuelle++;
            nombreDePage++;
            texteComplet.add(new Page(pageActuelle, new String("Nouvelle page")));
        }
        saisieText.setText(texteComplet.elementAt(pageActuelle).getText());
    }

    private void pagePrecedente()
    {
        texteComplet.setElementAt(new Page(pageActuelle, saisieText.getText().toString()),pageActuelle);
        if(pageActuelle != 0)
        {
            pageActuelle--;
        }
        saisieText.setText(texteComplet.elementAt(pageActuelle).getText());
    }

    /** Fonction pour les musiques **/
    private void changerMusiqueEnCours()
    {
        musiqueEnCours.stop();
       // musiqueEnCours = MediaPlayer.create(this, texteComplet.elementAt(pageActuelle).getMusique());
        lancerMusique();
    }

    private void lancerMusique()
    {
        musiqueEnCours.start();
        musiqueEnCours.isLooping();
    }

    private void lancerMusique(String cheminMusique)
    {
        Uri u = Uri.parse(cheminMusique);
        musiqueEnCours = MediaPlayer.create(getApplicationContext(), u);
        lancerMusique();
    }
    private void LancerExploFichier()
    {
        Intent intent = new Intent(MainActivity.this, FileExplore.class);
        startActivity(intent);
    }

    private void getCheminMusique()
    {
        texteComplet.elementAt(pageActuelle).setMusique(FileExplore.mMyAppsBundle.getString("cheminAboslu"));
    }

    private void mainCode()
    {
        /** option de lediteur de texte **/
        saisieText = findViewById(R.id.editText);
        saisieText.setWidth(ecranLargeur * 80 / 100);
        saisieText.setHeight(ecranHauteur * 8 / 10);
        saisieText.setX(ecranLargeur / 10);
        saisieText.setY(ecranHauteur * 12 / 100);
        saisieText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    changerTextePrincipal(saisieText.getText().toString());
                }
            }
        });
        changerTextePrincipal("texte de depart");

        /** option de la page precedente **/
        pagePrecedente = findViewById(R.id.pagePrecedente);
        pagePrecedente.setMinimumWidth(ecranLargeur * 15 / 100);
        pagePrecedente.setMaxWidth(ecranLargeur * 15 / 100);
        pagePrecedente.setMinimumHeight(ecranHauteur / 10);
        pagePrecedente.setMaxHeight(ecranHauteur / 10);
        pagePrecedente.setX(ecranLargeur * 85 / 100);
        pagePrecedente.setY(ecranHauteur * 1 / 100);
        pagePrecedente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                pagePrecedente();
            }

        });

        /** option de la page suivante **/
        pageSuivante = findViewById(R.id.pageSuivante);
        pageSuivante.setImageResource((int)R.mipmap.fleche_bas);
        pageSuivante.setMinimumWidth(ecranLargeur * 15 / 100);
        pageSuivante.setMaxWidth(ecranLargeur * 15 / 100);
        pageSuivante.setMinimumHeight(ecranHauteur / 10);
        pageSuivante.setMaxHeight(ecranHauteur / 10);
        pageSuivante.setX(ecranLargeur * 85 / 100);
        pageSuivante.setY(ecranHauteur * 89 / 100);
        pageSuivante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                pageSuivante();
            }
        });

        /** rouleau enroulee **/
        rouleauEnroule = findViewById(R.id.rouleauEnroule);
        rouleauEnroule.setMinimumWidth(ecranLargeur * 30 / 100);
        rouleauEnroule.setMaxWidth(ecranLargeur * 30 / 100);
        rouleauEnroule.setMinimumHeight(ecranHauteur * 5 / 100);
        rouleauEnroule.setMaxHeight(ecranHauteur * 5 / 100);
        rouleauEnroule.setX(ecranLargeur * 5 / 100);
        rouleauEnroule.setY(ecranHauteur * 9/ 100);

        /** rouleau deroulee **/
        rouleauDeroule = findViewById(R.id.rouleauDeroule);
        rouleauDeroule.setMinimumWidth(ecranLargeur * 31 / 100);
        rouleauDeroule.setMaxWidth(ecranLargeur * 31 / 100);
        rouleauDeroule.setMinimumHeight(ecranHauteur * 55 / 100);
        rouleauDeroule.setMaxHeight(ecranHauteur * 55 / 100);
        rouleauDeroule.setX(ecranLargeur * 2 / 100);
        rouleauDeroule.setY(ecranHauteur * 9/ 100);

        /** bouton import **/
        boutonImport = findViewById(R.id.boutonImport);
        boutonImport.setMinimumWidth(ecranLargeur * 40 / 100);
        boutonImport.setMaxWidth(ecranLargeur * 40 / 100);
        boutonImport.setMinimumHeight(ecranHauteur * 6 / 100);
        boutonImport.setMaxHeight(ecranHauteur * 6/ 100);
        boutonImport.setX(ecranLargeur * 7 / 100);
        boutonImport.setY(ecranHauteur * 11/ 100);
        boutonImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //recupererTextePDF();
                chargementFichierLocal();
            }
        });

        /** bouton export **/
        boutonExport = findViewById(R.id.boutonExport);
        boutonExport.setMinimumWidth(ecranLargeur * 40 / 100);
        boutonExport.setMaxWidth(ecranLargeur * 40 / 100);
        boutonExport.setMinimumHeight(ecranHauteur * 6 / 100);
        boutonExport.setMaxHeight(ecranHauteur * 6/ 100);
        boutonExport.setX(ecranLargeur * 7 / 100);
        boutonExport.setY(ecranHauteur * 16/ 100);
        boutonExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });

        /** bouton sauvegarder **/
        sauvegarder = findViewById(R.id.sauvegarder);
        sauvegarder.setMinimumWidth(ecranLargeur * 40 / 100);
        sauvegarder.setMaxWidth(ecranLargeur * 40 / 100);
        sauvegarder.setMinimumHeight(ecranHauteur * 6 / 100);
        sauvegarder.setMaxHeight(ecranHauteur * 6/ 100);
        sauvegarder.setX(ecranLargeur * 7 / 100);
        sauvegarder.setY(ecranHauteur * 21/ 100);
        sauvegarder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sauvegarder();
            }
        });

        /** bouton retour **/
        retour = findViewById(R.id.Retour);
        retour.setMinimumWidth(ecranLargeur * 40 / 100);
        retour.setMaxWidth(ecranLargeur * 40 / 100);
        retour.setMinimumHeight(ecranHauteur * 6 / 100);
        retour.setMaxHeight(ecranHauteur * 6/ 100);
        retour.setX(ecranLargeur * 7 / 100);
        retour.setY(ecranHauteur * 26/ 100);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            }
        });

        /** bouton choisir musique **/
        choixMusique = findViewById(R.id.choixMusique);
        choixMusique.setMinimumWidth(ecranLargeur * 10 / 100);
        choixMusique.setMaxWidth(ecranLargeur * 10 / 100);
        choixMusique.setMinimumHeight(ecranHauteur * 10 / 100);
        choixMusique.setMaxHeight(ecranHauteur * 10/ 100);
        choixMusique.setX(ecranLargeur * 50 / 100);
        choixMusique.setY(ecranHauteur * 5 / 100);
        choixMusique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                LancerExploFichier();
            }
        });

        /** option de la page Menu **/
        menu = findViewById(R.id.menu);
        menu.setMinimumWidth(ecranLargeur * 30 / 100);
        menu.setMaxWidth(ecranLargeur * 30 / 100);
        menu.setMinimumHeight(ecranHauteur * 2/ 10);
        menu.setMaxHeight(ecranHauteur * 2/ 10);
        menu.setX(ecranLargeur * 2 / 100);
        menu.setY(ecranHauteur * 1 / 100);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(rouleauDeroule.getVisibility() == View.VISIBLE)
                {
                    sauvegarder.setVisibility(View.INVISIBLE);
                    retour.setVisibility(View.INVISIBLE);
                    boutonImport.setVisibility(View.INVISIBLE);
                    boutonExport.setVisibility(View.INVISIBLE);
                    rouleauDeroule.setVisibility(View.INVISIBLE);
                    rouleauEnroule.setVisibility(View.VISIBLE);
                }
                else
                {
                    sauvegarder.setVisibility(View.VISIBLE);
                    retour.setVisibility(View.VISIBLE);
                    rouleauDeroule.setVisibility(View.VISIBLE);
                    boutonExport.setVisibility(View.VISIBLE);
                    boutonImport.setVisibility(View.VISIBLE);
                    rouleauEnroule.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // suppression de la barre de notification, la barre des titres est supprime dans le manifest
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        ecranLargeur = metrics.widthPixels;
        ecranHauteur = metrics.heightPixels;
    }

}
