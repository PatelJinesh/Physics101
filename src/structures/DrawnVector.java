package structures;

import events.listeners.VectorChangedListener;
import utils.VectorUtils;

import java.awt.*;
import java.util.HashSet;

/**
 * Created by Jinesh Patel on 2016-01-03.
 */
public class DrawnVector extends Vector {
    /**
     * List of modes of mathematical operations
     * that can be performed on this vector.
     */
    public enum VectorMode {
        ADD,
        SUBTRACT
    }

    //region Instance Variables

    /**
     * The mathematical operation to perform on this vector.
     */
    protected VectorMode mode;

    /**
     * The starting x location relative to the origin in pixel units.
     */
    protected int startX;
    /**
     * The starting y location relative to the origin in pixel units.
     */
    protected int startY;

    /**
     * The name of the vector to differentiate from others.
     */
    protected String name;
    /**
     * The color of the vector to differentiate from others.
     */
    protected Color color;

    /**
     * List of vector changed listeners to
     * notify when this vector object is changed.
     */
    protected final HashSet<VectorChangedListener> vectorChangedListeners;

    //endregion

    //region Constructors

    /**
     * The default constructor for the drawn vector object.
     *
     * @param name      The name of the vector object to differentiate from others.
     * @param startX    The starting x location of the vector relative to the origin.
     * @param startY    The starting y location of the vector relative to the origin.
     * @param angle     The angle of the vector in degrees.
     * @param magnitude The magnitude of the vector in pixel units.
     * @param color     The color of the vector when drawn on screen.
     * @param mode      The mathematical operation to perform on this drawn vector.
     */
    public DrawnVector(String name, int startX, int startY, double angle, double magnitude, Color color, VectorMode mode) {
        super(angle, magnitude);

        this.startX = startX;
        this.startY = startY;
        this.name = name;
        this.color = color;
        this.mode = mode;

        this.vectorChangedListeners = new HashSet<>();
    }

    //endregion

    //region Getters and Setters

    /**
     * Gets the starting x location.
     *
     * @return The starting x location relative to the origin.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Sets the starting x location.
     *
     * @param startX The starting x location relative to the origin.
     */
    public void setStartX(int startX) {
        this.startX = startX;

        this.update();
    }

    /**
     * Gets the staring y location.
     *
     * @return The starting y location relative to the origin.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Sets the starting y location.
     *
     * @param startY The starting y location relative to the origin.
     */
    public void setStartY(int startY) {
        this.startY = startY;

        this.update();
    }

    /**
     * Gets the name of the vector object.
     *
     * @return The name of the vector object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the vector object.
     *
     * @param name The name of the vector object.
     */
    public void setName(String name) {
        this.name = name;

        this.update();
    }

    /**
     * Gets the color of the vector.
     *
     * @return The color of the vector when drawn on screen.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the vector.
     *
     * @param color The color of the vector when drawn on screen.
     */
    public void setColor(Color color) {
        this.color = color;

        this.update();
    }

    /**
     * Gets the mathematical operation to perform on this vector.
     *
     * @return The mathematical operation to perform on this vector.
     */
    public VectorMode getMode() {
        return mode;
    }

    /**
     * Sets the mathematical operation to perform on this vector.
     *
     * @param mode The mathematical operation to perform on this vector.
     */
    public void setMode(VectorMode mode) {
        this.mode = mode;
    }

    /**
     * Gets the ending y location of the vector.
     *
     * @return The ending y location of the vector relative to the origin.
     */
    public int getEndY() {
        return ((int) (this.startY + VectorUtils.getYComponent(
                this.mode == VectorMode.SUBTRACT
                        ? -this.magnitude
                        : this.magnitude, this.angle)));
    }

    /**
     * Gets the ending x location of the vector.
     *
     * @return The ending x location of the vector relative to the origin.
     */
    public int getEndX() {
        return ((int) (this.startX + VectorUtils.getXComponent(
                this.mode == VectorMode.SUBTRACT
                        ? -this.magnitude
                        : this.magnitude, this.angle)));
    }

    /**
     * Sets the magnitude of the vector object.
     * @param magnitude The magnitude of the vector in pixel units.
     */
    @Override
    public void setMagnitude(double magnitude) {
        super.setMagnitude(magnitude);

        this.update();
    }

    /**
     * Sets the angle of the vector object.
     * @param angle The angle of the vector in degrees.
     */
    @Override
    public void setAngle(double angle) {
        super.setAngle(angle);

        this.update();
    }

    //endregion

    //region Commands

    /**
     * Notifies all vector changed listeners.
     */
    protected void update() {
        for (VectorChangedListener vectorChangedListener : vectorChangedListeners)
            vectorChangedListener.vectorChanged();
    }

    /**
     * Adds a vector changed listener to notify when this vector object is changed.
     * @param vectorChangedListener The vector changed listener to notify.
     */
    public void addVectorChangedListener(VectorChangedListener vectorChangedListener) {
        this.vectorChangedListeners.add(vectorChangedListener);
    }

    /**
     * Removes a vector changed listener to notify when this vector object is changed.
     * @param vectorChangedListener The vector changed listener to notify.
     */
    public void removeVectorChangedListener(VectorChangedListener vectorChangedListener) {
        this.vectorChangedListeners.remove(vectorChangedListener);
    }

    //endregion
}
