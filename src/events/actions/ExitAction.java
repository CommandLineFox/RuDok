package events.actions;

import java.awt.event.ActionEvent;

public class ExitAction extends Action {

    public ExitAction() {
        putValue(SMALL_ICON, loadIcon("exit.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit the application safely");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
