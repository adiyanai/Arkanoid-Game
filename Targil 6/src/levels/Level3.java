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
 * Information of level 3.
 * @author Adi Yanai
 *
 */
public class Level3 implements LevelInformation {
    public static final int WIDTH_DRAW_SURFACE = 800; // the width of the drawSurface
    public static final int HEIGHT_DRAW_SURFACE = 600; // the height of the drawSurface

    /**
     * return the number of balls.
     * @return the number of balls
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * The initial velocity of each ball.
     * @return a list of velocities of all the balls
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<Velocity>();
        l.add(Velocity.fromAngleAndSpeed(-80, 480));
        l.add(Velocity.fromAngleAndSpeed(-100, 480));
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
        String levelName = "Blue 3";
        return levelName;
    }

    /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        Sprite background = new Background3();
        return background;
    }

    /**
     * The Blocks that make up this level.
     * @return the Blocks that make up this level
     */
    public List<Block> blocks() {
        // create all the rows of blocks
        return this.createAllTheRows();
    }

    /**
     * the number of blocks to remove(blocks().size()).
     * @return the number of blocks to remove
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    /**
     * create all the rows of blocks.
     * @return list with all the rows of blocks
     */
    public List<Block> createAllTheRows() {
           List<Block> blocksList = new ArrayList<Block>();
           Map<String, Image> imageRow = new TreeMap<String, Image>();
           Map<String, Color> colorRow1 = new TreeMap<String, Color>();
           Map<String, Color> colorRow2 = new TreeMap<String, Color>();
           Map<String, Color> colorRow3 = new TreeMap<String, Color>();
           Map<String, Color> colorRow4 = new TreeMap<String, Color>();
           Map<String, Color> colorRow5 = new TreeMap<String, Color>();
           colorRow1.put("fill", new Color(102, 178, 255));
           colorRow2.put("fill", new Color(102, 255, 178));
           colorRow3.put("fill", new Color(255, 255, 102));
           colorRow4.put("fill", new Color(255, 178, 102));
           colorRow5.put("fill", new Color(255, 102, 102));
           
           // create all the rows
           blocksList.addAll(createRowOfBlocks(10, 1, colorRow1, imageRow));
           blocksList.addAll(createRowOfBlocks(9, 1, colorRow2, imageRow));
           blocksList.addAll(createRowOfBlocks(8, 1, colorRow3, imageRow));
           blocksList.addAll(createRowOfBlocks(7, 1, colorRow4, imageRow));
           blocksList.addAll(createRowOfBlocks(6, 1, colorRow5, imageRow));

           return blocksList;
       }

    /**
     * Create row of blocks.
     * @param numBlocks - the number of blocks in the row
     * @param numHits - the number of hits that the block has
     * @param color - the color of the row of blocks
     * @return - a row of blocks
     */
    public List<Block> createRowOfBlocks(int numBlocks, int numHits, Map<String, Color> colorRow, Map<String, Image> imageRow) {
           List<Block> blocksList = new ArrayList<Block>();
           Point upperLeft;
           Block b;

           // create blocks
           for (int i = 1; i <= numBlocks; i++) {
               upperLeft = new Point(WIDTH_DRAW_SURFACE - 10 - (52 * i),
                                     (HEIGHT_DRAW_SURFACE / 5) + 25 * (12 - numBlocks));
               b = new Block(new Rectangle(upperLeft, 52, 25, colorRow, imageRow, Color.BLACK), numHits);
               b.setStringHits();
               // add a new block to the list
               blocksList.add(b);
           }
           // return a list of row of blocks
           return blocksList;
    }
}
