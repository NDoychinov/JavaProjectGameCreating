import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public static boolean paused = false;
    public int diff = 0;
    // 0 = Normal
    // 1 = Hard

    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public enum STATE {
        Menu,
        Game,
        Credentials,
        End,
        Select;
    }


    public static STATE gameState = STATE.Menu;

    public Game() {
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);
        Assets.init();

        AudioPlayer.init();

        new Window(WIDTH, HEIGHT, "Space Escape", this);

        spawner = new Spawn(handler, hud, this);
        r = new Random();

        if (gameState == STATE.Game) {
            handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        } else {
            for (int i = 0; i < 10; i++) {
                handler.addObject(new MenuParticle(r.nextInt(WIDTH - 70), r.nextInt(HEIGHT - 70), ID.MenuParticle, handler));
            }
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            try {
                thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {

        if (gameState == STATE.Game) {
            if (!paused) {
                hud.tick();
                spawner.tick();
                handler.tick();

                if (HUD.HEALTH <= 0) {
                    HUD.HEALTH = 100;

                    gameState = STATE.End;
                    AudioPlayer.getMusic("game_over_sound").play();
                    handler.clearEnemys();
                    for (int i = 0; i < 10; i++) {
                        handler.addObject(new MenuParticle(r.nextInt(WIDTH - 70), r.nextInt(HEIGHT - 70), ID.MenuParticle, handler));
                    }
                }
            }
        } else if (gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Credentials) {
            menu.tick();
            handler.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.drawImage(Assets.background,0, 0, WIDTH, HEIGHT, null);

        handler.render(g);


        if (gameState == STATE.Game) {
            hud.render(g);
            if (!paused) {
                g.drawImage(Assets.pauseButton, 530, 20, 64, 64, null);
                g.drawImage(Assets.unmute, 460, 20, 42, 42, null);
            }else{
                g.drawImage(Assets.gameMenu, 200, 100, 250, 300, null);
            }
        } else if (gameState == STATE.Menu || gameState == STATE.Credentials || gameState == STATE.End || gameState == STATE.Select) {
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
