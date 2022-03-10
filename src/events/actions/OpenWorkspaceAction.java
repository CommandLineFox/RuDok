package events.actions;

import java.awt.event.ActionEvent;

public class OpenWorkspaceAction extends Action {
    public OpenWorkspaceAction() {
        putValue(NAME, "Open workspace");
        putValue(SHORT_DESCRIPTION, "Open a saved workspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}