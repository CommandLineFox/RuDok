package events.actions;

import utils.serialize.FileType;
import utils.serialize.open.OpenNode;

import java.awt.event.ActionEvent;

public class OpenProjectAction extends Action {
    public OpenProjectAction() {
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open a saved project in the current workspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OpenNode openNode = new OpenNode(FileType.PROJECT);
        openNode.open();
    }
}