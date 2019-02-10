package kurzen.editeurdetexte;

// Chose a faire
// faire en sorte que le chargement d'un pdf ce fasse sur toute les pages et pas qu'une seule
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;


import java.util.ArrayList;
import java.util.List;

import kurzen.editeurdetexte.models.Page;

public class EditeurActivity extends AppCompatActivity{
	
    private int ecranLargeur;
    private int ecranHauteur;
    private EditText saisieText;
    private static List<Page> texteComplet = new ArrayList<Page>();
    private static Page pageActuelle = null;
    private Context mContext;

    /** attributs pour la gestion des pdf **/
    AssetManager assetManager;

    /**Attributs pour l'interfacce graphique **/
    private ImageButton pagePrecedente, pageSuivante, menu, boutonImport, boutonExport, sauvegarder, retour, choixMusique;
    private ImageView rouleauEnroule, rouleauDeroule;

    @Override
    protected void onStart() {
        super.onStart();
        initialisationPage();
        mainCode();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MusiqueManager.stopperMusique(this);
    }

    private void initialisationPage()
    {
        PDFBoxResourceLoader.init(getApplicationContext());
        assetManager = getAssets();
        mContext = this;

        if(texteComplet.isEmpty()) {
            texteComplet.add(new Page(texteComplet.size(), "Page de départ"));
            pageActuelle = texteComplet.get(0);
        }
        else
        {
            Page.updatePageActuelle(mContext, "", pageActuelle.getMusique());
        }
    }

    private void mainCode()
    {
        /** option de lediteur de texte **/
        saisieText = findViewById(R.id.editText);
        saisieText.setWidth(ecranLargeur * 80 / 100);
        saisieText.setHeight(ecranHauteur * 8 / 10);
        saisieText.setX(ecranLargeur / 10);
        saisieText.setY(ecranHauteur * 12 / 100);

        if(!FileManager.getCheminPdf().trim().isEmpty()) {
            FileManager.recupererTextePDF(this, pageActuelle, (EditText) findViewById(R.id.editText), texteComplet);
        } else {
            saisieText.setText(pageActuelle.getText());
        }

        saisieText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });


        /** option de la page precedente **/
        pagePrecedente = findViewById(R.id.pagePrecedente);
        pagePrecedente.setMinimumWidth(ecranLargeur * 15 / 100);
        pagePrecedente.setMaxWidth(ecranLargeur * 15 / 100);
        pagePrecedente.setMinimumHeight(ecranHauteur / 10);
        pagePrecedente.setMaxHeight(ecranHauteur / 10);
        pagePrecedente.setX(ecranLargeur * 85 / 100);
        pagePrecedente.setY(ecranHauteur / 100);
        pagePrecedente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Page.pagePrecedente(mContext, saisieText, texteComplet);
            }

        });

        /** option de la page suivante **/
        pageSuivante = findViewById(R.id.pageSuivante);
        pageSuivante.setImageResource(R.mipmap.fleche_bas);
        pageSuivante.setMinimumWidth(ecranLargeur * 15 / 100);
        pageSuivante.setMaxWidth(ecranLargeur * 15 / 100);
        pageSuivante.setMinimumHeight(ecranHauteur / 10);
        pageSuivante.setMaxHeight(ecranHauteur / 10);
        pageSuivante.setX(ecranLargeur * 85 / 100);
        pageSuivante.setY(ecranHauteur * 89 / 100);
        pageSuivante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Page.pageSuivante(mContext, saisieText, texteComplet, true);
            }
        });

        /** rouleau enroulee **/
        rouleauEnroule = findViewById(R.id.rouleauEnroule);
        rouleauEnroule.setMinimumWidth(ecranLargeur * 60 / 100);
        rouleauEnroule.setMaxWidth(ecranLargeur * 60 / 100);
        rouleauEnroule.setMinimumHeight(ecranHauteur * 15 / 100);
        rouleauEnroule.setMaxHeight(ecranHauteur * 15 / 100);
        rouleauEnroule.setX(ecranLargeur * 3/ 100);
        rouleauEnroule.setY(ecranHauteur * 1/ 100);

        /** rouleau deroulee **/
        rouleauDeroule = findViewById(R.id.rouleauDeroule);
        rouleauDeroule.setMinimumWidth(ecranLargeur * 63 / 100);
        rouleauDeroule.setMaxWidth(ecranLargeur * 63 / 100);
        rouleauDeroule.setMinimumHeight(ecranHauteur * 59 / 100);
        rouleauDeroule.setMaxHeight(ecranHauteur * 59 / 100);
        rouleauDeroule.setX(ecranLargeur * 2/ 100);
        rouleauDeroule.setY(ecranHauteur * 1/ 100);

        /** bouton import **/
        boutonImport = findViewById(R.id.boutonImport);
        boutonImport.setMinimumWidth(ecranLargeur * 40 / 100);
        boutonImport.setMaxWidth(ecranLargeur * 40 / 100);
        boutonImport.setMinimumHeight(ecranHauteur * 6 / 100);
        boutonImport.setMaxHeight(ecranHauteur * 6/ 100);
        boutonImport.setX(ecranLargeur * 20 / 100);
        boutonImport.setY(ecranHauteur * 8/ 100);
        boutonImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //FileManager.recupererTextePDF(mContext, pageActuelle, saisieText, texteComplet);
                //FileManager.chargementFichierLocal(mContext, pageActuelle, saisieText, texteComplet);
                new ExplorateurFichiers(mContext);
            }
        });

        /** bouton export **/
        boutonExport = findViewById(R.id.boutonExport);
        boutonExport.setMinimumWidth(ecranLargeur * 40 / 100);
        boutonExport.setMaxWidth(ecranLargeur * 40 / 100);
        boutonExport.setMinimumHeight(ecranHauteur * 6 / 100);
        boutonExport.setMaxHeight(ecranHauteur * 6/ 100);
        boutonExport.setX(ecranLargeur * 20 / 100);
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
        sauvegarder.setX(ecranLargeur * 22 / 100);
        sauvegarder.setY(ecranHauteur * 24/ 100);
        sauvegarder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FileManager.sauvegarder(mContext, pageActuelle, saisieText, texteComplet);
            }
        });

        /** bouton retour **/
        retour = findViewById(R.id.Retour);
        retour.setMinimumWidth(ecranLargeur * 40 / 100);
        retour.setMaxWidth(ecranLargeur * 40 / 100);
        retour.setMinimumHeight(ecranHauteur * 6 / 100);
        retour.setMaxHeight(ecranHauteur * 6/ 100);
        retour.setX(ecranLargeur * 11 / 100);
        retour.setY(ecranHauteur * 32/ 100);
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
        choixMusique.setX(ecranLargeur * 65 / 100);
        choixMusique.setY(ecranHauteur * 2 / 100);
        choixMusique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //LancerExploFichier();
               // MusiqueManager.lancerMusique(mContext);
                new ExplorateurFichiers(mContext);
            }
        });

        /** option de la page Menu **/
        menu = findViewById(R.id.menu);
        menu.setMinimumWidth(ecranLargeur * 20 / 100);
        menu.setMaxWidth(ecranLargeur * 20 / 100);
        menu.setMinimumHeight(ecranHauteur * 15/ 100);
        menu.setMaxHeight(ecranHauteur * 15/ 100);
        menu.setX(ecranLargeur * 20 / 100);
        menu.setY(ecranHauteur * 2 / 100);

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
        setContentView(R.layout.editeur_layout);

        // suppression de la barre de notification, la barre des titres est supprime dans le manifest
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        ecranLargeur = metrics.widthPixels;
        ecranHauteur = metrics.heightPixels;
    }

    public static Page getPageActuelle()
    {
        return pageActuelle;
    }
    public static List<Page> getTexteComplet()
    {
        return texteComplet;
    }
    public static void setPageActuelle(Page p)
    {
        pageActuelle = p;
    }

}
