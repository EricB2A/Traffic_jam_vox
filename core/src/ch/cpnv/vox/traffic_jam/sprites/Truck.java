package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Eric on 28.05.17.
 */

public class Truck extends Sprite {

    private boolean horizontal;

    public Truck(){
        super(new Texture("truck.jpg"));

        init();
    }

    private void init(){

        //TODO set size on globals
        float height = 300;
        float width = 100;
        if (horizontal) {
            setSize(width, height);
        }else{
            setSize(height, width);
        }

    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
}
