import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 26) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Assets.asteroid, 26, 26, 0.05f, handler));
    }

    public void render(Graphics g) {
        /*g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);*/
     //   g.drawImage(Assets.asteroid,(int)x, (int)y, 54, 54, null);
    }
}
