package ch.cpnv.vox.traffic_jam.activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;

import ch.cpnv.vox.traffic_jam.GameActivity;
import ch.cpnv.vox.traffic_jam.sprites.Car;
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

    /**
     * Objects displayed
     */
    private Car mCar = new Car();
    private ArrayList<Car> mTrucks;
    private Grid mGrid = new Grid();

    /**
     * Cursor
     */
    Vector3 mCursor;

    public Play() {
        super();

        // defines the emplacement of the playable car
        mCar.setPosX((int) randomNumber(0, (int) GRID_WIDTH));
        mCar.setPosY((int) randomNumber(0, (int) GRID_HEIGHT));

    }

    @Override
    protected void handleInput() {
        // make the car element follow the cursor
        mCursor = new Vector3(Gdx.input.getX(), (Gdx.graphics.getHeight()-Gdx.input.getY()), 0);
        mCar.setPosition(mCursor.x - (mCar.getWidth() / 2), mCursor.y - (mCar.getHeight() / 2));
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear the layout

        mSpriteBatch.begin();
        mGrid.draw(mSpriteBatch);
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
