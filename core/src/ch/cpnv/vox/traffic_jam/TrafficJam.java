
package ch.cpnv.vox.traffic_jam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sun.rmi.runtime.Log;

public class TrafficJam extends ApplicationAdapter {
    private final float INITIAL_SPEED = 200; // use float for pixels

    SpriteBatch batch;
    Sprite mLogo;
    float mHorizontalSpeed = INITIAL_SPEED;
    float mVerticalSpeed = INITIAL_SPEED;

	@Override
	public void create () {
		batch = new SpriteBatch();
        mLogo = new Sprite(new Texture("badlogic.jpg"));
		//img = new Texture("badlogic.jpg");
	}

    /**
     *
     */
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//
		update(Gdx.graphics.getDeltaTime());
		//
		batch.begin();
        mLogo.draw(batch); // group d'opérations
        //mLogo.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}

	public void update(float dt){
        mVerticalSpeed -= 2;
        mLogo.translate(mHorizontalSpeed*dt, mVerticalSpeed*dt);
    }
}
