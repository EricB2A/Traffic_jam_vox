package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Eric on 27.05.17.
 */

public class Background extends Sprite{
    public Background(){
        super(new Texture("bg2.jpeg"));
        setPosition(-Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2);
        setSize(Gdx.graphics.getHeight()/getTexture().getHeight()*getTexture().getWidth(),Gdx.graphics.getHeight());
    }
}
