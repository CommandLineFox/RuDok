package gui.workspace;

import components.Node;
import components.Presentation;
import components.Project;
import utils.observer.ISubscriber;
import utils.observer.NotificationType;

import javax.swing.*;
import java.awt.*;

public class ProjectPanel extends JPanel implements ISubscriber {
    private Project project;
    private final JTabbedPane jTabbedPane;
    private final JLabel nameLabel;

    public ProjectPanel() {
        super();
        project = null;
        JPanel namePanel = new JPanel();
        nameLabel = new JLabel("No open projects");
        jTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        setLayout(new BorderLayout());
        namePanel.add(nameLabel);
        this.add(jTabbedPane, BorderLayout.CENTER);
        this.add(namePanel, BorderLayout.NORTH);
    }

    @Override
    public void update(Object notification, NotificationType type) {
        switch (type) {
            case CHILD_ADDED: {
                if (notification instanceof Presentation) {
                    PresentationPanel presentationPanel = new PresentationPanel((Presentation) notification);
                    jTabbedPane.addTab(((Presentation) notification).getName(), presentationPanel);
                }

                break;
            }
            case UPDATED: {
                if (notification instanceof Project) {
                    nameLabel.setText(project.getName());
                } else if (notification instanceof Presentation) {
                    int index = project.getChildIndex((Presentation) notification);
                    if (index == -1) {
                        return;
                    }

                    jTabbedPane.setTitleAt(index, ((Presentation) notification).getName());
                }

                break;
            }
            case CHANGED: {
                if (notification instanceof Project) {
                    nameLabel.setText(project.getName());

                    jTabbedPane.removeAll();
                    for (Node node : project.getChildren()) {
                        if (node instanceof Presentation) {
                            PresentationPanel presentationPanel = new PresentationPanel((Presentation) node);
                            jTabbedPane.addTab(node.getName(), presentationPanel);
                        }
                    }
                }

                break;
            }
            case CHILD_REMOVED: {
                if (notification instanceof Project && notification.equals(project)) {
                    nameLabel.setText("No open projects");
                    jTabbedPane.removeAll();
                } else if (notification instanceof Presentation) {
                    int index = project.getChildIndex((Presentation) notification);
                    if (index == -1) {
                        return;
                    }

                    jTabbedPane.removeTabAt(index);
                }

                break;
            }
        }
    }

    public void setProject(Project project) {
        this.project = project;
        this.project.addSubscriber(this);
        this.project.getParent().addSubscriber(this);
        update(project, NotificationType.CHANGED);
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }
}
