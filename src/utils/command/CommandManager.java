package utils.command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private static CommandManager instance = null;
    private final List<Command> commands;
    private int index;

    public CommandManager() {
        commands = new ArrayList<>();
        index = 0;
    }

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public void addCommand(Command command) {
        removeCommandAfterIndex(index);
        commands.add(command);

        redo();
    }

    public void removeCommandAfterIndex(int index) {
        while (index < commands.size()) {
            commands.remove(index);
        }
    }

    public void undo() {
        if (index < 1) {
            return;
        }

        index--;
        commands.get(index).undoAction();
    }

    public void redo() {
        if (index > commands.size() - 1) {
            return;
        }

        commands.get(index).doAction();
        index++;
    }
}
