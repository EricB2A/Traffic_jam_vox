package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Eric.BOUSBAA on 31.05.2017.
 */

public class Car extends Sprite{

    private boolean horizontal;

    public Car(){
        super(new Texture("red.jpg"));

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
