import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject {

    Random r = new Random();
    private Handler handler;
    private Image[] imgs = {Assets.blackhole, Assets.theBoss, Assets.asteroid, Assets.asteroidOne, Assets.asteroidGreen};
    private Image rnd;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 5;
        velY = 5;

        rnd = imgs[r.nextInt(5)];
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 26) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, rnd, 26, 26, 0.05f, handler));
    }

    public void render(Graphics g) {

    }
}
