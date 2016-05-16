package API;

/**
 * Created by Michal on 16.05.2016.
 */
public interface HorizontalThrowAPI {

    /**
     * This is the main method which calculate velocity of object in horizontal throw after some time with some initial velocity.
     *
     * @param startVelocity
     * @param time
     * @return velocity
     */
    double velocityAfterTime(double startVelocity, double time);

    /**
     * This is the main method which calculate velocity of object in horizontal throw with some initial velocity from some height before collision with ground.
     *
     * @param startVelocity
     * @param height
     * @return velocity
     */
    double velocityBeforeColisionWithGround(double startVelocity, double height);

    /**
     * This is the main method which calculate time until collision with ground in horizontal throw from some height.
     *
     * @param height
     * @return time
     */
    double timeUntilColisionWithGround(double height);

    /**
     * This is the main method which calculate range in horizontal throw from some height with some initial velocity.
     *
     * @param startVelocity
     * @param height
     * @return range
     */
    double range(double startVelocity, double height);

    /**
     * This is the main method which calculate pathY of object in horizontal throw with some height with some initial velocity at point X.
     *
     * @param startVelocity
     * @param height
     * @param x
     * @return pathY
     */
    double pathY(double startVelocity, double height, double x);

}
