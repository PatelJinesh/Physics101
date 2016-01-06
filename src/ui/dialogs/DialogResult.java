package ui.dialogs;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-02
 * File:        ui.dialogs.DialogResult.java
 * Description:
 */
public enum DialogResult {
    OK,
    CANCEL;

    private Object parameter;

    public Object getParameter() {
        return this.parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }
}
