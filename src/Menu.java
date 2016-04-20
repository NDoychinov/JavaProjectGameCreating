import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public static boolean mute = false;

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == Game.STATE.Menu) {
            //Play Button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                AudioPlayer.getSound("menu_sound").play();
                game.gameState = Game.STATE.Select;
                return;
            }

            //Credentials Button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Credentials;
                AudioPlayer.getSound("menu_sound").play();

            }

            //Quit Button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }

        if (game.gameState == Game.STATE.Select) {
            //Normal Button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                AudioPlayer.getSound("menu_sound").play();
                AudioPlayer.getMusic("game_background_music").play();
                game.diff = 0;
            }

            //Hard Button Button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                AudioPlayer.getSound("menu_sound").play();
                AudioPlayer.getMusic("game_background_music").play();
                game.diff = 1;
            }

            //Back Button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }
        }

        //Back Button for credentials
        if (game.gameState == Game.STATE.Credentials) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }
        }

        //Try Again Button for End of Game
        if (game.gameState == Game.STATE.End) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                hud.setLevel(1);
                hud.setScore(0);
            }
        }

        if (game.gameState == Game.STATE.Game) {
            //Pause button
            if (mouseOver(mx, my, 590, 15, 32, 32)) {
                if (!Game.paused) {
                    Game.paused = true;
                    AudioPlayer.getSound("menu_sound").play();
                    AudioPlayer.getMusic("game_background_music").pause();
                }
            }
            //Volume button
            if (mouseOver(mx, my, 540, 10, 42, 42)) {
                if (!Game.paused) {
                    if (hud.getLevel() % 10 == 0) {
                        if (!mute) {
                            mute = true;
                            AudioPlayer.getMusic("boss_music").pause();

                        } else {
                            mute = false;
                            AudioPlayer.getMusic("boss_music").play();
                        }
                    } else {
                        if (!mute) {
                            mute = true;
                            AudioPlayer.getMusic("game_background_music").pause();
                        } else {
                            mute = false;
                            AudioPlayer.getMusic("game_background_music").resume();
                        }
                    }
                }
            }

            if (mouseOver(mx, my, 255, 145, 140, 55) && Game.paused) {
                Game.paused = false;
                AudioPlayer.getSound("menu_sound").play();
                if (!mute) {
                    AudioPlayer.getMusic("game_background_music").resume();
                }
            }

            if (mouseOver(mx, my, 255, 222, 140, 55) && Game.paused) {
                Game.gameState = Game.STATE.End;
                handler.clearEnemys();
                Game.gameState = Game.STATE.Menu;
                HUD.HEALTH = 100;
                hud.setLevel(1);
                hud.setScore(0);
                AudioPlayer.getSound("menu_sound").play();
                mute = false;

                Game.paused = false;
                AudioPlayer.getMusic("start_music").play();
                for (int i = 0; i < 10; i++) {
                    handler.addObject(new MenuParticle(r.nextInt(590), r.nextInt(420), ID.MenuParticle, handler));
                }
            }

            if (mouseOver(mx, my, 255, 300, 140, 55) && Game.paused) {
                System.exit(1);
            }
        }

    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        if (game.gameState == Game.STATE.Menu) {

            g.drawImage(Assets.logo, 120, -90, 380, 280, null);

            g.drawImage(Assets.play, 210, 150, 200, 64, null);

            g.drawImage(Assets.cred, 210, 250, 200, 64, null);

            g.drawImage(Assets.quit, 210, 350, 200, 64, null);

        } else if (game.gameState == Game.STATE.Credentials) {
            g.drawImage(Assets.team, 110, 20, 420, 70, null);

            g.drawImage(Assets.krum, 185, 100, 260, 50, null);
            g.drawImage(Assets.nikolay, 185, 160, 260, 50, null);
            g.drawImage(Assets.stoqn, 185, 220, 260, 50, null);
            g.drawImage(Assets.todor, 185, 280, 260, 50, null);

            g.drawImage(Assets.back, 210, 350, 200, 64, null);

        } else if (game.gameState == Game.STATE.End) {
            Font fnt = new Font("Consolas", 1, 23);

            g.drawImage(Assets.gameOver, 170, 50, 300, 70, null);

            g.setColor(Color.black);
            g.setFont(fnt);
            g.drawString("You lost with a score of: " + hud.getScore(), 110, 230);

            g.drawImage(Assets.tryAgain, 210, 350, 200, 64, null);
        } else if (game.gameState == Game.STATE.Select) {
            g.drawImage(Assets.select, 110, 35, 420, 70, null);

            g.drawImage(Assets.normal, 210, 150, 200, 64, null);
            g.drawImage(Assets.hard, 210, 250, 200, 64, null);
            g.drawImage(Assets.back, 210, 350, 200, 64, null);
        }
    }
}
