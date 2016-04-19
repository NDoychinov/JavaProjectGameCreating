import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage background;
    public static BufferedImage player;
    public static BufferedImage logo;
    public static BufferedImage asteroid;
    public static BufferedImage blackhole;
    public static BufferedImage asteroidOne;
    public static BufferedImage back;
    public static BufferedImage cred;
    public static BufferedImage hard;
    public static BufferedImage normal;
    public static BufferedImage quit;
    public static BufferedImage tryAgain;
    public static BufferedImage play;
    public static BufferedImage theBoss;
    public static BufferedImage asteroidGreen;

    public static void init() {
        background = ImageLoader.loadImage("/background.jpg");
        player = ImageLoader.loadImage("/Player.png");
        logo = ImageLoader.loadImage("/logo.png");
        asteroid = ImageLoader.loadImage("/asteroids/Brown.png");
        asteroidOne = ImageLoader.loadImage("/asteroids/Grey_1.png");
        asteroidGreen = ImageLoader.loadImage("/asteroids/Green.png");
        blackhole = ImageLoader.loadImage("/asteroids/blackhole.png");
        back = ImageLoader.loadImage("/buttons/BackButton.png");
        cred = ImageLoader.loadImage("/buttons/CredButton.png");
        hard = ImageLoader.loadImage("/buttons/HardButton.png");
        normal = ImageLoader.loadImage("/buttons/NormalButton.png");
        play = ImageLoader.loadImage("/buttons/PlayButton.png");
        quit = ImageLoader.loadImage("/buttons/QuitButton.png");
        tryAgain = ImageLoader.loadImage("/buttons/TryAgainButton.png");
        theBoss = ImageLoader.loadImage("/asteroids/TheBoss.png");


    }

}
