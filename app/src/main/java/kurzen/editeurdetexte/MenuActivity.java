package kurzen.editeurdetexte;

import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.dao.MotDAO;
import kurzen.editeurdetexte.dao.MusiqueDAO;
import kurzen.editeurdetexte.dao.TagDAO;
import kurzen.editeurdetexte.dao.TagsDAO;
import kurzen.editeurdetexte.models.Mot;
import kurzen.editeurdetexte.models.Musique;
import kurzen.editeurdetexte.models.Tag;
import kurzen.editeurdetexte.models.Tags;

public class MenuActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void profileClic(View v)
    {

    }

    public void writeClic(View v)
    {
        FileManager.lancerEditeur(this);
    }

    public void readClic(View v)
    {
        Liseuse.lancerLiseuse(this);
    }

    public void musicClic(View v)
    {

    }
}
