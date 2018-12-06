package kurzen.editeurdetexte;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExplorateurFichiersActivity extends AppCompatActivity {
    //private String path = new File(new File(Environment.getExternalStorageDirectory().getParent()).getParent()).getAbsolutePath();
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    private Context mContext;
    private List<String> tabFichier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_explorateur_fichier);

        this.mContext = this;
        ListView listview = (ListView) findViewById(R.id.list);
        tabFichier = new ArrayList<String>();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tabFichier);
        listview.setAdapter(adapter);

        if (getIntent().hasExtra("path")) {
            path = getIntent().getStringExtra("path");
        }
        setTitle(path);

        File dir = new File(path);
        if (!dir.canRead()) {
            setTitle(getTitle() + " (inaccessible)");
        }

        String[] list = dir.list();
        if (list != null) {
            for (String file : list) {
                if (!file.startsWith(".")) {
                    tabFichier.add(file);
                }
            }
        }
        Collections.sort(tabFichier);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterview, View view, int i , long l)
            {
                 String filename = tabFichier.get(i);
                if (path.endsWith(File.separator)) {
                    filename = path + filename;
                } else {
                    if(filename.equals("emulated"))
                    {
                        filename = filename + "/0";
                    }

                    filename = path + File.separator + filename;
                }
                if (new File(filename).isDirectory()) {
                    Intent intent = new Intent(mContext, ExplorateurFichiersActivity.class);
                    intent.putExtra("path", filename);
                    startActivity(intent);
                } else {
                    if(filename.endsWith(".pdf"))
                    {
                        FileManager.setCheminPdf(filename);
                    }
                    else if(filename.endsWith(".mp3") || filename.endsWith(".mp4"))
                    {
                        MusiqueManager.setCheminMusique(filename);
                    }
                    Toast.makeText(mContext, filename, Toast.LENGTH_LONG).show();
                    FileManager.lancerEditeur(mContext);
                }
            }
        });
    }
}
