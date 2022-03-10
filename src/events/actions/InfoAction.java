package events.actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;

public class InfoAction extends Action {

    public InfoAction() {
        putValue(SMALL_ICON, loadIcon("info.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Displays information about the project developer");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getAboutDialog().setVisible(true);
    }
}
