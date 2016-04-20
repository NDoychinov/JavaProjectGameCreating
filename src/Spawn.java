import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Game game;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (game.diff == 0) {
                if (hud.getLevel() == 1){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                }else if (hud.getLevel() == 2){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                }else if (hud.getLevel() == 5){
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                }else if (hud.getLevel() == 8){
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                }else if(hud.getLevel() % 10 == 0){
                        handler.clearEnemys();
                if (!Menu.mute) {
                    AudioPlayer.getMusic("game_background_music").pause();
                    AudioPlayer.getMusic("boss_music").play();
                }else {
                    AudioPlayer.getMusic("boss_music").pause();
                    AudioPlayer.getMusic("game_background_music").play();
                }
                handler.addObject(new BossEnemy((Game.WIDTH / 2) - 48, -170, ID.BossEnemy, handler));
            } else if(hud.getLevel() >= 15 && hud.getLevel() % 10 == 5){
                    handler.clearEnemys();
                    if (!Menu.mute) {
                        AudioPlayer.getMusic("boss_music").stop();
                        AudioPlayer.getMusic("game_background_music").play();
                    }else{
                        AudioPlayer.getMusic("boss_music").pause();
                        AudioPlayer.getMusic("game_background_music").play();
                    }
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if(hud.getLevel() >= 17 && hud.getLevel() % 10 == 7){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if(hud.getLevel() >= 18 && hud.getLevel() % 10 == 8){
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                }
            } else if (game.diff == 1) {
                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 10) {
                    handler.clearEnemys();
                    if (!Menu.mute) {
                        AudioPlayer.getMusic("game_background_music").stop();
                        AudioPlayer.getMusic("boss_music").play();
                    }else {
                        AudioPlayer.getMusic("boss_music").pause();
                        AudioPlayer.getMusic("game_background_music").play();
                    }
                    handler.addObject(new BossEnemy((Game.WIDTH / 2) - 48, -170, ID.BossEnemy, handler));
                } else if (hud.getLevel() == 15) {
                    if (!Menu.mute) {
                        AudioPlayer.getMusic("boss_music").stop();
                        AudioPlayer.getMusic("game_background_music").play();
                    }else{
                        AudioPlayer.getMusic("boss_music").pause();
                        AudioPlayer.getMusic("game_background_music").play();
                    }
                    handler.clearEnemys();
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 16) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 18) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 20) {
                    handler.clearEnemys();
                    if (!Menu.mute) {
                        AudioPlayer.getMusic("game_background_music").stop();
                        AudioPlayer.getMusic("boss_music").play();
                    }else{
                        AudioPlayer.getMusic("boss_music").pause();
                        AudioPlayer.getMusic("game_background_music").play();
                    }
                    handler.addObject(new BossEnemy((Game.WIDTH / 2) - 300, -170, ID.BossEnemy, handler));
                    handler.addObject(new BossEnemy((Game.WIDTH / 2) + 100, -170, ID.BossEnemy, handler));
                } else if (hud.getLevel() == 24) {
                    if (!Menu.mute) {
                        AudioPlayer.getMusic("boss_music").stop();
                        AudioPlayer.getMusic("game_background_music").play();
                    }else{
                        AudioPlayer.getMusic("boss_music").pause();
                        AudioPlayer.getMusic("game_background_music").play();
                    }
                    handler.clearEnemys();
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 25) {
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 27) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 30) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                }
            }
        }
    }
}
