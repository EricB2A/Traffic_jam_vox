package ch.cpnv.vox.traffic_jam.activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Random;

import ch.cpnv.vox.traffic_jam.GameActivity;
import ch.cpnv.vox.traffic_jam.sprites.Car;
import ch.cpnv.vox.traffic_jam.sprites.Cell;
import ch.cpnv.vox.traffic_jam.sprites.Grid;

/**
 * Created by Eric on 27.05.17.
 */

public class Play extends GameActivity {

    /**
     * Numbers of cell in the playable grid
     */
    public static final int GRID_WIDTH = 6;
    public static final int GRID_HEIGHT = 6;

    /**
     * Defines the grid offset and its cell's size
     * The grid is centred to the middle of the screen
     */
    public static final int CELL_SIZE = 150;
    public static final int GRID_OFFSET_X = Gdx.graphics.getWidth() / 2 - ((CELL_SIZE * GRID_WIDTH) / 2);
    public static final int GRID_OFFSET_Y = Gdx.graphics.getHeight() / 2 - ((CELL_SIZE * GRID_HEIGHT) / 2);
    public static final int CELL_OFFSET = 20;

    public static final int VEHICULE_SIZE = CELL_SIZE ;
    /**
     * Objects displayed
     */
    private Car mCar = new Car(3);
    private ArrayList<Car> mTrucks;
    private Grid mGrid = new Grid();
    private ArrayList<Cell> mCells = mGrid.getCells();

    /**
     * Cursor
     */
    Vector3 mCursor;

    public Play() {
        super();
        // define the emplacement of apparition of the playable car
        // which is randomly placed on the grid
        int randomX = (int) randomNumber(0, GRID_WIDTH);
        int randomY = (int) randomNumber(0, GRID_HEIGHT);
        mCar.setPosX(randomX);
        mCar.setPosY(randomY);
    }

    @Override
    protected void handleInput() {
        // make the car element follow the cursor
        mCursor = new Vector3(Gdx.input.getX(), (Gdx.graphics.getHeight()-Gdx.input.getY()), 0);
        if(mCar.mHorizontal){
            mCar.setPosX((int) getCellCursorIsInOnX(mCursor.x));
//            if(doesNotExceedBorderOnX(mCursor.x)){
//
//            }
        }
    }


    private float getCellCursorIsInOnX(float cursorPosOnX){
        for(int x = 0; x < Play.GRID_WIDTH ; x++){
            float cellPos = GRID_OFFSET_X + (CELL_SIZE * x);
            if(cursorPosOnX > cellPos && cursorPosOnX < (cellPos +  CELL_SIZE)){
                return x;
            }
        }

        // if not found...
        return 0
    }

    private boolean doesNotExceedBorderOnX(float cursorX){
        if(cursorX < GRID_OFFSET_X){
            return false;
        }
        else if ((cursorX + mCar.getWidth()) > (GRID_OFFSET_X + (CELL_SIZE * GRID_WIDTH))){
            return false;
        }

        return true;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear the layout

        // display all the needed elements
        mSpriteBatch.begin();
        mGrid.draw(mSpriteBatch);
        for (Cell mCell : mCells){
            mCell.draw(mSpriteBatch);
        }
        mCar.draw(mSpriteBatch);
        mSpriteBatch.end();

    }

    @Override
    public void dispose() {

    }

    private double randomNumber(int min, int max){
        Random ran = new Random();
        return min + (ran.nextDouble() * (max - min));
    }
}
