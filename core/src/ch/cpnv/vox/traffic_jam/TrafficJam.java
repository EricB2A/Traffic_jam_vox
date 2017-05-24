
package ch.cpnv.vox.traffic_jam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import ch.cpnv.vox.traffic_jam.activities.Welcome;
import sun.rmi.runtime.Log;

public class TrafficJam extends ApplicationAdapter {

	static public GameActivityManager sGameActivityManager = new GameActivityManager();

	@Override
	public void create(){
		sGameActivityManager.push(new Welcome());
	}

	@Override
	public void render(){
		sGameActivityManager.handleInput();
		sGameActivityManager.update(Gdx.graphics.getDeltaTime());
		sGameActivityManager.render();
	}


	@Override
	public void dispose () {
	}

}
