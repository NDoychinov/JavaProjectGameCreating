import javax.swing.*;
import java.awt.*;

/**
 * Created by Niki on 5.4.2016 г..
 */
public class Window extends Canvas{

   public  Window(int width, int height, String title, Game game){
       JFrame frame = new JFrame(title);

       frame.setPreferredSize(new Dimension(width, height));
       frame.setMaximumSize(new Dimension(width, height));
       frame.setMinimumSize(new Dimension(width, height));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
       frame.setLocationRelativeTo(null);
       frame.add(game);
       frame.setVisible(true);
       game.start();
   }
}
