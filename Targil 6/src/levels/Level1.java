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
 * Information of level 1.
 * @author Adi Yanai
 *
 */
public class Level1 implements LevelInformation {
    public static final int WIDTH_DRAW_SURFACE = 800; // the width of the drawSurface
    public static final int HEIGHT_DRAW_SURFACE = 600; // the height of the drawSurface

    /**
     * return the number of balls.
     * @return the number of balls
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * The initial velocity of each ball.
     * @return a list of velocities of all the balls
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<Velocity>();
        l.add(Velocity.fromAngleAndSpeed(-90, 480));
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
        String levelName = "Direct Hit";
        return levelName;
    }

    /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        Sprite background = new Background1();
        return background;
    }

    /**
     * The Blocks that make up this level.
     * @return the Blocks that make up this level
     */
    public List<Block> blocks() {
    	Map<String, Color> colorBlock = new TreeMap<String, Color>();
        Map<String, Image> imageBlock = new TreeMap<String, Image>();
        colorBlock.put("fill", new Color(0, 240, 255));
    	List<Block> blocks = new ArrayList<Block>();
        Point upperLeft = new Point((WIDTH_DRAW_SURFACE / 2) - 15, HEIGHT_DRAW_SURFACE / 4);
        Block b = new Block(new Rectangle(upperLeft, 30, 30, colorBlock, imageBlock, Color.BLACK), 1);
        b.setStringHits();
        blocks.add(b);
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