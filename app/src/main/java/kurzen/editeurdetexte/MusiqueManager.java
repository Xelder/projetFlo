package kurzen.editeurdetexte;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.util.List;

import kurzen.editeurdetexte.models.Page;

public class MusiqueManager {
    private static MediaPlayer musiqueEnCours;
    private static String cheminMusique = "";

    public static void lancerMusique(Context mContext, String cheminMusique)
    {
        // lance une musique stocker sur le telephone
        stoppperMusique();

        Uri u = Uri.parse(cheminMusique);
        musiqueEnCours = MediaPlayer.create(mContext.getApplicationContext(), u);
        musiqueEnCours.setLooping(true);
        musiqueEnCours.start();
    }

    public static void stoppperMusique()
    {
        if(musiqueEnCours != null)
        {
            musiqueEnCours.stop();
            musiqueEnCours.release();
            musiqueEnCours = null;
        }
    }

    public static void setCheminMusique(String musique)
    {
        cheminMusique = musique;
        List<Page> pages = EditeurActivity.getTexteComplet();
        Page p = EditeurActivity.getPageActuelle();

        pages.get(p.getNumeroPage()).setMusique(cheminMusique);
    }

    public static String getCheminMusique()
    {
        return cheminMusique;
    }
}
