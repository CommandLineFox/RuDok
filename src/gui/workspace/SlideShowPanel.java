package gui.workspace;

import events.actions.ActionManager;
import components.Node;
import components.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SlideShowPanel extends JPanel {
    private final JPanel showPanel;

    public SlideShowPanel(PresentationPanel presentationPanel) {
        setLayout(new BorderLayout());

        JButton previousSlideButton = new JButton();
        previousSlideButton.setIcon(new ImageIcon(new ImageIcon("src/assets/previous.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        JButton nextSlideButton = new JButton();
        nextSlideButton.setIcon(new ImageIcon(new ImageIcon("src/assets/next.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));


        CardLayout slideLayout = new CardLayout();
        showPanel = new JPanel(slideLayout);

        previousSlideButton.addActionListener(e -> slideLayout.previous(showPanel));
        nextSlideButton.addActionListener(e -> slideLayout.next(showPanel));

        presentationPanel.setShowSlideList(new ArrayList<>());

        for (Node node : presentationPanel.getPresentation().getChildren()) {
            SlidePanel slidePanel = new SlidePanel((Slide) node, SlideType.SLIDESHOW);
            showPanel.add(slidePanel);
            presentationPanel.getShowSlideList().add(slidePanel);
        }

        JScrollPane scrollPane = new JScrollPane(showPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        toolBar.add(ActionManager.getInstance().getChangeSlideAction());
        toolBar.add(previousSlideButton);
        toolBar.add(nextSlideButton);
        add(toolBar, BorderLayout.SOUTH);
    }

    public JPanel getShowPanel() {
        return showPanel;
    }
}
