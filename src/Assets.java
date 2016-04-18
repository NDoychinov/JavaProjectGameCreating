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

    public static void init() {
        background = ImageLoader.loadImage("/background.jpg");
        player = ImageLoader.loadImage("/Player.png");
        logo = ImageLoader.loadImage("/logo.png");
        asteroid = ImageLoader.loadImage("/Brown.png");
        asteroidOne = ImageLoader.loadImage("/Grey_1.png");
        blackhole = ImageLoader.loadImage("/blackhole.png");
        back = ImageLoader.loadImage("/BackButton.png");
        cred = ImageLoader.loadImage("/CredButton.png");
        hard = ImageLoader.loadImage("/HardButton.png");
        normal = ImageLoader.loadImage("/NormalButton.png");
        play = ImageLoader.loadImage("/PlayButton.png");
        quit = ImageLoader.loadImage("/QuitButton.png");
        tryAgain = ImageLoader.loadImage("/TryAgainButton.png");
        theBoss = ImageLoader.loadImage("/TheBoss.png");


    }

}
