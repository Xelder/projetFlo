package kurzen.editeurdetexte;

import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.dao.MotDAO;
import kurzen.editeurdetexte.dao.TagsDAO;
import kurzen.editeurdetexte.models.Mot;
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
        TagsDAO dao = new TagsDAO(this.getHelper());

        Tags tags = dao.getById(5);

        for(Tag tag : tags.getTags())
                System.out.println(tag);

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
        MotDAO dao = new MotDAO(this.getHelper());
        Mot mot = new Mot();
        mot.setMot("test");
        Tag tag = new Tag();
        dao.insert(mot);
    }
}
