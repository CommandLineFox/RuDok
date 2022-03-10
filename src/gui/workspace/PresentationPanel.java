package gui.workspace;

import components.Presentation;
import components.Slide;
import gui.MainFrame;
import utils.observer.ISubscriber;
import utils.observer.NotificationType;
import utils.state.slidestate.SlideStateManager;
import utils.state.slidestate.StateType;
import utils.state.slotstate.SlotStateManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PresentationPanel extends JPanel implements ISubscriber {
    private final Presentation presentation;
    private final SlideStateManager slideStateManager;
    private final SlotStateManager slotStateManager;

    private final EditPanel editPanel;
    private final SlideShowPanel slideShowPanel;

    private List<SlidePanel> leftSlideList;
    private List<SlidePanel> centralSlideList;
    private List<SlidePanel> showSlideList;

    public PresentationPanel(Presentation presentation) {
        setLayout(new BorderLayout());

        this.presentation = presentation;
        for (int i = 0; i < presentation.getSubscribers().size(); i++) {
            presentation.removeSubscriber(presentation.getSubscribers().get(i));
        }

        this.presentation.addSubscriber(this);
        this.presentation.addSubscriber(MainFrame.getInstance().getProjectPanel());

        slideStateManager = new SlideStateManager();
        slotStateManager = new SlotStateManager();

        editPanel = new EditPanel(this);
        slideShowPanel = new SlideShowPanel(this);

        add(editPanel);
    }

    @Override
    public void update(Object notification, NotificationType type) {
        switch (type) {
            case CHILD_ADDED: {
                if (notification instanceof Slide) {
                    SlidePanel leftSlidePanel = new SlidePanel((Slide) notification, SlideType.LIST);
                    editPanel.getLeftPanel().add(Box.createVerticalStrut(15));
                    editPanel.getLeftPanel().add(leftSlidePanel);

                    SlidePanel centralSlidePanel = new SlidePanel((Slide) notification, SlideType.EDIT);
                    editPanel.getCentralPanel().add(Box.createVerticalStrut(5));
                    editPanel.getCentralPanel().add(centralSlidePanel);

                    SlidePanel ssPanel = new SlidePanel((Slide) notification, SlideType.SLIDESHOW);
                    slideShowPanel.getShowPanel().add(ssPanel);

                    leftSlideList.add(leftSlidePanel);
                    centralSlideList.add(centralSlidePanel);
                    showSlideList.add(ssPanel);
                }

                break;
            }
            case UPDATED: {
                if (notification instanceof Presentation) {
                    if (editPanel.getAuthorLabel().getText().equals("Author: " + ((Presentation) notification).getAuthor())) {
                        editPanel.getAuthorLabel().setText("Author: " + ((Presentation) notification).getAuthor());
                    }
                }

                break;
            }
            case CHILD_REMOVED: {
                if (notification instanceof Slide) {
                    for (int i = 0; i < leftSlideList.size(); i++) {
                        if (leftSlideList.get(i).getSlide() == notification) {
                            editPanel.getLeftPanel().remove(leftSlideList.get(i));
                            leftSlideList.remove(leftSlideList.get(i));
                        }
                    }
                    for (int i = 0; i < centralSlideList.size(); i++) {
                        if (centralSlideList.get(i).getSlide() == notification) {
                            editPanel.getCentralPanel().remove(centralSlideList.get(i));
                            centralSlideList.remove(centralSlideList.get(i));
                        }
                    }
                    for (int i = 0; i < showSlideList.size(); i++) {
                        if (showSlideList.get(i).getSlide() == notification) {
                            slideShowPanel.getShowPanel().remove(showSlideList.get(i));
                            showSlideList.remove(showSlideList.get(i));
                        }
                    }
                }

                editPanel.updateUI();
                break;
            }
        }
    }

    public EditPanel getEditPanel() {
        return editPanel;
    }

    public SlideShowPanel getSlideShowPanel() {
        return slideShowPanel;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public List<SlidePanel> getLeftSlideList() {
        return leftSlideList;
    }

    public void setLeftSlideList(List<SlidePanel> leftSlideList) {
        this.leftSlideList = leftSlideList;
    }

    public List<SlidePanel> getCentralSlideList() {
        return centralSlideList;
    }

    public void setCentralSlideList(List<SlidePanel> centralSlideList) {
        this.centralSlideList = centralSlideList;
    }

    public List<SlidePanel> getShowSlideList() {
        return showSlideList;
    }

    public void setShowSlideList(List<SlidePanel> showSlideList) {
        this.showSlideList = showSlideList;
    }

    public StateType getCurrentStateType() {
        return slideStateManager.getCurrentStateType();
    }

    public void setEditState() {
        slideStateManager.setEditState();
    }

    public void setSlideShowState() {
        slideStateManager.setSlideShowState();
    }

    public void slotMouseClicked(int x, int y, Slide slide) {

    }

    public void slotMousePressed(int x, int y, Slide slide) {

    }

    public void slotMouseReleased(int x, int y, Slide slide) {

    }

    public void slotMouseDragged(int x, int y, Slide slide) {

    }
}
