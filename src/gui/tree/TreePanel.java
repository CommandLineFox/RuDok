package gui.tree;

import components.Workspace;
import events.listeners.FileTreeController;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private FileTree fileTree;
    private FileTreeModel fileTreeModel;
    private Object selectedPath;

    public TreePanel() {
        this.selectedPath = null;

        initializeFileTree();
        fileTree.addTreeSelectionListener(new FileTreeController());

        JScrollPane scrollPane = new JScrollPane(fileTree);
        scrollPane.setPreferredSize(new Dimension(300, 0));
        setPreferredSize(new Dimension(800, 800));
        setLayout(new BorderLayout());
        add(scrollPane);
    }

    private void initializeFileTree() {
        fileTree = new FileTree();
        fileTreeModel = new FileTreeModel(new TreeNode(new Workspace("Workspace")));
        fileTree.setModel(fileTreeModel);
    }

    public FileTree getFileTree() {
        return fileTree;
    }

    public FileTreeModel getFileTreeModel() {
        return fileTreeModel;
    }

    public Object getSelectedPath() {
        return selectedPath;
    }

    public void setSelectedPath(Object selectedPath) {
        this.selectedPath = selectedPath;
    }
}
