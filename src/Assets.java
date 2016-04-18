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

    public static void init(){
        background = ImageLoader.loadImage("/background.jpg");
        player = ImageLoader.loadImage("/Player.png");
      //  logo = ImageLoader.loadImage("/GameLogo.png");
        asteroid = ImageLoader.loadImage("/Asteroids/Brown.png");
        asteroidOne = ImageLoader.loadImage("/Asteroids/Grey_1.png");
        blackhole = ImageLoader.loadImage("/blackhole.png");
        back = ImageLoader.loadImage("/buttons/BackButton.png");
        cred = ImageLoader.loadImage("/buttons/CredButton.png");
        hard = ImageLoader.loadImage("/buttons/HardButton.png");
        normal = ImageLoader.loadImage("/buttons/NormalButton.png");
        play = ImageLoader.loadImage("/buttons/PlayButton.png");
        quit = ImageLoader.loadImage("/buttons/QuitButton.png");
        tryAgain = ImageLoader.loadImage("/buttons/TryAgainButton.png");



    }

}
