package gui;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame parent) {
        super(parent);

        JPanel panel = new JPanel(new BorderLayout());

        setTitle("Info");
        JLabel name = new JLabel("Aleksa Bunčić RN 7/20");
        Image image = getToolkit().getImage("src/assets/aleksab.png");
        JLabel labelImage = new JLabel(new ImageIcon(image));

        panel.add(name, BorderLayout.NORTH);
        panel.add(labelImage, BorderLayout.CENTER);
        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(parent);
    }
}
