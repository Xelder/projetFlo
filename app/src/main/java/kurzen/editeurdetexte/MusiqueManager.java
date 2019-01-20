package kurzen.editeurdetexte;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.SystemClock;

import java.util.List;

import kurzen.editeurdetexte.models.Page;
import kurzen.editeurdetexte.thread.LancerMusiqueThread;
import kurzen.editeurdetexte.thread.StopMusiqueThread;

public class MusiqueManager {
    private static MediaPlayer musiqueEnCours;
    private static String cheminMusique = "";

    public static void lancerMusique(Context mContext, String cheminMusique)
    {
        // lance une musique stocker sur le telephone
        if(musiqueEnCours != null)
        {
            stopperMusique(mContext);
        }

        Uri u = Uri.parse(cheminMusique);
        musiqueEnCours = MediaPlayer.create(mContext.getApplicationContext(), u);

        LancerMusiqueThread lancerMusiqueThread = new LancerMusiqueThread(mContext, musiqueEnCours);
        lancerMusiqueThread.start();

    }

    public static void stopperMusique(Context mContext)
    {
        if(musiqueEnCours != null)
        {
            StopMusiqueThread musiqueThread = new StopMusiqueThread(mContext, musiqueEnCours);
            musiqueThread.start();

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
