package events.listeners;

import components.Slide;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class FileTreeController implements TreeSelectionListener {

    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        for (int i = 0; i < path.getPathCount(); i++) {
            if (path.getPathComponent(i) instanceof Slide) {
                break;
            }
        }
    }
}
