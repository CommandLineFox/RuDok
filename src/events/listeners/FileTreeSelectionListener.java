package events.listeners;

import gui.MainFrame;
import gui.tree.FileTree;
import gui.tree.TreePanel;

import javax.swing.event.TreeSelectionEvent;

public class FileTreeSelectionListener implements javax.swing.event.TreeSelectionListener {
    FileTree fileTree;

    public FileTreeSelectionListener(FileTree fileTree) {
        this.fileTree = fileTree;
    }

    public void valueChanged(TreeSelectionEvent e) {
        TreePanel treePanel = MainFrame.getInstance().getTreePanel();
        treePanel.getFileTree().setSelectionPath(e.getPath());
        treePanel.setSelectedPath(e.getPath().getLastPathComponent());
    }
}
