package HorizontalAndVerticalThrows;

import API.VerticalThrowAPI;

import java.util.logging.Logger;

/**
 * Created by Michal on 09.05.2016.
 */

public class VerticalThrow implements VerticalThrowAPI {

    public static final double G = 9.81;

    private final static Logger LOGGER = Logger.getLogger(VerticalThrow.class.getName());

    public double positionAfterSomeTime(double height, double time) {
        double distance = Math.pow(time, 2);
        distance = height - ((G / 2) * distance);
        if (distance < 0)
            distance = 0;

        LOGGER.info("Distance is equal to: " + distance);
        return distance;
    }

    public double velocityAfterSomeTime(double time) {
        double velocity = G * time;
        LOGGER.info("Velocity is equal to: " + velocity);
        return velocity;
    }

    public double velocityBeforeColisionWithGround(double height) {
        double velocity = Math.sqrt(2 * G * height);
        LOGGER.info("Velocity is equal to: " + velocity);
        return velocity;
    }
}
