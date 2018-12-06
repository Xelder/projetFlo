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

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void profileClic(View v)
    {
        System.out.println("profile");
    }

    public void writeClic(View v)
    {
        FileManager.lancerEditeur(this);
    }

    public void readClic(View v)
    {
        System.out.println("read");
    }

    public void musicClic(View v)
    {
        System.out.println("music");
    }
}
