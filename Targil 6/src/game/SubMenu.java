package game;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import animation.MenuAnimation;
import biuoop.KeyboardSensor;
/**
 * represent a sub menu.
 * @author Adi Yanai
 * @param <T>
 */
public class SubMenu<T> {
    private LinkedHashMap<String, String> selection = new LinkedHashMap<>();
    private List<String> path = new ArrayList<>();
    /**
     * create a sub menu by reading a sub menu file and convert it to sub menu.
     * @param reader - a file reader
     * @param keyboard - a keyboard
     * @return a sub menie
     */
    public Menu<T> fromReader(java.io.Reader reader, KeyboardSensor keyboard) {
        LineNumberReader lineReader = new LineNumberReader(reader);
        String currentLine;
        try {
            currentLine = lineReader.readLine();
            while (currentLine != null) {
                // Odd-numbered lines are level names
                if (lineReader.getLineNumber() % 2 == 1) {
                    String[] split = currentLine.split(":");
                    selection.put(split[0], split[1]);
                  // Even-numbered lines are the corresponding filenames
                } else {
                    path.add(currentLine);
                }
                currentLine = lineReader.readLine();
            }

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        // create a sub menue
        Menu subMenu = new MenuAnimation(keyboard, "Choose");
        int i = 0;
        for (Map.Entry<String, String> set : selection.entrySet()) {
            subMenu.addSelection(set.getKey(), set.getValue(), path.get(i));
            i++;
        }
        // return sub menu
        return subMenu;
    }
}