package events.actions;

import gui.MainFrame;
import gui.workspace.PresentationPanel;

import java.awt.event.ActionEvent;

public class ChangeSlideAction extends Action {
    public ChangeSlideAction() {
        putValue(SMALL_ICON, loadIcon("../assets/changeslide.png"));
        putValue(NAME, "Change view");
        putValue(SHORT_DESCRIPTION, "Changes between editing mode and a slide show");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationPanel presentationPanel = (PresentationPanel) MainFrame.getInstance().getProjectPanel().getjTabbedPane().getSelectedComponent();
        switch (presentationPanel.getCurrentStateType()) {
            case EDIT -> {
                presentationPanel.setSlideShowState();
            }
            case SLIDESHOW -> {
                presentationPanel.setEditState();
            }
        }
    }
}
