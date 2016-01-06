package events.commands;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Jinesh Patel on 2016-01-05.
 */
public class Shortcuts {
    public static final KeyStroke ksPrint = KeyStroke.getKeyStroke('P', InputEvent.CTRL_MASK);
    public static final KeyStroke ksPrintPreview = KeyStroke.getKeyStroke('P', InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK);

    public static final KeyStroke ksAttach = KeyStroke.getKeyStroke(KeyEvent.VK_ADD, InputEvent.CTRL_MASK);
    public static final KeyStroke ksDelete = KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, InputEvent.CTRL_MASK);
    public static final KeyStroke ksUp = KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_MASK);
    public static final KeyStroke ksDown = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_MASK);
    public static final KeyStroke ksEdit = KeyStroke.getKeyStroke('E', InputEvent.CTRL_MASK);

    public static final KeyStroke ksNew = KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK);
    public static final KeyStroke ksSave = KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK);
    public static final KeyStroke ksSaveAs = KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK);
    public static final KeyStroke ksOpen = KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK);

    public static final KeyStroke ksUndo = KeyStroke.getKeyStroke('Z', InputEvent.CTRL_MASK);
    public static final KeyStroke ksRedo = KeyStroke.getKeyStroke('Z', InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK);

    public static final KeyStroke ksCut = KeyStroke.getKeyStroke('X', InputEvent.CTRL_MASK);
    public static final KeyStroke ksCopy = KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK);
    public static final KeyStroke ksPaste = KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK);

    public static final KeyStroke ksRun = KeyStroke.getKeyStroke('R', InputEvent.CTRL_MASK);
    public static final KeyStroke ksResultant = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_MASK);
    public static final KeyStroke ksExport = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_MASK | InputEvent.ALT_MASK);
}
