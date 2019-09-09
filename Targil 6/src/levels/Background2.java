package levels;
import java.awt.Color;
import biuoop.DrawSurface;
import game.Sprite;
/**
 * the background of level 2.
 * @author Adi Yanai
 *
 */
public class Background2 implements Sprite {

    /**
     * draw the sprite to the screen.
     * @param d - the draw surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(204, 255, 255));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        int x = 0;
        // draw sun rays
        int brighter = 0;
        for (int i = 0; i < 80; i++) {
            d.setColor(new Color(250, 230, brighter));
            d.drawLine(130, 100, x, 220);
            x += 10;
            brighter += 2;
        }
        int size = 60;
        int color = 240;
        // draw the sun
        for (int i = 0; i < 30; i++) {
            d.setColor(new Color(250, color, 70));
            d.fillCircle(130, 100, size);
            size -= 3;
            color -= 5;
        }

        // draw hills
        d.setColor(new Color(21, 192, 50));
        d.fillCircle(400, 670, 200);
        d.setColor(new Color(102, 255, 102));
        d.fillCircle(50, 800, 350);
        d.setColor(new Color(30, 215, 61));
        d.fillCircle(750, 800, 350);

        // draw flowers
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                d.setColor(Color.PINK);
                d.fillCircle(35 + (j * 80) + 160 * i, 515 + j * 40, 5);
                d.setColor(Color.PINK);
                d.fillCircle(30 + (j * 80) + 160 * i, 527 + j * 40, 5);
                d.setColor(Color.PINK);
                d.fillCircle(37 + (j * 80) + 160 * i, 523 + j * 40, 5);
                d.setColor(Color.PINK);
                d.fillCircle(23 + (j * 80) + 160 * i, 523 + j * 40, 5);
                d.setColor(Color.PINK);
                d.fillCircle(27 + (j * 80) + 160 * i, 515 + j * 40, 5);
            }
        }

        d.setColor(Color.PINK);
        d.fillCircle(115, 475, 5);
        d.setColor(Color.PINK);
        d.fillCircle(110, 487, 5);
        d.setColor(Color.PINK);
        d.fillCircle(117 , 483, 5);
        d.setColor(Color.PINK);
        d.fillCircle(103 , 483, 5);
        d.setColor(Color.PINK);
        d.fillCircle(107, 475, 5);

        d.setColor(Color.PINK);
        d.fillCircle(755, 475, 5);
        d.setColor(Color.PINK);
        d.fillCircle(750, 487, 5);
        d.setColor(Color.PINK);
        d.fillCircle(757 , 483, 5);
        d.setColor(Color.PINK);
        d.fillCircle(743 , 483, 5);
        d.setColor(Color.PINK);
        d.fillCircle(747, 475, 5);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed(double dt) {
    }
}