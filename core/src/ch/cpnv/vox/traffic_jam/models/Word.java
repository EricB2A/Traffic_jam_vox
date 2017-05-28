package ch.cpnv.vox.traffic_jam.models;

/**
 * Created by Eric on 27.05.17.
 */

public class Word {

    private int mId;
    private String mValue1;
    private String mValue2;

    public Word(String value1, String value2){
        mValue1 = value1;
        mValue2 = value2;
    }

    public String getValue1(){
        return mValue1;
    }

    public String getValue2(){
        return mValue2;
    }

    public int getId(){
        return mId;
    }
}
