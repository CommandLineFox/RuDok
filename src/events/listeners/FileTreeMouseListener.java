package events.listeners;

import components.Node;
import components.Project;
import gui.MainFrame;
import gui.tree.FileTree;
import gui.tree.TreeNode;
import gui.workspace.ProjectPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FileTreeMouseListener implements MouseListener {
    FileTree fileTree;

    public FileTreeMouseListener(FileTree fileTree) {
        this.fileTree = fileTree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = fileTree.getRowForLocation(e.getX(), e.getY());
        if (row == -1) {
            fileTree.clearSelection();
            fileTree.setSelectionPath(null);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
            return;
        }

        if (e.getClickCount() == 2) {
            Node node = ((TreeNode) (fileTree.getLeadSelectionPath().getLastPathComponent())).getNode();
            if (node instanceof Project) {
                ProjectPanel projectPanel = MainFrame.getInstance().getProjectPanel();
                projectPanel.setProject((Project) node);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
