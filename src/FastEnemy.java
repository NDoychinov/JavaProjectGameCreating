import java.awt.*;
import java.util.Random;

public class FastEnemy extends GameObject {

    Random r =new Random();
    private Handler handler;
    private Image[] imgs = {Assets.blackhole, Assets.theBoss, Assets.asteroid, Assets.asteroidOne, Assets.asteroidGreen};
    private Image rnd;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 2;
        velY = 8;

        rnd = imgs[r.nextInt(5)];
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, rnd, 16, 16, 0.035f, handler));
    }

    public void render(Graphics g) {

    }
}
