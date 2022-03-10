package gui;

import events.actions.ActionManager;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(ActionManager.getInstance().getNewAction());
        fileMenu.add(ActionManager.getInstance().getEditAction());
        fileMenu.add(ActionManager.getInstance().getSharePresentationAction());
        fileMenu.add(ActionManager.getInstance().getDeleteAction());
        fileMenu.addSeparator();

        JMenu openMenu = new JMenu("Open");
        openMenu.setIcon(new ImageIcon(new ImageIcon("src/assets/open.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        openMenu.add(ActionManager.getInstance().getOpenPresentationAction());
        openMenu.add(ActionManager.getInstance().getOpenProjectAction());
        openMenu.add(ActionManager.getInstance().getOpenWorkspaceAction());

        JMenu saveMenu = new JMenu("Save");
        saveMenu.setIcon(new ImageIcon(new ImageIcon("src/assets/save.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        saveMenu.add(ActionManager.getInstance().getSavePresentationAction());
        saveMenu.add(ActionManager.getInstance().getSaveProjectAction());
        saveMenu.add(ActionManager.getInstance().getSaveWorkspaceAction());

        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.addSeparator();
        fileMenu.add(ActionManager.getInstance().getExitAction());

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(ActionManager.getInstance().getUndoAction());
        editMenu.add(ActionManager.getInstance().getRedoAction());

        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(ActionManager.getInstance().getInfoAction());

        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);
    }
}
