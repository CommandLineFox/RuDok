package gui;

import gui.tree.TreePanel;
import gui.workspace.ProjectPanel;
import utils.error.Error;
import utils.error.ErrorFactory;
import utils.observer.ISubscriber;
import utils.observer.NotificationType;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {
    private static MainFrame instance = null;
    private TreePanel treePanel;
    private ProjectPanel projectPanel;
    private AboutDialog aboutDialog;

    private MainFrame() {
        initialize();
    }

    private void initialize() {
        aboutDialog = new AboutDialog(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setTitle("RuDok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        MenuBar menuBar = new MenuBar();
        setJMenuBar(menuBar);

        ToolBar toolBar = new ToolBar();
        add(toolBar, BorderLayout.PAGE_START);

        treePanel = new TreePanel();
        projectPanel = new ProjectPanel();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePanel, projectPanel);
        splitPane.setDividerLocation(200);
        splitPane.setOneTouchExpandable(true);
        splitPane.setEnabled(false);
        add(splitPane);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            ErrorFactory.getInstance().addSubscriber(instance);
        }
        return instance;
    }

    public AboutDialog getAboutDialog() {
        return aboutDialog;
    }

    public TreePanel getTreePanel() {
        return treePanel;
    }

    public ProjectPanel getProjectPanel() {
        return projectPanel;
    }

    @Override
    public void update(Object notification, NotificationType type) {
        if (notification instanceof Error && type == NotificationType.ERROR) {
            JDialog errorDialog = new JDialog();
            errorDialog.setTitle("Error");
            errorDialog.setSize(400, 150);
            errorDialog.setLocationRelativeTo(null);

            JPanel error = new JPanel();
            JLabel message = new JLabel(((Error) notification).getMessage());
            JButton dismiss = new JButton("Close");

            error.setLayout(new BoxLayout(error, BoxLayout.Y_AXIS));
            error.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            error.setAlignmentY(JComponent.CENTER_ALIGNMENT);

            error.add(message);
            dismiss.addActionListener((actionEvent) -> errorDialog.dispose());
            error.add(dismiss);

            errorDialog.add(error);
            errorDialog.setVisible(true);
        }
    }
}
