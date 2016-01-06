package ui.dialogs;

import events.commands.Commands;
import structures.DrawnVector;
import ui.styling.borders.ButtonBorder;
import ui.styling.borders.TextFieldBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-01
 * File:        VectorInfoDialog.java
 * Description: Dialog to attach a vector to a JVectorView component.
 */
public class VectorInfoDialog extends JDialog implements ActionListener {
    //region Components

    /**
     * Text field for user input of the name of the vector.
     */
    private final JTextField fldName;
    /**
     * Formatted text field for the user input fo the magnitude of the vector.
     */
    private final JFormattedTextField fldMagnitude;
    /**
     * Formatted text field for the user input fo the angle of the vector.
     */
    private final JFormattedTextField fldAngle;
    /**
     * Field to specify the color of the vector to fill.
     */
    private final JButton fldColor;
    /**
     * ComboBox for the user input of either subtracting or adding a vector.
     */
    private final JComboBox fldMode;

    /**
     * Label for user guidance for the name field.
     */
    private final JLabel lblName;
    /**
     * Label for user guidance for the color field.
     */
    private final JLabel lblColor;
    /**
     * Label for user guidance for the magnitude field.
     */
    private final JLabel lblMagnitude;
    /**
     * Label for user guidance for the angle field.
     */
    private final JLabel lblAngle;
    /**
     * Label for user guidance for the mode field.
     */
    private final JLabel lblMode;

    /**
     * Button to accept the information in the fields and
     * complete the lifecycle of the dialog.
     */
    private final JButton btnOK;
    /**
     * Button to discard the information in the fields and
     * complete the lifecycle of the dialog.
     */
    private final JButton btnCancel;

    /**
     * Panel to hold all the components in the dialog window.
     */
    private final JPanel content;

    /**
     * Holds necessary information for invoking object to process.
     */
    private DialogResult result = DialogResult.CANCEL;

    //endregion

    /**
     * Constructor for the Dialog. Initializes all variables and
     * components used during the lifecycle of the dialog.
     */
    public VectorInfoDialog(DrawnVector values) {
        this.setModal(true);
        this.setTitle("Attach Vector");

        this.lblName = new JLabel("Name:");
        this.lblColor = new JLabel("Color:");
        this.lblMagnitude = new JLabel("Magnitude:");
        this.lblAngle = new JLabel("Angle:");
        this.lblMode = new JLabel("Mode");

        this.fldName = new JTextField(15);
        this.fldMagnitude = new JFormattedTextField(0d);
        this.fldAngle = new JFormattedTextField(0d);
        this.fldColor = new JButton();
        this.fldMode = new JComboBox(DrawnVector.VectorMode.values());

        this.btnOK = new JButton("OK");
        this.btnCancel = new JButton("Cancel");

        this.content = new JPanel(new GridBagLayout());

        this.setContentPane(this.content);

        this.styleComponents();
        this.attachComponents();

        if (values != null) {
            this.fldName.setText(values.getName());
            this.fldMagnitude.setValue(values.getMagnitude());
            this.fldColor.setBackground(values.getColor());
            this.fldAngle.setValue(values.getAngle());
            this.fldMode.setSelectedItem(values.getMode());
        }

        this.setBackground(new Color(238, 238, 238));
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Gets the result of the dialog.
     * @return {DialogResult} The result of the dialog containing the parameters to pass on to the invoking object.
     */
    public DialogResult getResult() {
        return result;
    }

    /**
     * Catches the click events for the buttons in the dialog.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Commands.OK:
                this.lblName.setForeground(this.fldName.getText().length() == 0
                        ? Color.RED
                        : Color.BLACK);

                this.lblMagnitude.setForeground(((double) this.fldMagnitude.getValue()) <= 0
                        ? Color.RED
                        : Color.BLACK);

                if (this.fldName.getText().length() > 0 && ((double) this.fldMagnitude.getValue()) > 0) {
                    String name = fldName.getText();

                    int x = 0;
                    int y = 0;

                    double angle = ((double) fldAngle.getValue());
                    double magnitude = ((double) fldMagnitude.getValue());

                    Color color = fldColor.getBackground();
                    DrawnVector.VectorMode mode = ((DrawnVector.VectorMode) fldMode.getSelectedItem());

                    DrawnVector vector = new DrawnVector(name, x, y, angle, magnitude, color, mode);

                    this.result = DialogResult.OK;
                    this.result.setParameter(vector);

                    this.dispose();
                }

                break;

            case Commands.CANCEL:
                this.result = DialogResult.CANCEL;

                this.dispose();
                break;

            case Commands.COLOR:

                break;
        }
    }

    /**
     * Attaches the components to the content pane of the dialog.
     */
    private void attachComponents() {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.ipadx = 25;
        constraints.insets = new Insets(1, 1, 1, 1);

        constraints.gridx = 0;
        constraints.gridy = 0;

        this.getContentPane().add(lblName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;

        this.getContentPane().add(lblMagnitude, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;

        this.getContentPane().add(lblAngle, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;

        this.getContentPane().add(lblColor, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;

        this.getContentPane().add(lblMode, constraints);

        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.ipadx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 1;
        constraints.gridy = 0;

        this.getContentPane().add(fldName, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;

        this.getContentPane().add(fldMagnitude, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;

        this.getContentPane().add(fldAngle, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;

        this.getContentPane().add(fldColor, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;

        this.getContentPane().add(fldMode, constraints);

        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;

        constraints.gridx = 1;
        constraints.gridy = 5;

        this.getContentPane().add(btnOK, constraints);

        constraints.weightx = 0;

        constraints.gridx = 2;
        constraints.gridy = 5;

        this.getContentPane().add(btnCancel, constraints);
    }

    /**
     * Styles the components to display a particular way to the user.
     */
    private void styleComponents() {
        btnOK.setFocusPainted(false);
        btnOK.setBorder(new ButtonBorder());
        btnOK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOK.addActionListener(this);
        btnOK.setActionCommand("OK");
        btnOK.setBackground(Color.WHITE);

        btnCancel.setFocusPainted(false);
        btnCancel.setBorder(new ButtonBorder());
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(this);
        btnCancel.setActionCommand("CANCEL");
        btnCancel.setBackground(Color.WHITE);

        fldName.setBorder(new TextFieldBorder());
        fldAngle.setBorder(new TextFieldBorder());
        fldMagnitude.setBorder(new TextFieldBorder());
        fldColor.setBorder(new TextFieldBorder());

        fldColor.setPreferredSize(fldName.getPreferredSize());
        fldColor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fldColor.addActionListener(this);
        fldColor.setActionCommand("COLOR");
        fldColor.setFocusPainted(false);
        fldColor.setBackground(Color.BLACK);

        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}
