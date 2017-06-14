package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.vox.traffic_jam.activities.Play;

/**
 * Created by Eric.BOUSBAA on 31.05.2017.
 */


public class Car extends Sprite{



    // grid coordinates, not pixels
    private int mPosX;
    private int mPosY;
    private int mLength;

    // is it the main car aka the red car
    private boolean mPlayer = false;

    // is it displayed horizontally or vertically
    public boolean mHorizontal = true;

    public Car(int length, boolean horizontal ,boolean player){
        super(new Texture("red.jpg"));
        this.mLength = length;
        this.mHorizontal = horizontal;
        init();
        if(player){
            this.mPlayer = true;
        }
    }

    public Car(int length, boolean horizontal){
        super(new Texture("truck.jpg"));
        this.mHorizontal = horizontal;
        this.mLength = length;
        init();
    }

    private void init(){
        if (this.mHorizontal){
            setSize((Play.VEHICULE_SIZE * this.mLength) - Play.CELL_OFFSET, Play.VEHICULE_SIZE - Play.CELL_OFFSET);
        }else{
            setSize((Play.VEHICULE_SIZE - Play.CELL_OFFSET), (Play.VEHICULE_SIZE * this.mLength) - Play.CELL_OFFSET);
        }
    }

    public void setPosX(int posX) {


        // set the new position in pixels
        setX(Play.GRID_OFFSET_X + (posX * Play.CELL_SIZE));

        // if we did a movement on this axe
        // update the playground arrays
        if(mHorizontal){
            for(int x = 0 ; x < mLength ; x ++){
                
                if(x + this.mPosX <= Play.GRID_WIDTH){
                    // remove precedent playground position
                    Play.mPlayground[x + this.mPosX][mPosY] = false;
                    // and set the new one
                    Play.mPlayground[x + posX][mPosY] = true;
                }
            }
        }

        // assign class property
        this.mPosX = posX;


    }

    public void setPosY(int posY) {
        // remove precedent playground position


        setY(Play.GRID_OFFSET_Y + (posY * Play.CELL_SIZE));
        this.mPosY = posY;

        Play.mPlayground[this.mPosX][posY] = true;


    }

    public int getLength(){
        return this.mLength;
    }
}
