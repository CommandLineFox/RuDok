package utils.serialize;

import utils.serialize.FileType;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class NodeFileFilter extends FileFilter {
    private String description;
    private String extension;

    public NodeFileFilter(FileType type) {
        switch (type) {
            case WORKSPACE -> {
                extension = ".txt";
                description = "RuDok Workspace File (" + extension + ")";
            }
            case PROJECT -> {
                extension = ".rproj";
                description = "RuDok Project File (" + extension + ")";
            }
            case PRESENTATION -> {
                extension = ".rpre";
                description = "RuDok Presentation File (" + extension + ")";
            }
        }
    }

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(extension);
    }

    @Override
    public String getDescription() {
        return description;
    }
}
