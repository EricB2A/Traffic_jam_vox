package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Eric on 28.05.17.
 */

public class Vehicule extends Sprite {

    private boolean horizontal;

    public Vehicule(){
        super(new Texture("truck.jpg"));
        init();
    }

    private void init(){

        //TODO set size on globals
        float height = 20;
        float width = 40;
        if (horizontal) {
            setSize(width, height);
        }else{
            setSize(height, width);
        }

    }
}
