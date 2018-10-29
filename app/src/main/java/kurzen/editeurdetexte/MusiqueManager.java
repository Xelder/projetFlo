package kurzen.editeurdetexte;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class MusiqueManager {
    private static MediaPlayer musiqueEnCours;
    private static String cheminMusique = "";

    public static void lancerMusique(Context mContext)
    {
        // lance une musique stocké a linterieur de lappli
        if(musiqueEnCours == null)
        {
            musiqueEnCours = MediaPlayer.create(mContext, R.raw.musiquetest);
        }
        if(musiqueEnCours.isPlaying())
        {
            musiqueEnCours.stop();
        }
        musiqueEnCours.start();
        musiqueEnCours.isLooping();
    }

    public static void lancerMusique(Context mContext, String cheminMusique)
    {
        // lance une musique stocker sur le telephone
        Uri u = Uri.parse(cheminMusique);
        musiqueEnCours = MediaPlayer.create(mContext.getApplicationContext(), u);
        lancerMusique(mContext);
    }

    public static void setCheminMusique(String musique)
    {
        cheminMusique = musique;
    }

    public static String getCheminMusique()
    {
        return cheminMusique;
    }
}
