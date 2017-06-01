package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.vox.traffic_jam.activities.Play;

/**
 * Created by Eric.BOUSBAA on 31.05.2017.
 */

public class Car extends Sprite{

    private boolean mHorizontal;
    private int mPosX;
    private int mPosY;


    public Car(){
        super(new Texture("red.jpg"));

        init();
    }

    private void init(){

        //TODO set size on globals
        float height = 300;
        float width = 100;
        if (mHorizontal) {
            setSize(width, height);
        }else{
            setSize(height, width);
        }

    }

    public void setHorizontal(boolean horizontal) {
        this.mHorizontal = horizontal;
    }

    public void setPosX(int posX) {
        mPosX = posX;
        setX(Play.GRID_OFFSET_X + (posX * Play.CELL_SIZE));

    }

    public void setPosY(int posY) {
        mPosY = posY;
        setY(Play.GRID_OFFSET_Y + (posY * Play.CELL_SIZE));
    }
}
