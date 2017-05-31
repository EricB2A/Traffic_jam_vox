package ch.cpnv.vox.traffic_jam.providers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Eric.BOUSBAA on 31.05.2017.
 * Code taken from M.Carrel Github repo.
 */

public class Fonts {

    public static BitmapFont forWelcome;
    public static BitmapFont forSticker;

    public static void load(){

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "abcdefghijklmnopqrstuvwxyzàéèêëùABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?:";
        FreeTypeFontGenerator generator = null;

        generator = new FreeTypeFontGenerator(Gdx.files.internal("pacifico.ttf"));
        parameter.size = 70;
        parameter.color = Color.WHITE;

        forWelcome = generator.generateFont(parameter);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("roboto.ttf"));
        parameter.size = 30;
        parameter.color = Color.WHITE;
        forSticker = generator.generateFont(parameter);
    }
}
