package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.vox.traffic_jam.activities.Play;

/**
 * Created by Eric.BOUSBAA on 01.06.2017.
 */

public class Cell extends Sprite {

    private int mPosX;
    private int mPosY;

    public Cell(int width, int height){
        super(new Texture("lightgrey.png"));
        setPosition(width, height);
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
