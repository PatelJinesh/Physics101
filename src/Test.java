import events.commands.Commands;
import events.commands.Shortcuts;
import structures.ClipBoard;
import structures.DrawnVector;
import ui.components.JToolBar;
import ui.components.JVectorView;
import ui.dialogs.DialogResult;
import ui.dialogs.VectorInfoDialog;
import ui.resources.Icons;
import ui.styling.borders.ColumnHeaderBorder;
import ui.styling.renderers.VectorListRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-01
 * File:        Test.java
 * Description:
 */
public class Test extends JFrame implements ActionListener, ComponentListener {

    //region Components

    private final JPanel content;
    private final JSplitPane split;
    private final JLayeredPane preview;
    private final JList vectorsList;
    private final JScrollPane listScroll;
    private final JVectorView vectorView;

    private final DefaultListModel<DrawnVector> vectors;

    private final JMenuBar menuBar;
    private final JToolBar toolBar;

    private final JLabel lblPreview;
    private final JViewport vpHeader;
    private final JLabel lblHeader;

    //endregion

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        this.vectors = new DefaultListModel<>();

        this.content = new JPanel();
        this.listScroll = new JScrollPane();
        this.split = new JSplitPane();
        this.preview = new JLayeredPane();
        this.vectorView = new JVectorView();
        this.vectorsList = new JList(vectors);
        this.menuBar = new JMenuBar();
        this.toolBar = new JToolBar(SwingConstants.HORIZONTAL);

        this.lblPreview = new JLabel("Preview");

        this.vpHeader = new JViewport();
        this.lblHeader = new JLabel("Vectors list");

        this.setupMenu();
        this.setupToolbar();

        this.styleComponents();
        this.attachComponents();

        this.postInitialization();
    }

    private void postInitialization() {
        this.pack();
        this.setTitle("Physics 101");
        this.setVisible(true);
        this.setMinimumSize(this.getSize());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);

        this.lblPreview.setLocation(3, 3);
        this.lblPreview.setSize(((int) (lblPreview.getPreferredSize().getWidth() + 6)), ((int) (lblPreview.getPreferredSize().getHeight() + 6)));
    }

    private void styleComponents() {
        this.vectorsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.vectorsList.setFocusable(false);
        this.vectorsList.setCellRenderer(new VectorListRenderer());

        this.split.setContinuousLayout(true);
        this.split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.split.setBorder(null);
        this.split.setDividerSize(5);

        this.preview.addComponentListener(this);

        this.listScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.listScroll.setBackground(Color.WHITE);
        this.listScroll.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));

        this.toolBar.setOpaque(false);

        this.lblHeader.setFont(new Font("sans-serif", Font.BOLD, 14));
        this.lblHeader.setBorder(new ColumnHeaderBorder());

        this.content.setLayout(new BorderLayout());
    }

    private void attachComponents() {
        this.vpHeader.setView(lblHeader);

        this.listScroll.setColumnHeader(vpHeader);
        this.listScroll.setViewportView(vectorsList);

        this.preview.add(lblPreview, 2);
        this.preview.add(vectorView, 1);

        this.split.setLeftComponent(listScroll);
        this.split.setRightComponent(preview);

        this.content.add(split, BorderLayout.CENTER);
        this.content.add(toolBar, BorderLayout.NORTH);

        this.setContentPane(content);
    }

    private void setupMenu() {
        //region Items

        JMenu jmFile = new JMenu("File");
        JMenu jmEdit = new JMenu("Edit");
        JMenu jmSimulate = new JMenu("Simulate");
        JMenu jmHelp = new JMenu("Help");

        JMenuItem jmiRun = new JMenuItem("Run");
        JMenuItem jmiResultant = new JMenuItem("Resultant");
        JMenuItem jmiExport = new JMenuItem("Export");

        JMenuItem jmiNew = new JMenuItem("New");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiSaveAs = new JMenuItem("Save As");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiPrint = new JMenuItem("Print");
        JMenuItem jmiPrintPreview = new JMenuItem("Print Preview");
        JMenuItem jmiExit = new JMenuItem("Exit");

        JMenuItem jmiUndo = new JMenuItem("Undo");
        JMenuItem jmiRedo = new JMenuItem("Redo");
        JMenuItem jmiCut = new JMenuItem("Cut");
        JMenuItem jmiCopy = new JMenuItem("Copy");
        JMenuItem jmiPaste = new JMenuItem("Paste");
        JMenuItem jmiAttach = new JMenuItem("Attach");
        JMenuItem jmiDelete = new JMenuItem("Delete");
        JMenuItem jmiEdit = new JMenuItem("Edit");
        JMenuItem jmiMoveUp = new JMenuItem("Move Up");
        JMenuItem jmiMoveDown = new JMenuItem("Move Down");

        //endregion

        //region Set Icons

        jmiNew.setIcon(Icons.icoNew);
        jmiSave.setIcon(Icons.icoSave);
        jmiOpen.setIcon(Icons.icoOpen);

        jmiUndo.setIcon(Icons.icoUndo);
        jmiRedo.setIcon(Icons.icoRedo);

        jmiCopy.setIcon(Icons.icoCopy);
        jmiCut.setIcon(Icons.icoCut);
        jmiPaste.setIcon(Icons.icoPaste);

        jmiAttach.setIcon(Icons.icoAttach);
        jmiDelete.setIcon(Icons.icoDelete);
        jmiEdit.setIcon(Icons.icoEdit);
        jmiMoveDown.setIcon(Icons.icoMoveDown);
        jmiMoveUp.setIcon(Icons.icoMoveUp);

        jmiRun.setIcon(Icons.icoRun);
        jmiResultant.setIcon(Icons.icoResultant);

        jmiPrint.setIcon(Icons.icoPrint);
        jmiPrintPreview.setIcon(Icons.icoPrintPreview);

        //endregion

        //region Set Accelerator

        jmiPrint.setAccelerator(Shortcuts.ksPrint);
        jmiPrintPreview.setAccelerator(Shortcuts.ksPrintPreview);

        jmiAttach.setAccelerator(Shortcuts.ksAttach);
        jmiDelete.setAccelerator(Shortcuts.ksDelete);
        jmiMoveUp.setAccelerator(Shortcuts.ksUp);
        jmiMoveDown.setAccelerator(Shortcuts.ksDown);
        jmiEdit.setAccelerator(Shortcuts.ksEdit);

        jmiNew.setAccelerator(Shortcuts.ksNew);
        jmiSave.setAccelerator(Shortcuts.ksSave);
        jmiSaveAs.setAccelerator(Shortcuts.ksSaveAs);
        jmiOpen.setAccelerator(Shortcuts.ksOpen);

        jmiUndo.setAccelerator(Shortcuts.ksUndo);
        jmiRedo.setAccelerator(Shortcuts.ksRedo);

        jmiCut.setAccelerator(Shortcuts.ksCut);
        jmiCopy.setAccelerator(Shortcuts.ksCopy);
        jmiPaste.setAccelerator(Shortcuts.ksPaste);

        jmiRun.setAccelerator(Shortcuts.ksRun);
        jmiResultant.setAccelerator(Shortcuts.ksResultant);
        jmiExport.setAccelerator(Shortcuts.ksExport);

        //endregion

        //region Set Mnemonic

        jmFile.setMnemonic('F');
        jmEdit.setMnemonic('E');
        jmSimulate.setMnemonic('S');
        jmHelp.setMnemonic('H');

        jmiRun.setMnemonic('R');
        jmiResultant.setMnemonic('t');
        jmiExport.setMnemonic('x');

        jmiNew.setMnemonic('N');
        jmiSave.setMnemonic('S');
        jmiSaveAs.setMnemonic('v');
        jmiOpen.setMnemonic('O');
        jmiPrint.setMnemonic('P');
        jmiPrintPreview.setMnemonic('i');
        jmiExit.setMnemonic('x');

        jmiUndo.setMnemonic('U');
        jmiRedo.setMnemonic('R');
        jmiCut.setMnemonic('C');
        jmiCopy.setMnemonic('o');
        jmiPaste.setMnemonic('P');
        jmiAttach.setMnemonic('A');
        jmiDelete.setMnemonic('D');
        jmiEdit.setMnemonic('E');
        jmiMoveDown.setMnemonic('D');
        jmiMoveUp.setMnemonic('v');

        //endregion

        //region Actions

        jmiAttach.setActionCommand(Commands.ATTACH);
        jmiDelete.setActionCommand(Commands.DELETE);
        jmiEdit.setActionCommand(Commands.EDIT);
        jmiMoveDown.setActionCommand(Commands.MOVEDOWN);
        jmiMoveUp.setActionCommand(Commands.MOVEUP);

        jmiCut.setActionCommand(Commands.CUT);
        jmiCopy.setActionCommand(Commands.COPY);
        jmiPaste.setActionCommand(Commands.PASTE);

        jmiAttach.addActionListener(this);
        jmiDelete.addActionListener(this);
        jmiEdit.addActionListener(this);
        jmiMoveDown.addActionListener(this);
        jmiMoveUp.addActionListener(this);

        jmiCut.addActionListener(this);
        jmiCopy.addActionListener(this);
        jmiPaste.addActionListener(this);

        //endregion

        //region Attach

        jmFile.add(jmiNew);
        jmFile.addSeparator();
        jmFile.add(jmiOpen);
        jmFile.addSeparator();
        jmFile.add(jmiSave);
        jmFile.add(jmiSaveAs);
        jmFile.addSeparator();
        jmFile.add(jmiPrint);
        jmFile.add(jmiPrintPreview);
        jmFile.addSeparator();
        jmFile.add(jmiExit);

        jmEdit.add(jmiUndo);
        jmEdit.add(jmiRedo);
        jmEdit.addSeparator();
        jmEdit.add(jmiCut);
        jmEdit.add(jmiCopy);
        jmEdit.add(jmiPaste);
        jmEdit.addSeparator();
        jmEdit.add(jmiAttach);
        jmEdit.add(jmiDelete);
        jmEdit.addSeparator();
        jmEdit.add(jmiMoveUp);
        jmEdit.add(jmiMoveDown);
        jmEdit.addSeparator();
        jmEdit.add(jmiEdit);

        jmSimulate.add(jmiRun);
        jmSimulate.add(jmiResultant);
        jmSimulate.addSeparator();
        jmSimulate.add(jmiExport);

        this.menuBar.add(jmFile);
        this.menuBar.add(jmEdit);
        this.menuBar.add(jmSimulate);
        this.menuBar.add(jmHelp);

        this.setJMenuBar(menuBar);

        //endregion
    }

    private void cut() {
        if (vectorsList.isSelectionEmpty())
            return;

        ClipBoard.setValue(vectors.get(vectorsList.getSelectedIndex()));
        this.deleteVector();
    }

    private void paste() {
        if (!(ClipBoard.getValue() instanceof DrawnVector))
            return;

        try {
            vectors.addElement(((DrawnVector) ClipBoard.getValue()).clone());
            vectorView.attachVector(((DrawnVector) ClipBoard.getValue()).clone());
        } catch (CloneNotSupportedException e) {
            return;
        }
    }

    private void copy() {
        if (vectorsList.isSelectionEmpty())
            return;

        ClipBoard.setValue(vectors.get(vectorsList.getSelectedIndex()));
    }

    private void setupToolbar() {
        JButton btnAttach = new JButton(Icons.icoAttach);
        JButton btnDelete = new JButton(Icons.icoDelete);
        JButton btnEdit = new JButton(Icons.icoEdit);
        JButton btnMoveUp = new JButton(Icons.icoMoveUp);
        JButton btnMoveDown = new JButton(Icons.icoMoveDown);

        JButton btnCut = new JButton(Icons.icoCut);
        JButton btnCopy = new JButton(Icons.icoCopy);
        JButton btnPaste = new JButton(Icons.icoPaste);

        JButton btnNew = new JButton(Icons.icoNew);
        JButton btnOpen = new JButton(Icons.icoOpen);
        JButton btnSave = new JButton(Icons.icoSave);

        btnCut.setBorderPainted(false);
        btnCopy.setBorderPainted(false);
        btnPaste.setBorderPainted(false);
        btnAttach.setBorderPainted(false);
        btnDelete.setBorderPainted(false);
        btnEdit.setBorderPainted(false);
        btnMoveUp.setBorderPainted(false);
        btnMoveDown.setBorderPainted(false);
        btnNew.setBorderPainted(false);
        btnOpen.setBorderPainted(false);
        btnSave.setBorderPainted(false);

        btnCut.setFocusPainted(false);
        btnCopy.setFocusPainted(false);
        btnPaste.setFocusPainted(false);
        btnAttach.setFocusPainted(false);
        btnDelete.setFocusPainted(false);
        btnEdit.setFocusPainted(false);
        btnMoveUp.setFocusPainted(false);
        btnMoveDown.setFocusPainted(false);
        btnNew.setFocusPainted(false);
        btnOpen.setFocusPainted(false);
        btnSave.setFocusPainted(false);

        btnAttach.setActionCommand(Commands.ATTACH);
        btnDelete.setActionCommand(Commands.DELETE);
        btnEdit.setActionCommand(Commands.EDIT);
        btnMoveUp.setActionCommand(Commands.MOVEUP);
        btnMoveDown.setActionCommand(Commands.MOVEDOWN);

        btnAttach.addActionListener(this);
        btnDelete.addActionListener(this);
        btnEdit.addActionListener(this);
        btnMoveDown.addActionListener(this);
        btnMoveUp.addActionListener(this);

        this.toolBar.add(btnNew);
        this.toolBar.add(btnOpen);
        this.toolBar.add(btnSave);
        this.toolBar.addSeparator();
        this.toolBar.add(btnCut);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnPaste);
        this.toolBar.addSeparator();
        this.toolBar.add(btnAttach);
        this.toolBar.add(btnDelete);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnMoveUp);
        this.toolBar.add(btnMoveDown);

        this.toolBar.setFloatable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Commands.ATTACH:
                this.attachVector();
                break;
            case Commands.DELETE:
                this.deleteVector();
                break;
            case Commands.EDIT:
                this.editVector();
                break;
            case Commands.MOVEUP:
                this.moveUp();
                break;
            case Commands.MOVEDOWN:
                this.moveDown();
                break;
            case Commands.CUT:
                this.cut();
                break;
            case Commands.PASTE:
                this.paste();
                break;
            case Commands.COPY:
                this.copy();
                break;
        }
    }

    private void deleteVector() {
        if (vectorsList.isSelectionEmpty())
            return;

        int index = vectorsList.getSelectedIndex();

        this.vectorView.removeVector(index);
        this.vectors.removeElementAt(index);
    }

    private void attachVector() {
        VectorInfoDialog vectorDialog = new VectorInfoDialog(null);

        if (vectorDialog.getResult() == DialogResult.OK) {
            DrawnVector result = ((DrawnVector) vectorDialog.getResult().getParameter());

            this.vectorView.attachVector(result);
            this.vectors.addElement(result);
        }
    }

    private void moveUp() {
        int index = vectorsList.getSelectedIndex();

        if (index <= 0 || vectorsList.isSelectionEmpty())
            return;

        DrawnVector vector = vectors.get(index);

        this.vectors.setElementAt(vectors.getElementAt(index - 1), index);
        this.vectors.setElementAt(vector, index - 1);

        this.vectorView.swapVectors(index, index - 1);

        this.vectorsList.setSelectedIndex(index - 1);
    }

    private void moveDown() {
        if (vectorsList.getSelectedIndex() >= vectorsList.getModel().getSize() - 1 || vectorsList.isSelectionEmpty())
            return;

        DrawnVector vector = vectors.get(vectorsList.getSelectedIndex());
        vectors.setElementAt(vectors.getElementAt(vectorsList.getSelectedIndex() + 1), vectorsList.getSelectedIndex());
        vectors.setElementAt(vector, vectorsList.getSelectedIndex() + 1);

        vectorView.swapVectors(vectorsList.getSelectedIndex(), vectorsList.getSelectedIndex() + 1);

        vectorsList.setSelectedIndex(vectorsList.getSelectedIndex() + 1);
    }

    private void editVector() {
        if (vectorsList.isSelectionEmpty())
            return;

        VectorInfoDialog vectorDialog = new VectorInfoDialog(vectorView.getVector(vectorsList.getSelectedIndex()));
        if (vectorDialog.getResult() == DialogResult.OK) {
            DrawnVector result = ((DrawnVector) vectorDialog.getResult().getParameter());
            vectorView.editVector(vectorsList.getSelectedIndex(), result);

            vectors.setElementAt(result, vectorsList.getSelectedIndex());
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.vectorView.setBounds(0, 0, e.getComponent().getWidth(), e.getComponent().getHeight());
    }

    //region Unimplemented

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    //endregion
}
