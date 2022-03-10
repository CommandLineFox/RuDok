package events.actions;

import components.Node;
import components.Presentation;
import components.Project;
import components.Workspace;
import gui.MainFrame;
import utils.error.ErrorFactory;
import utils.error.ErrorType;
import utils.serialize.save.SaveNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;

public class SaveWorkspaceAction extends Action {
    public SaveWorkspaceAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        putValue(NAME, "Save workspace");
        putValue(SHORT_DESCRIPTION, "Save current workspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Workspace workspace = (Workspace) MainFrame.getInstance().getTreePanel().getFileTreeModel().getTreeNode().getNode();
        if (!workspace.isChanged()) {
            return;
        }

        File file = workspace.getFile();
        if (file == null) {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            file = fileChooser.getSelectedFile();
        }

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, false);
            for (Node project : workspace.getChildren()) {
                SaveNode saveProject = new SaveNode((Project) project);
                saveProject.save();

                for (Node presentation : ((Project) project).getChildren()) {
                    SaveNode savePresentation = new SaveNode((Presentation) presentation);
                    savePresentation.save();
                }
            }
        } catch (Exception exception) {
            ErrorFactory.getInstance().createError(ErrorType.UNDEFINED);
        }
    }
}