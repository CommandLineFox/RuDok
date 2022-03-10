package gui.workspace;

import events.actions.ActionManager;
import components.Node;
import components.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditPanel extends JPanel {
    private final JLabel authorLabel;
    private final JPanel leftPanel;
    private final JPanel centralPanel;

    public EditPanel(PresentationPanel presentationPanel) {
        JPanel authorPanel = new JPanel();
        authorLabel = new JLabel("Author: " + presentationPanel.getPresentation().getAuthor());
        setLayout(new BorderLayout());
        authorPanel.add(authorLabel);
        add(authorPanel, BorderLayout.NORTH);

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JScrollPane leftScrollPane = new JScrollPane(leftPanel);

        centralPanel = new JPanel();
        centralPanel.setBackground(Color.GRAY);
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        JScrollPane centralScrollPane = new JScrollPane(centralPanel);

        presentationPanel.setLeftSlideList(new ArrayList<>());
        presentationPanel.setCentralSlideList(new ArrayList<>());

        for (Node node : presentationPanel.getPresentation().getChildren()) {
            SlidePanel leftSlidePanel = new SlidePanel((Slide) node, SlideType.LIST);
            leftPanel.add(Box.createVerticalStrut(15));
            leftPanel.add(leftSlidePanel);

            SlidePanel centralSlidePanel = new SlidePanel((Slide) node, SlideType.EDIT);
            centralPanel.add(Box.createVerticalStrut(5));
            centralPanel.add(centralSlidePanel);

            presentationPanel.getLeftSlideList().add(leftSlidePanel);
            presentationPanel.getCentralSlideList().add(centralSlidePanel);
        }

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, centralScrollPane);
        splitPane.setDividerLocation(150);
        splitPane.setEnabled(false);
        add(splitPane, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        toolBar.add(ActionManager.getInstance().getChangeSlideAction());
        toolBar.add(ActionManager.getInstance().getAddSlotAction());
        toolBar.add(ActionManager.getInstance().getMoveSlotAction());
        toolBar.add(ActionManager.getInstance().getDeleteSlotAction());
        add(toolBar, BorderLayout.SOUTH);

    }

    public JLabel getAuthorLabel() {
        return authorLabel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JPanel getCentralPanel() {
        return centralPanel;
    }
}
