import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

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
                game.gameState = Game.STATE.Select;
                return;
            }

            //Credentials Button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Credentials;
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

                game.diff = 0;
            }

            //Hard Button Button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));

                game.diff = 1;
            }

            //Back Button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        //Back Button for credentials
        if (game.gameState == Game.STATE.Credentials) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        //Try Again Button for End of Game
        if (game.gameState == Game.STATE.End) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
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
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.drawImage(ImageLoader.loadImage("PlayButton.png"), 210, 150, 200, 64, null);

            g.drawImage(ImageLoader.loadImage("CredButton.png"), 210, 250, 200, 64, null);

            g.drawImage(ImageLoader.loadImage("QuitButton.png"), 210, 350, 200, 64, null);
        } else if (game.gameState == Game.STATE.Credentials) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Credentials", 180, 70);

            g.setFont(fnt2);
            g.drawString("Created by Team Jakarta", 120, 200);

            g.drawImage(ImageLoader.loadImage("BackButton.png"), 210, 350, 200, 64, null);
        } else if (game.gameState == Game.STATE.End) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 180, 70);

            g.setFont(fnt3);
            g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);

            g.drawImage(ImageLoader.loadImage("TryAgainButton.png"), 210, 350, 200, 64, null);
        } else if (game.gameState == Game.STATE.Select) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("SELECT DIFFICULTY", 75, 70);

            g.drawImage(ImageLoader.loadImage("NormalButton.png"), 210, 150, 200, 64, null);

            g.drawImage(ImageLoader.loadImage("HardButton.png"), 210, 250, 200, 64, null);

            g.drawImage(ImageLoader.loadImage("BackButton.png"), 210, 350, 200, 64, null);
        }
    }
}
