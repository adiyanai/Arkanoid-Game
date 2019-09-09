package levels;
import java.awt.Color;
import biuoop.DrawSurface;
import game.Sprite;
/**
 * the background of level 3.
 * @author Adi Yanai
 *
 */
public class Background3 implements Sprite {

    /**
     * draw the sprite to the screen.
     * @param d - the draw surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(153, 204, 255));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        // draw building
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(70, 430, 110, 170);
        d.setColor(Color.GRAY);
        d.fillRectangle(108, 370, 35, 60);
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(120, 180, 10, 190);

        //draw windows
        int width = 75;
        int height = 435;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.setColor(Color.WHITE);
                d.fillRectangle(width, height, 16, 30);
                width += 21;
            }
            width = 75;
            height += 35;
        }

        // draw the circle
        d.setColor(Color.ORANGE);
        d.fillCircle(125, 175, 15);
        d.setColor(Color.RED);
        d.fillCircle(125, 175, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(125, 175, 5);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed(double dt) {
    }
}
