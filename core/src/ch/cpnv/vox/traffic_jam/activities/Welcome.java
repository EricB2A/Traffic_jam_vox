package ch.cpnv.vox.traffic_jam.activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.sun.org.apache.xpath.internal.SourceTree;

import ch.cpnv.vox.traffic_jam.GameActivity;
import ch.cpnv.vox.traffic_jam.providers.GlobalStorage;
import ch.cpnv.vox.traffic_jam.sprites.Background;
import ch.cpnv.vox.traffic_jam.sprites.Text;

/**
 * Starts screen.
 */

public class Welcome extends GameActivity{

    private Background mBackground1 = new Background();
    private Text mTextWelcome = new Text("Welcome on board !");
    private Text mTextJouer = new Text("Appuyez pour jouer");

    public Welcome(){
        super();

        System.out.println("Bienvenu");

    }
    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        // put welcome texts in the "middle" of the screen
        mTextWelcome.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/2);
        mTextJouer.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/2 - 100);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mSpriteBatch.begin();
        mBackground1.draw(mSpriteBatch);
        mTextWelcome.draw(mSpriteBatch);
        mTextJouer.draw(mSpriteBatch);
        mSpriteBatch.end();
    }

    @Override
    public void dispose() {

    }

    /**
            * Async load of vocabulary, which is stored in GlobalStorage.
            * The id of the voc to load is in GlobalStorage
     */
    public void loadVoc() {
//        if (GlobalStorage.vocid == 0) // App was not started from Vox -> no voc id has been passed -> demo mode with hardcoded vocabulary
//        {
//            loadHardcodedVoc();
//            return;
//        }
//        Request request = new Request.Builder().url(URL_API+GlobalStorage.vocid).build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override public void onFailure(Request request1, IOException e) { // go with hardcoded voc in case of problems
//                loadHardcodedVoc();
//            }
//
//            @Override public void onResponse(Response response) throws IOException {
//                if (!response.isSuccessful()) { // go with hardcoded voc in case of problems
//                    loadHardcodedVoc();
//                }
//                else // Parse json
//                {
//                    Gson gson = new Gson();
//                    GlobalStorage.theVoc = gson.fromJson(response.body().string(), Vocabulary.class);
//                    mTextWelcome.setText("Joue " + GlobalStorage.theVoc.getTitle());
//                }
//            }
//        });
    }
}
