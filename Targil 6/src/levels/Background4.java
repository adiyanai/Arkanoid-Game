package levels;
import java.awt.Color;
import biuoop.DrawSurface;
import game.Sprite;
/**
 * the background of level 4.
 * @author Adi Yanai
 *
 */
public class Background4 implements Sprite {

    /**
     * draw the sprite to the screen.
     * @param d - the draw surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(96, 108, 159));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        // draw rain 1
        int x;
        x = 95;
        for (int i = 0; i < 10; i++) {
            d.setColor(new Color(224, 224, 224));
            d.drawLine(x, 400, x - 20, 600);
            x += 10;
        }

        // draw cloud 1
        d.setColor(Color.GRAY);
        d.fillCircle(90, 390, 30);
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(115, 360, 30);
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(185, 390, 25);
        d.setColor(new Color(224, 224, 224));
        d.fillCircle(155, 370, 30);
        d.setColor(new Color(160, 160, 160));
        d.fillCircle(135, 405, 35);

        // draw rain 2
        int y;
        y = 595;
        for (int i = 0; i < 10; i++) {
            d.setColor(new Color(224, 224, 224));
            d.drawLine(y, 450, y - 20, 600);
            y += 10;
        }

        // draw cloud 2
        d.setColor(Color.GRAY);
        d.fillCircle(590, 470, 30);
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(615, 440, 30);
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(685, 470, 25);
        d.setColor(new Color(224, 224, 224));
        d.fillCircle(655, 450, 30);
        d.setColor(new Color(160, 160, 160));
        d.fillCircle(635, 485, 35);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed(double dt) {
    }
}
