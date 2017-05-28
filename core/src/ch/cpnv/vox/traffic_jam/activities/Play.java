package ch.cpnv.vox.traffic_jam.activities;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Random;

import ch.cpnv.vox.traffic_jam.GameActivity;
import ch.cpnv.vox.traffic_jam.models.Word;
import ch.cpnv.vox.traffic_jam.sprites.Background;
import ch.cpnv.vox.traffic_jam.sprites.Vehicule;

/**
 * Created by Eric on 27.05.17.
 */

public class Play extends GameActivity {

    public final float GRID_DISTANCE_FROM_TOP = 200;
    public final float GRID_DISTANCE_FROM_LEFT = 200;

    public final float GRID_WIDTH = 200;
    public final float GRID_HEIGHT = 200;

    private ArrayList<Word> mWords;


    public Play() {
        super();

        //mBackground = new Background(); // no need for bg for the moment
        Vehicule truck = new Vehicule();
        truck.setX((float) randomNumber(0, (int) GRID_WIDTH));
        truck.setY((float) randomNumber(0, (int) GRID_HEIGHT));

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }

    private double randomNumber(int min, int max){
        Random ran = new Random();
        return min + (ran.nextDouble() * (max - min));
    }
}
