package utils;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-01
 * File:        utils.VectorUtils.java
 * Description:
 */
public class VectorUtils {
    public static double getXComponent(double magnitude, double angle) {
        return Math.cos(Math.toRadians(angle)) * magnitude;
    }

    public static double getYComponent(double magnitude, double angle) {
        return Math.sin(Math.toRadians(angle)) * magnitude;
    }
}
