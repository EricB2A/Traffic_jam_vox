
package ch.cpnv.vox.traffic_jam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import ch.cpnv.vox.traffic_jam.activities.Play;
import ch.cpnv.vox.traffic_jam.activities.Welcome;

import ch.cpnv.vox.traffic_jam.providers.Fonts;


public class TrafficJam extends ApplicationAdapter {

	static public GameActivityManager sGameActivityManager = new GameActivityManager();

	@Override
	public void create(){
		Fonts.load();
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
