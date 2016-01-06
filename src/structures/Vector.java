package structures;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-01
 * File:        structures.Vector.java
 * Description:
 */
public class Vector {

    //region Instance Variables

    /**
     * The magnitude of the vector in pixel units.
     */
    protected double magnitude;
    /**
     * The angle of the vector in pixel units.
     */
    protected double angle;

    //endregion

    //region Constructors

    /**
     * The default constructor of the vector data structure.
     * @param angle         The angle of the vector in degrees.
     * @param magnitude     The magnitude of the vector in pixel units.
     */
    public Vector(double angle, double magnitude) {
        this.magnitude = magnitude;
        this.angle = angle;
    }

    //endregion

    //region Getters and Setters

    /**
     * Gets the angle of the vector.
     * @return The angle of the vector in degrees.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the angle of the vector.
     * @param angle The angle of the vector in degrees.
     */
    public void setAngle(double angle) {
        this.angle = angle % 360;
    }

    /**
     * Gets the magnitude of the vector.
     * @return The magnitude of the vector in pixel units.
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * Sets the magnitude of the vector only if positive.
     * @param magnitude The magnitude of the vector in pixel units.
     */
    public void setMagnitude(double magnitude) {
        if (magnitude > 0)
            this.magnitude = magnitude;
    }

    //endregion
}
