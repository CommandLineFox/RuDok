package events.actions;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class Action extends AbstractAction {
    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource("../../assets/" + fileName);
        Icon icon = null;

        if (imageURL != null) {
            ImageIcon unscaled = new ImageIcon(imageURL);
            Image image = unscaled.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
        } else {
            System.err.println("Resources not found: " + fileName);
        }

        return icon;
    }
}
