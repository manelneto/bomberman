package pt.up.fe.bomberman.viewer;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}