package utils.state.slotstate;

import components.Slide;
import gui.MainFrame;
import gui.workspace.PresentationPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SlotMouseActionListener implements MouseListener, MouseMotionListener {
    private final Slide slide;

    public SlotMouseActionListener(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationPanel) MainFrame.getInstance().getProjectPanel().getjTabbedPane().getSelectedComponent()).slotMouseClicked(x, y, slide);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationPanel) MainFrame.getInstance().getProjectPanel().getjTabbedPane().getSelectedComponent()).slotMousePressed(x, y, slide);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationPanel) MainFrame.getInstance().getProjectPanel().getjTabbedPane().getSelectedComponent()).slotMouseReleased(x, y, slide);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        ((PresentationPanel) MainFrame.getInstance().getProjectPanel().getjTabbedPane().getSelectedComponent()).slotMouseDragged(x, y, slide);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
