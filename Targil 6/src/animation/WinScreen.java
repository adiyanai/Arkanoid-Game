package animation;
import java.awt.Color;
import java.util.Random;

import biuoop.DrawSurface;
import counter.Counter;
/**
 * the win screen display the message "You Win! Your score is X",
 * if the player clearing all the levels.
 * @author Adi Yanai
 *
 */
public class WinScreen implements Animation {
    private boolean stop;
    private Counter finalScore;
    /**
     * Constructor.
     * @param finalScore - the final score of the player
     */
    public WinScreen(Counter finalScore) {
        this.stop = false;
        this.finalScore = finalScore;
    }

    /**
     * draw the win screen.
     * @param d - the draw surface
     * @param dt - frames per second
     */
    public void doOneFrame(DrawSurface d, double dt) {
        Random rand = new Random();
        d.setColor(new Color(255, 255, 153));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        // draw random blocks
        for (int i = 0; i < 15; i++) {
             d.setColor(new Color(rand.nextInt(250), rand.nextInt(250) , rand.nextInt(250)));
             d.fillRectangle(rand.nextInt(748), rand.nextInt(575), 52, 25);
        }

        d.setColor(Color.BLACK);
        d.drawText(65, d.getHeight() / 2 - 80, "YOU WIN!", 150);
        d.drawText(d.getWidth() / 2 - 220, d.getHeight() / 2 + 130, "Your score is: " + this.finalScore.getValue(), 60);
    }

    /**
     * change a boolean variable when we want to stop the animation.
     * @return true or false
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
