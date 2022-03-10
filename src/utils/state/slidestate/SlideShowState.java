package utils.state.slidestate;

import gui.MainFrame;
import gui.workspace.PresentationPanel;

public class SlideShowState implements IState {
    @Override
    public void changeState() {
        PresentationPanel presentationPanel = (PresentationPanel) MainFrame.getInstance().getProjectPanel().getjTabbedPane().getSelectedComponent();

        presentationPanel.removeAll();
        presentationPanel.add(presentationPanel.getSlideShowPanel());

        presentationPanel.repaint();
        presentationPanel.validate();
    }
}
