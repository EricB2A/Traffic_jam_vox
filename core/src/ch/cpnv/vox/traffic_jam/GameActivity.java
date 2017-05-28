package ch.cpnv.vox.traffic_jam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by Eric.BOUSBAA on 24.05.2017.
 */

public abstract class GameActivity
{
    protected OrthographicCamera mCamera;
    protected SpriteBatch mSpriteBatch;

    protected GameActivity(){
        mCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        mSpriteBatch = new SpriteBatch();
        mSpriteBatch.setProjectionMatrix(mCamera.combined);
        Gdx.gl.glClearColor(0,0,0,0);
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();
}
