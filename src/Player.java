import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;
    Image playerImg = ImageLoader.loadImage("Player.png");

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 55);
        y = Game.clamp(y, -10, Game.HEIGHT - 75);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    AudioPlayer.getSound("collision_sound").play(1.1f, 0.2f);
                    HUD.HEALTH -= 2;
                }
            }
            if (tempObject.getId() == ID.BossEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    AudioPlayer.getSound("collision_sound").play(1.1f, 0.2f);
                    HUD.HEALTH = 0;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x, (int)y, 55, 55, null);
    }


}
