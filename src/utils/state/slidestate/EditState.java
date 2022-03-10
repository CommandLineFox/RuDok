package utils.state.slidestate;

import gui.MainFrame;
import gui.workspace.PresentationPanel;

public class EditState implements IState {
    @Override
    public void changeState() {
        PresentationPanel presentationPanel = (PresentationPanel) MainFrame.getInstance().getProjectPanel().getjTabbedPane().getSelectedComponent();

        presentationPanel.removeAll();
        presentationPanel.add(presentationPanel.getEditPanel());

        presentationPanel.repaint();
        presentationPanel.validate();
    }
}
