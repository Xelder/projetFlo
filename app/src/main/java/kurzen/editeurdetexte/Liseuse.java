package kurzen.editeurdetexte;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Liseuse extends AppCompatActivity {
    private TextView texte;
    private Context mContext;
    private Page pageActuelle = null;
    private List<Page> texteComplet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_liseuse);
        texte = findViewById(R.id.textView);
        mContext = this;

        FileManager.chargementFichierLocal(this , pageActuelle, texte, texteComplet);
        texte.setMovementMethod(new ScrollingMovementMethod());
    }

    public static void lancerLiseuse(Context mContext)
    {
        Intent intent = new Intent(mContext, Liseuse.class);
        mContext.startActivity(intent);
    }

    public void pageSuivante(View v)
    {
        Page.pageSuivante(mContext, texte, texteComplet);
    }

    public void pagePrecedente(View v)
    {
        Page.pagePrecedente(mContext, texte, texteComplet);
    }
}
