package pt.up.fe.bomberman.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;
    private int currentOption = 0;

    public Menu() {
        this.options = Arrays.asList("START", "EXIT");
    }

    public void nextEntry() {
        currentOption++;
        if (currentOption > this.options.size() - 1)
            currentOption = 0;
    }

    public void previousEntry() {
        currentOption--;
        if (currentOption < 0)
            currentOption = this.options.size() - 1;
    }

    public String getOption(int i) {
        return options.get(i);
    }

    public boolean isSelected(int i) {
        return currentOption == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberOptions() {
        return this.options.size();
    }
}
