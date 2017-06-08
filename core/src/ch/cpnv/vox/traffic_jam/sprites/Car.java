package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.vox.traffic_jam.activities.Play;

/**
 * Created by Eric.BOUSBAA on 31.05.2017.
 */


public class Car extends Sprite{

    public boolean mHorizontal = true;
    // grid coordinates, not pixels
    private int mPosX;
    private int mPosY;
    private int mLength;

    public Car(int length){
        super(new Texture("red.jpg"));
        this.mLength = length;
        init();
    }

    private void init(){

        float height = 300;
        float width = 100;
        if (mHorizontal){
            setSize(Play.VEHICULE_SIZE * this.mLength, Play.VEHICULE_SIZE - Play.CELL_OFFSET);
        }else{
            setSize(Play.VEHICULE_SIZE - Play.CELL_OFFSET, Play.VEHICULE_SIZE * this.mLength);
        }
    }

    public void setHorizontal(boolean horizontal) {
        this.mHorizontal = horizontal;
    }

    public void setPosX(int posX) {

        setX(Play.GRID_OFFSET_X + (posX * Play.CELL_SIZE));
    }

    public void setPosY(int posY) {
        setY(Play.GRID_OFFSET_Y +
                (posY * Play.CELL_SIZE));
    }
}
