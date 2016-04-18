import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage background;
    public static BufferedImage player;
    public static BufferedImage logo;
    public static BufferedImage asteroid;
    public  static BufferedImage blackhole;

    public static void init(){
        background = ImageLoader.loadImage("/background.jpg");
        player = ImageLoader.loadImage("/Player.png");
      //  logo = ImageLoader.loadImage("/GameLogo.png");
      //  asteroid = ImageLoader.loadImage("/Asteroids/Brown.png");
      //  blackhole = ImageLoader.loadImage("/blackhole.png");

    }

}
