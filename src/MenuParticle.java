import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {
    private Handler handler;

    Random r = new Random();

    private Image[] imgs = {Assets.blackhole, Assets.theBoss, Assets.asteroid, Assets.asteroidOne, Assets.asteroidGreen};
    private Image rnd;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = (r.nextInt(7 - -7) + -7);
        velY = (r.nextInt(7 - -7) + -7);
        if (velX == 0) velX = 1;
        if (velY == 0) velY = 1;

        rnd = imgs[r.nextInt(5)];

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 55) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 35) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, rnd, 32, 32, 0.02f, handler));
    }

    public void render(Graphics g) {
    }
}
