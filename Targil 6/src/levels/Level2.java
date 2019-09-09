package levels;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import geometry.Rectangle;
import game.Sprite;
import geometry.Point;
import geometry.Velocity;
import graphic.Block;
/**
 * Information of level 2.
 * @author Adi Yanai
 *
 */
public class Level2 implements LevelInformation {
    public static final int WIDTH_DRAW_SURFACE = 800; // the width of the drawSurface
    public static final int HEIGHT_DRAW_SURFACE = 600; // the height of the drawSurface

    /**
     * return the number of balls.
     * @return the number of balls
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * The initial velocity of each ball.
     * @return a list of velocities of all the balls
     */
    public List<Velocity> initialBallVelocities() {
        int angle = -40;
        List<Velocity> l = new ArrayList<Velocity>();
        for (int i = 0; i < 10; i++) {
            if (angle == -90) {
                angle -= 10;
            }
            l.add(Velocity.fromAngleAndSpeed(angle, 480));
            angle -= 10;
        }
        return l;
    }

    /**
     * return the paddle speed.
     * @return the paddle speed
     */
    public int paddleSpeed() {
        return 300;
    }

    /**
     * return the paddle width.
     * @return the paddle width
     */
    public int paddleWidth() {
        return 600;
    }

    /**
     * return the level name.
     * @return the level name
     */
    public String levelName() {
        String levelName = "Wide Easy";
        return levelName;
    }

    /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        Sprite background = new Background2();
        return background;
    }

    /**
     * The Blocks that make up this level.
     * @return the Blocks that make up this level
     */
    public List<Block> blocks() {
    	Map<String, Color> colorBlock12 = new TreeMap<String, Color>();
    	Map<String, Color> colorBlock34 = new TreeMap<String, Color>();
    	Map<String, Color> colorBlock56 = new TreeMap<String, Color>();
    	Map<String, Color> colorBlock789 = new TreeMap<String, Color>();
    	Map<String, Color> colorBlock1011 = new TreeMap<String, Color>();
    	Map<String, Color> colorBlock1213 = new TreeMap<String, Color>();
    	Map<String, Color> colorBlock1415 = new TreeMap<String, Color>();
        Map<String, Image> imageBlock = new TreeMap<String, Image>();
        colorBlock12.put("fill", new Color(255, 51, 51));
        colorBlock34.put("fill", new Color(255, 153, 51));
        colorBlock56.put("fill", new Color(255, 255, 102));
        colorBlock789.put("fill", new Color(102, 255, 102));
        colorBlock1011.put("fill", new Color(102, 178, 255));
        colorBlock1213.put("fill", new Color(178, 102, 255));
        colorBlock1415.put("fill", new Color(255, 102, 255));
    	List<Block> blocks = new ArrayList<Block>();
        double width, height;
        width = 52;
        height = 25;
        Block b1 = new Block(new Rectangle(new Point(10, 220), width, height, colorBlock12, imageBlock, Color.BLACK), 1);
        b1.setStringHits();
        blocks.add(b1);
        Block b2 = new Block(new Rectangle(new Point(62, 220), width, height, colorBlock12, imageBlock, Color.BLACK), 1);
        b2.setStringHits();
        blocks.add(b2);
        Block b3 = new Block(new Rectangle(new Point(114, 220), width, height, colorBlock34, imageBlock, Color.BLACK), 1);
        b3.setStringHits();
        blocks.add(b3);
        Block b4 = new Block(new Rectangle(new Point(166, 220), width, height, colorBlock34, imageBlock, Color.BLACK), 1);
        b4.setStringHits();
        blocks.add(b4);
        Block b5 = new Block(new Rectangle(new Point(218, 220), width, height, colorBlock56, imageBlock, Color.BLACK), 1);
        b5.setStringHits();
        blocks.add(b5);
        Block b6 = new Block(new Rectangle(new Point(270, 220), width, height, colorBlock56, imageBlock, Color.BLACK), 1);
        b6.setStringHits();
        blocks.add(b6);
        Block b7 = new Block(new Rectangle(new Point(322, 220), width, height, colorBlock789, imageBlock, Color.BLACK), 1);
        b7.setStringHits();
        blocks.add(b7);
        Block b8 = new Block(new Rectangle(new Point(374, 220), width, height, colorBlock789, imageBlock, Color.BLACK), 1);
        b8.setStringHits();
        blocks.add(b8);
        Block b9 = new Block(new Rectangle(new Point(426, 220), width, height, colorBlock789, imageBlock, Color.BLACK), 1);
        b9.setStringHits();
        blocks.add(b9);
        Block b10 = new Block(new Rectangle(new Point(478, 220), width, height, colorBlock1011, imageBlock, Color.BLACK), 1);
        b10.setStringHits();
        blocks.add(b10);
        Block b11 = new Block(new Rectangle(new Point(530, 220), width, height, colorBlock1011, imageBlock, Color.BLACK), 1);
        b11.setStringHits();
        blocks.add(b11);
        Block b12 = new Block(new Rectangle(new Point(582, 220), width, height, colorBlock1213, imageBlock, Color.BLACK), 1);
        b12.setStringHits();
        blocks.add(b12);
        Block b13 = new Block(new Rectangle(new Point(634, 220), width, height, colorBlock1213, imageBlock, Color.BLACK), 1);
        b13.setStringHits();
        blocks.add(b13);
        Block b14 = new Block(new Rectangle(new Point(686, 220), width, height, colorBlock1415, imageBlock, Color.BLACK), 1);
        b14.setStringHits();
        blocks.add(b14);
        Block b15 = new Block(new Rectangle(new Point(738, 220), width, height, colorBlock1415, imageBlock, Color.BLACK), 1);
        b15.setStringHits();
        blocks.add(b15);

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
