package ui.resources;

import javax.swing.*;
import java.security.SecureClassLoader;

/**
 * Created by Jinesh Patel on 2016-01-05.
 */
public class Icons {
    public static final ImageIcon icoPrint = new ImageIcon(SecureClassLoader.getSystemResource("Print.png"));
    public static final ImageIcon icoPrintPreview = new ImageIcon(SecureClassLoader.getSystemResource("Text preview.png"));

    public static final ImageIcon icoUndo = new ImageIcon(SecureClassLoader.getSystemResource("Undo.png"));
    public static final ImageIcon icoRedo = new ImageIcon(SecureClassLoader.getSystemResource("Redo.png"));

    public static final ImageIcon icoCut = new ImageIcon(SecureClassLoader.getSystemResource("Cut.png"));
    public static final ImageIcon icoCopy = new ImageIcon(SecureClassLoader.getSystemResource("Copy.png"));
    public static final ImageIcon icoPaste = new ImageIcon(SecureClassLoader.getSystemResource("Paste.png"));

    public static final ImageIcon icoAttach = new ImageIcon(SecureClassLoader.getSystemResource("Create.png"));
    public static final ImageIcon icoDelete = new ImageIcon(SecureClassLoader.getSystemResource("Delete.png"));
    public static final ImageIcon icoEdit = new ImageIcon(SecureClassLoader.getSystemResource("Modify.png"));
    public static final ImageIcon icoMoveUp = new ImageIcon(SecureClassLoader.getSystemResource("Up.png"));
    public static final ImageIcon icoMoveDown = new ImageIcon(SecureClassLoader.getSystemResource("Down.png"));

    public static final ImageIcon icoNew = new ImageIcon(SecureClassLoader.getSystemResource("New document.png"));
    public static final ImageIcon icoOpen = new ImageIcon(SecureClassLoader.getSystemResource("Folder.png"));
    public static final ImageIcon icoSave = new ImageIcon(SecureClassLoader.getSystemResource("Save.png"));

    public static final ImageIcon icoRun = new ImageIcon(SecureClassLoader.getSystemResource("Go.png"));
    public static final ImageIcon icoResultant = new ImageIcon(SecureClassLoader.getSystemResource("Sum.png"));
}
