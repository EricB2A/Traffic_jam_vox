package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import ch.cpnv.vox.traffic_jam.activities.Play;

/**
 * Created by Eric.BOUSBAA on 01.06.2017.
 */

public class Grid extends Sprite {

    ArrayList<Cell> mCells = new ArrayList<Cell>();

    public Grid(){
        super(new Texture("grey.jpg"));
        init();
    }

    private void init(){
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
        for(int x=0 ; x < Play.GRID_WIDTH ; x++){
            for(int y=0 ; y < Play.GRID_HEIGHT ; y++){
                Cell cell = new Cell(Play.CELL_SIZE - Play.CELL_OFFSET , Play.CELL_SIZE - Play.CELL_OFFSET);

                cell.setPosX(gridOffsetX + (x * cellSizeX) );
                cell.setPosY(gridOffsetY + (y * cellSizeY) );
                mCells.add(cell);
            }
        }
        System.out.println(mCells);
        return mCells;
    }

}
