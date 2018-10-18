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

public class ExplorateurFichiers2 extends AppCompatActivity {
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

        // Use the current directory as title
        if (getIntent().hasExtra("path")) {
            path = getIntent().getStringExtra("path");
        }
        setTitle(path);

        // Read all files sorted into the values-array;
        File dir = new File(path);

        if (!dir.canRead()) {
            setTitle(getTitle() + " (inaccessible)");
        }

        //File[] list = dir.listFiles();
        File[] list = dir.listFiles();

        if (list != null) {
            for (File file : list) {
                if (!file.getName().startsWith(".")) {
                    tabFichier.add(file.getName());
                }
            }
        }
        Collections.sort(tabFichier);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterview, View view, int i , long l)
            {
                 String filename = (String) tabFichier.get(i);
                if (path.endsWith(File.separator)) {
                    filename = path + filename;
                } else {
                    filename = path + File.separator + filename;
                }
                if (new File(filename).isDirectory()) {
                    Intent intent = new Intent(mContext, ExplorateurFichiers2.class);
                    intent.putExtra("path", filename);
                    startActivity(intent);
                } else {
                    Toast.makeText(mContext, filename + " is not a directory", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
