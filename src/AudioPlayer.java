import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {

    public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    public static Map<String, Music> musicMap = new HashMap<String, Music>();

    public static void init(){
        try {
            soundMap.put("menu_sound", new Sound("resources/sounds/Menu_Click.ogg"));
            musicMap.put("game_over_sound", new Music("resources/sounds/Game_Over.ogg"));
            musicMap.put("game_background_music", new Music("resources/sounds/background_music.ogg"));
            musicMap.put("boss_music", new Music("resources/sounds/Boss_Music.ogg"));


        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

    public static Music getMusic(String key) {
        return musicMap.get(key);
    }

    public static Sound getSound(String key){
        return soundMap.get(key);
    }
}
