package levels;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import game.Sprite;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import graphic.Block;
/**
 * Information of level 4.
 * @author Adi Yanai
 *
 */
public class Level4 implements LevelInformation {
    public static final int WIDTH_DRAW_SURFACE = 800; // the width of the drawSurface
    public static final int HEIGHT_DRAW_SURFACE = 600; // the height of the drawSurface

    /**
     * return the number of balls.
     * @return the number of balls
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * The initial velocity of each ball.
     * @return a list of velocities of all the balls
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<Velocity>();
        l.add(Velocity.fromAngleAndSpeed(-70, 480));
        l.add(Velocity.fromAngleAndSpeed(-90, 480));
        l.add(Velocity.fromAngleAndSpeed(-110, 480));
        return l;
    }

    /**
     * return the paddle speed.
     * @return the paddle speed
     */
    public int paddleSpeed() {
        return 600;
    }

    /**
     * return the paddle width.
     * @return the paddle width
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * return the level name.
     * @return the level name
     */
    public String levelName() {
        String levelName = "Final Four";
        return levelName;
    }

    /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        Sprite background = new Background4();
        return background;
    }

    /**
     * The Blocks that make up this level.
     * @return the Blocks that make up this level
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        Map<String, Image> imageRow = new TreeMap<String, Image>();
        List<Map<String, Color>> colors = new ArrayList<Map<String, Color>>();
        Map<String, Color> colorRow1 = new TreeMap<String, Color>();
        Map<String, Color> colorRow2 = new TreeMap<String, Color>();
        Map<String, Color> colorRow3 = new TreeMap<String, Color>();
        Map<String, Color> colorRow4 = new TreeMap<String, Color>();
        Map<String, Color> colorRow5 = new TreeMap<String, Color>();
        Map<String, Color> colorRow6 = new TreeMap<String, Color>();
        Map<String, Color> colorRow7 = new TreeMap<String, Color>();
        colorRow1.put("fill", new Color(0, 76, 153));
        colorRow2.put("fill", new Color(0, 102, 204));
        colorRow3.put("fill", new Color(0, 128, 255));
        colorRow4.put("fill", new Color(51, 153, 255));
        colorRow5.put("fill", new Color(102, 178, 255));
        colorRow6.put("fill", new Color(153, 204, 255));
        colorRow7.put("fill", new Color(204, 229, 255));
        
        Block newB;
        int x, y;
        x = 10;
        y = 80;
        colors.add(0, colorRow1);
        colors.add(1, colorRow2);
        colors.add(2, colorRow3);
        colors.add(3, colorRow4);
        colors.add(4, colorRow5);
        colors.add(5, colorRow6);
        colors.add(6, colorRow7);
        

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 15; i++) {
                 newB = new Block(new Rectangle(new Point(x, y), 52, 25, colors.get(j), imageRow, Color.BLACK), 1);
                 blocks.add(newB);
                 x += 52;
            }
            x = 10;
            y += 25;
        }
        return blocks;
    }

    /**
     * the number of blocks to remove(blocks().size()).
     * @return the number of blocks to remove
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}