package kurzen.editeurdetexte;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.dao.TagDAO;
import kurzen.editeurdetexte.models.Tag;

public class MenuActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void profileClic(View v)
    {

        // get our dao
        TagDAO dao = new TagDAO(this.getHelper());

        // query for all of the data objects in the database
        List<Tag> liste = dao.getAll();

        StringBuilder sb = new StringBuilder();

        int simpleC = 1;
        for(Tag simple : liste)
        {
            sb.append('#').append(simpleC).append(": ").append(simple).append('\n');
            simpleC++;
        }


        System.out.println(sb);
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
        TagDAO dao = new TagDAO(this.getHelper());
        dao.deleteById(3);
    }
}
