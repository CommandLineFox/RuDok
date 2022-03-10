package gui.tree;

import events.listeners.FileTreeCellEditor;
import events.listeners.FileTreeCellRenderer;
import events.listeners.FileTreeMouseListener;
import events.listeners.FileTreeSelectionListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class FileTree extends JTree {
    public FileTree() {
        addMouseListener(new FileTreeMouseListener(this));
        addTreeSelectionListener(new FileTreeSelectionListener(this));
        setCellEditor(new FileTreeCellEditor(this, new DefaultTreeCellRenderer()));
        setCellRenderer(new FileTreeCellRenderer());
        setEditable(true);
    }
}
