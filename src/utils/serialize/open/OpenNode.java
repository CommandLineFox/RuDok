package utils.serialize.open;

import components.Node;
import components.Workspace;
import gui.MainFrame;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;
import utils.serialize.FileType;
import utils.serialize.NodeFileFilter;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class OpenNode implements IOpen {
    private final FileType type;

    public OpenNode(FileType type) {
        this.type = type;
    }

    @Override
    public void open() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new NodeFileFilter(type));

        if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileChooser.getSelectedFile()));
            Node node = null;
            TreeNode parent = null;

            try {
                node = (Node) inputStream.readObject();
                node.setFile(fileChooser.getSelectedFile());
                System.out.println(node);
                switch (type) {
                    case PRESENTATION -> parent = ((TreeNode) MainFrame.getInstance().getTreePanel().getSelectedPath());
                    case PROJECT -> parent = MainFrame.getInstance().getTreePanel().getFileTreeModel().getTreeNode();
                }
                if (parent == null) {
                    ErrorFactory.getInstance().createError(ErrorType.OPEN_FILE);
                    return;
                }

                node.setParent(parent.getNode());
                node.setChanged(false);
            } catch (Exception e) {
                ErrorFactory.getInstance().createError(ErrorType.OPEN_FILE);
            }

            if (node == null || parent == null) {
                ErrorFactory.getInstance().createError(ErrorType.OPEN_FILE);
                return;
            }

            parent.add(new TreeNode(node));
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
        } catch (Exception e) {
            ErrorFactory.getInstance().createError(ErrorType.OPEN_FILE);
        }
    }
}
