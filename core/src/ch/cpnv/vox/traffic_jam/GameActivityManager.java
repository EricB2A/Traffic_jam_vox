package ch.cpnv.vox.traffic_jam;

import java.util.Stack;

/**
 * Created by Eric.BOUSBAA on 24.05.2017.
 */

public class GameActivityManager {
    private Stack<GameActivity> mGameActivities;

    public GameActivityManager() {
        mGameActivities = new Stack<GameActivity>();
    }

    public void push(GameActivity gameActivity) {
        mGameActivities.push(gameActivity);
    }

    public void pop() {
        mGameActivities.pop().dispose();
    }

    public void set(GameActivity gameActivity) {
        mGameActivities.pop();
        mGameActivities.push(gameActivity);
    }

    public void handleInput() {
        mGameActivities.peek().handleInput();
    }

    public void update(float dt) {
        mGameActivities.peek().update(dt);
    }

    public void render() {
        mGameActivities.peek().render();
    }
}
