package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import ch.cpnv.vox.traffic_jam.activities.Play;

/**
 * Created by Eric.BOUSBAA on 01.06.2017.
 */

public class Grid extends Sprite {

    ArrayList<Cell> mCells;

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

    public ArrayList<Cell> getCells(){
        // get the constant
        int cellSizeX = Play.CELL_SIZE;
        int cellSizeY = Play.CELL_SIZE;
        int gridOffsetX = Play.GRID_OFFSET_X;
        int gridOffsetY = Play.GRID_OFFSET_Y;

        // create the cells and store them in arrayList
        for(int x=1 ; x <= Play.GRID_WIDTH ; x++){
            for(int y=1 ; y <= Play.GRID_HEIGHT ; y++){
                Cell cell = new Cell(Play.CELL_SIZE, Play.CELL_SIZE);
                cell.setPosX(gridOffsetX + (x * cellSizeX));
                cell.setPosY(gridOffsetY + (y * cellSizeY));
                mCells.add(cell);
            }
        }

        return mCells;
    }

}
