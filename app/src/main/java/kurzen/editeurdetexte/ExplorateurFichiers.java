package kurzen.editeurdetexte;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class ExplorateurFichiers {
    private Context mContext;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 0;

    public ExplorateurFichiers(Context mContext)
    {
        this.mContext = mContext;
        if(android.os.Build.VERSION.SDK_INT < 23) {
            // code pour les api 22 et moins
            FileManager.LancerExploFichier(mContext);
        }
        else{
            // code pour les api 23 et plus

            // on regarde si on a les droits
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(mContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                // on a pas les droits

                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)mContext,
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    // doit afficher une explication de pourquoi on a besoin des droits

                } else {
                    // On demande les droits
                    ActivityCompat.requestPermissions((Activity)mContext,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

                }
            } else {
                // on a deja les droits
                FileManager.LancerExploFichier(this.mContext);
            }
        }
    }
}
