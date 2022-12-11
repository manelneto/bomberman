package pt.up.fe.bomberman.model.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> options;

    private final List<String> levels=Arrays.asList("EASY","KINDA EASY","NOT EASY","HARD MODE");

    private int currentlevel=0;

    private int currentoption = 0;

    public Menu() {
        this.options = Arrays.asList("START",levels.get(0),"EXIT");
    }

    public void nextEntry() {
        currentoption++;
        if (currentoption > this.options.size() - 1)
            currentoption = 0;
    }

    public void previousEntry() {
        currentoption--;
        if (currentoption < 0)
            currentoption = this.options.size() - 1;
    }
    public void previousLevel() {
        currentlevel--;
        if (currentlevel < 0)
            currentlevel = this.levels.size() - 1;
        options.set( 1, levels.get(currentlevel));
    }

    public void nextLevel() {
        currentlevel++;
        if (currentlevel > this.levels.size() - 1)
            currentlevel = 0;
        options.set( 1, levels.get(currentlevel));
    }


    public String getOption(int i) {
        return options.get(i);
    }

    public int getLevel(){
        return currentlevel;
    }

    public boolean isSelected(int i) {
        return currentoption == i;
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedLevel() {
        return currentoption == 1;
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberOptions() {
        return this.options.size();
    }
}
