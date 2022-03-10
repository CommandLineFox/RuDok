package events.actions;

import gui.EditDialog;

import java.awt.event.ActionEvent;

public class EditAction extends Action {
    private final EditDialog editDialog;

    public EditAction() {
        putValue(SMALL_ICON, loadIcon("edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit a presentation's author and background");

        this.editDialog = new EditDialog(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        editDialog.setVisible(true);
    }
}
