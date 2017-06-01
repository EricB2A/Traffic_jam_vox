package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.vox.traffic_jam.activities.Play;

/**
 * Created by Eric.BOUSBAA on 01.06.2017.
 */

public class Grid extends Sprite {
    public Grid(){
        super(new Texture("grey.jpg"));
        // number of cell * cell size

        init();
    }

    private void init(){
        System.out.println(Play.CELL_SIZE * Play.GRID_WIDTH);
        System.out.println(Play.CELL_SIZE * Play.GRID_WIDTH);
        setSize(Play.CELL_SIZE * Play.GRID_WIDTH, Play.CELL_SIZE * Play.GRID_HEIGHT);
        setPosition(Play.GRID_OFFSET_X, Play.GRID_OFFSET_Y);
    }

}
