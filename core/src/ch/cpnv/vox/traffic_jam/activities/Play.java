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
    private Car mCar = new Car(3, true, true);
    private ArrayList<Car> mTrucks = new ArrayList<Car>();
    private Grid mGrid = new Grid();
    private ArrayList<Cell> mCells = mGrid.getCells();

    /**
     * Cursor
     */
    private Vector3 mCursor;

    /**
     * Visualisation of the GRID (max is GRID_WIDTH * GRID_HEIGHT)
     * if a value is in a cell, the cell is occupied by a vehicle
     * respectively X and Y values
     */
    public static boolean[][] mPlayground = new boolean[GRID_WIDTH][GRID_HEIGHT];



    public Play() {
        super();
        // define the emplacement of apparition of the playable car
        // which is randomly placed on the grid
        int randomX = (int) randomNumber(0, GRID_WIDTH);
        int randomY = (int) randomNumber(0, GRID_HEIGHT);
        mCar.setPosX(randomX);
        mCar.setPosY(randomY);


        // creates X trucks as obstacle
        for (int x : new int[]{1, 2, 3}){
            // set a new car with a random length (between 1 to 3)
            // and random horizontal/vertical properties
            Car obstacle = new Car((int) randomNumber(2,4), (int) randomNumber(1,2) % 2 == 0);

            //todo is there something here?

            // asset that the random emplacement doesn't exceed the grid size
            do{
                randomX = (int) randomNumber(0, GRID_WIDTH);
                randomY = (int) randomNumber(0, GRID_HEIGHT);
                System.out.println(randomX);
                System.out.println(randomY);
                System.out.println(doesNotExceedBorder(randomX, randomY, obstacle));
            } while(! doesNotExceedBorder(randomX, randomY, obstacle));
            System.out.println("PASSED");
            System.out.println("WITH ");
            System.out.println(randomX);
            System.out.println(randomY);
            System.out.println("===================");
            obstacle.setPosX(randomX);
            obstacle.setPosY(randomY);

            mTrucks.add(obstacle);
        }
    }

    @Override
    protected void handleInput() {
        // make the car element follow the cursor
        mCursor = new Vector3(Gdx.input.getX(), (Gdx.graphics.getHeight()-Gdx.input.getY()), 0);
//        Car selectedVehicule = getSelectedVehicule();
        if(mCar.mHorizontal){
            // assert that the moving car won't go out of the playing grid
            if(doesNotExceedBorder((int) getCellCursorIsInOnX(mCursor.x),(int) getCellCursorIsInOnY(mCursor.y), mCar)){
                // movement 'jump' from cell to cell and is not following the cursor after each pixel
                mCar.setPosX((int) getCellCursorIsInOnX(mCursor.x));
            }
        }
    }

    private float getCellCursorIsInOnX(float cursorPosOnX){
        for(int x = 0 ; x < Play.GRID_WIDTH ; x++){
            float cellPos = GRID_OFFSET_X + (CELL_SIZE * x);
            if(cursorPosOnX > cellPos && cursorPosOnX < (cellPos +  CELL_SIZE)){
                return x;
            }
        }
        // if not found...
        return 0;
    }

    private float getCellCursorIsInOnY(float cursorPosOnY){
        //todo could merge getCellPosOnX and getCellPosOnY
        for(int y = 0 ; y < Play.GRID_HEIGHT ; y++){
            float cellPos = GRID_OFFSET_Y + (CELL_SIZE * y);
            if(cursorPosOnY > cellPos && cursorPosOnY < (cellPos +  CELL_SIZE)){
                return y;
            }
        }
        // if not found
        return 0;
    }

    private boolean doesNotExceedBorder(int currentCellOnX, int currentCellOnY, Car vehicle){
        if(vehicle.mHorizontal){
            return currentCellOnX >= 0 && currentCellOnX <= vehicle.getLength();
        }else{
            return currentCellOnY >= 0 && currentCellOnY <= vehicle.getLength();
        }


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
        // display all the trucks
        for (Car mCar : mTrucks){
            mCar.draw(mSpriteBatch);
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
