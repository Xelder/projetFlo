package kurzen.editeurdetexte.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kurzen.editeurdetexte.config.DatabaseHelper;
import kurzen.editeurdetexte.dao.TagDAO;
import kurzen.editeurdetexte.models.Tag;

public class Tags {

    @DatabaseField(generatedId = true)
    private long id;

    /**
     * dao de la class Tag
     */
    private TagDAO tagDAO;

    @DatabaseField
    private String nom;

    @ForeignCollectionField(eager = true)
    ForeignCollection<Tag> tags;

    public Tags() {}

    public Tags(DatabaseHelper helper, String nom){
        tagDAO = new TagDAO(helper);
        this.nom = nom;
    }
    public ForeignCollection<Tag> getTags() {
        return tags;
    }
}
