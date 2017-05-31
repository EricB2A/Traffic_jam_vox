package ch.cpnv.vox.traffic_jam.activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;
import java.util.Random;

import ch.cpnv.vox.traffic_jam.GameActivity;
import ch.cpnv.vox.traffic_jam.models.Word;
import ch.cpnv.vox.traffic_jam.sprites.Background;
import ch.cpnv.vox.traffic_jam.sprites.Car;
import ch.cpnv.vox.traffic_jam.sprites.Truck;

/**
 * Created by Eric on 27.05.17.
 */

public class Play extends GameActivity {

    public final float GRID_DISTANCE_FROM_TOP = 200;
    public final float GRID_DISTANCE_FROM_LEFT = 200;

    public final float GRID_WIDTH = 200;
    public final float GRID_HEIGHT = 200;

    private ArrayList<Word> mWords;

    Car mCar = new Car();
    Truck mTruck = new Truck();

    public Play() {
        super();

        //mBackground = new Background(); // no need for bg for the moment
        mCar.setX((float) randomNumber(0, (int) GRID_WIDTH));
        mCar.setY((float) randomNumber(0, (int) GRID_HEIGHT));

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear the layout

        mSpriteBatch.begin();
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
