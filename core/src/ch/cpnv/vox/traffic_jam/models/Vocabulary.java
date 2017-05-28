package ch.cpnv.vox.traffic_jam.models;

import java.util.ArrayList;

/**
 * Created by Eric on 27.05.17.
 */

public class Vocabulary {

    private int mId;
    private String mTitle;
    private ArrayList<Word> mWords;

    public String getTitle(){
        return mTitle;
    }

    public ArrayList<Word> getWords(){
        return mWords;
    }
}
