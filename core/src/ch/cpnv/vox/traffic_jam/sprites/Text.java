package ch.cpnv.vox.traffic_jam.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import ch.cpnv.vox.traffic_jam.providers.Fonts;

/**
 * Created by Eric.BOUSBAA on 29.05.2017.
 * Code taken from M.Carrel Github repo.
 */

public class Text extends Sprite {

    private final float mPadding = 10;
    private String mText;
    private float mBoxHeight;
    private float mBoxWidth;

    public void setText(String text) {
        mText = text;
        BitmapFont font = Fonts.forWelcome;
        GlyphLayout layout = new GlyphLayout(font, text);
        mBoxHeight=layout.height+2*mPadding;
        mBoxWidth=layout.width+2*mPadding;
        setSize(mBoxWidth,mBoxHeight);

    }

    public Text(String text) {
        super(new Texture("black.jpg"));
        setText(text);

    }

    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);

        Fonts.forWelcome.draw(spriteBatch, mText, getX()+mPadding, getY()+mBoxHeight-mPadding);
    }
}
