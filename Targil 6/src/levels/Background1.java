package levels;
import java.awt.Color;
import biuoop.DrawSurface;
import game.Sprite;
/**
 * the background of level 1.
 * @author Adi Yanai
 *
 */
public class Background1 implements Sprite {
    /**
     * draw the sprite to the screen.
     * @param d - the draw surface
     */
    public void drawOn(DrawSurface d) {
        int radius = 60;
        // create the circles
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLUE);
        d.drawLine((d.getWidth() / 2) - 140, (d.getHeight() / 4) + 15,
                   (d.getWidth() / 2) + 140, (d.getHeight() / 4) + 15);
        d.drawLine(d.getWidth() / 2, (d.getHeight() / 4) + 15 - 140, d.getWidth() / 2, (d.getHeight() / 4) + 15 + 140);
        int color = 0;
        for (int i = 0; i < 8; i++) {
            d.setColor(new Color(0, color, 255));
            d.drawCircle(d.getWidth() / 2, (d.getHeight() / 4) + 15, radius);
            radius += 10;
            color += 30;
        }
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed(double dt) {
    }
}
