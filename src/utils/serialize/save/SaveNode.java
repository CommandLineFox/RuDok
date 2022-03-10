package utils.serialize.save;

import components.NodeComposite;
import components.Presentation;
import components.Project;
import gui.MainFrame;
import utils.error.ErrorFactory;
import utils.error.ErrorType;
import utils.serialize.FileType;
import utils.serialize.NodeFileFilter;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveNode implements ISave {
    private final NodeComposite node;
    private FileType fileType;

    public SaveNode(NodeComposite node) {
        this.node = node;
        fileType = FileType.WORKSPACE;
        if (node instanceof Project) {
            fileType = FileType.PROJECT;
        } else if (node instanceof Presentation) {
            fileType = FileType.PRESENTATION;
        }
    }

    @Override
    public void save() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new NodeFileFilter(fileType));
        File file = node.getFile();

        if (!node.isChanged()) {
            return;
        }

        if (file == null) {
            if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            file = fileChooser.getSelectedFile();
        }

        ObjectOutputStream outputStream;
        try {
            node.setChanged(false);
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(node);
            node.setFile(file);
        } catch (IOException exception) {
            ErrorFactory.getInstance().createError(ErrorType.SAVE_FILE);
        }
    }
}
