package game;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import animation.AnimationRunner;
import animation.EndScreen;
import animation.HighScoresAnimation;
import animation.KeyPressStoppableAnimation;
import animation.WinScreen;
import biuoop.DialogManager;
import biuoop.KeyboardSensor;
import counter.Counter;
import levels.LevelInformation;
/**
 *  This class is in charge of creating the different levels,
 *  and moving from one level to the next.
 *  @author Adi Yanai
 *
 */
public class GameFlow {
   private AnimationRunner animationRunner;
   private KeyboardSensor keyboardSensor;
   private GameEnvironment e;
   private SpriteCollection s;
   private Counter score = new Counter(0); // the start score is 0
   private Counter lives = new Counter(7); // the start number of lives is 7
   private File fileTable;
   private HighScoresTable table;

   /**
    * Constructor.
    * @param ar - an animation runner
    * @param ks - a keyboard
    * @param s - the sprite collection
    * @param e - the game environment
    * @param filename - a file
    * @param table - a high score table
    */
   public GameFlow(AnimationRunner ar, KeyboardSensor ks, SpriteCollection s, GameEnvironment e,
           File filename, HighScoresTable table) {
      this.animationRunner = ar;
      this.keyboardSensor = ks;
      this.s = s;
      this.e = e;
      this.fileTable = filename;
      this.table = table;
      if (this.fileTable.exists()) {
          try {
              this.table.load(filename);
          } catch (Exception ex) {
              System.out.println(ex.getMessage());
          }
      }
   }

   /**
    * run all the levels and keep the score and lives across levels, throughout the entire game.
    * @param levels - a list of all the levels
    */
   public void runLevels(List<LevelInformation> levels) {
      this.score = new Counter(0);
      this.lives = new Counter(7);
      this.s = new SpriteCollection(new ArrayList<Sprite>());
      this.e = new GameEnvironment(new ArrayList<Collidable>());
      // run over all the levels
      for (LevelInformation levelInfo : levels) {

             // create new GameLevel
             GameLevel level = new GameLevel(s, e, levelInfo, this.keyboardSensor, this.score,
                                             this.lives, this.animationRunner);
             // initialize the level
             level.initialize();

             // while level has more blocks and player has more lives
             while (level.getRemainedBlocks().getValue() != 0 && level.getNumOfLives().getValue() > 0) {
                level.playOneTurn();
                // if there is no more balls
                if (level.getNumOfBalls().getValue() == 0) {
                   // decrease the lives by 1
                   this.lives.decrease(1);
                }
             }
             List<Sprite> sprite = new ArrayList<Sprite>();
             this.s = new SpriteCollection(sprite);

             // if there no more lives
             if (level.getNumOfLives().getValue() == 0) {
                // display the end screen
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, new EndScreen(this.score)));
                putScore();
                return;
             }
      }
      this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
              KeyboardSensor.SPACE_KEY, new WinScreen(this.score)));
      putScore();
   }

   /**
    * add a new score to the table score.
    */
   public void putScore() {
          if (this.table.getRank(this.score.getValue()) != -1) {
           // ask the player for his name to put in the table score
           DialogManager dialog = this.animationRunner.getGui().getDialogManager();
           String name = dialog.showQuestionDialog("Name", "What is your name?", "");
           ScoreInfo newScore = new ScoreInfo(name, this.score.getValue());
           // add new score
           this.table.add(newScore);
           try {
               this.table.save(this.fileTable);
              } catch (IOException ex) {
               ex.printStackTrace();
              }
           // show the high score table
           this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                   KeyboardSensor.SPACE_KEY, new HighScoresAnimation(table)));
          }
   }
}