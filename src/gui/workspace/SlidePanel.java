package gui.workspace;

import components.Presentation;
import components.Slide;
import gui.MainFrame;
import utils.observer.ISubscriber;
import utils.observer.NotificationType;
import utils.state.slotstate.SlotMouseActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SlidePanel extends JPanel implements ISubscriber {
    private final Slide slide;

    public SlidePanel(Slide slide, SlideType type) {
        super();
        this.slide = slide;

        if (slide.getSubscribers().size() > 0) {
            slide.getSubscribers().remove(0);
        }
        slide.addSubscriber(this);

        setBackground(Color.gray);
        setLayout(new BorderLayout());

        addMouseListener(new SlotMouseActionListener(slide));
        addMouseMotionListener(new SlotMouseActionListener(slide));

        Dimension dimension;
        switch (type) {
            case LIST: {
                dimension = new Dimension((int) getToolkit().getScreenSize().getWidth() / 20, (int) getToolkit().getScreenSize().getHeight() / 20);
                break;
            }
            case SLIDESHOW: {
                dimension = new Dimension((int) getToolkit().getScreenSize().getWidth() / 3, (int) getToolkit().getScreenSize().getHeight() / 3);
                break;
            }
            case EDIT:
            default: {
                dimension = new Dimension((int) getToolkit().getScreenSize().getWidth() / 4, (int) getToolkit().getScreenSize().getHeight() / 4);
                break;
            }
        }
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        MainFrame.getInstance().getProjectPanel().updateUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String URL = ((Presentation) slide.getParent()).getBackground();
        Image image;

        try {
            image = ImageIO.read(new File(URL));
        } catch (IOException exception) {
            return;
        }

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void update(Object notification, NotificationType type) {
    }

    public Slide getSlide() {
        return slide;
    }
}
