package pt.up.fe.bomberman.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> levels;
    private List<String> options;

    private int currentLevel = 0;
    private int currentOption = 0;

    public Menu() {
        this.levels = Arrays.asList("EASY", "KINDA EASY", "NOT EASY", "HARD MODE");
        this.options = Arrays.asList("START", levels.get(0), "EXIT");
    }

    public void nextOption() {
        currentOption++;
        if (currentOption > this.options.size() - 1)
            currentOption = 0;
    }

    public void previousOption() {
        currentOption--;
        if (currentOption < 0)
            currentOption = this.options.size() - 1;
    }
    public void previousLevel() {
        currentLevel--;
        if (currentLevel < 0)
            currentLevel = this.levels.size() - 1;
        options.set(1, levels.get(currentLevel));
    }

    public void nextLevel() {
        currentLevel++;
        if (currentLevel > this.levels.size() - 1)
            currentLevel = 0;
        options.set(1, levels.get(currentLevel));
    }

    public String getOption(int i) {
        return options.get(i);
    }

    public int getLevel(){
        return currentLevel;
    }

    public boolean isSelected(int i) {
        return currentOption == i;
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedLevel() {
        return isSelected(1);
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberOptions() {
        return this.options.size();
    }
}
