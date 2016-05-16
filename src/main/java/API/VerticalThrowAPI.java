package API;

/**
 * Created by Michal on 16.05.2016.
 */
public interface VerticalThrowAPI {


    /**
     * This is the main method which calculate position of object in vertical throw after some time.
     *
     * @param height
     * @param time
     * @return distance
     */
    double positionAfterSomeTime(double height, double time);

    /**
     * This is the main method which calculate velocity of object in vertical throw after some time.
     *
     * @param time
     * @return velocity
     */
    double velocityAfterSomeTime(double time);

    /**
     * This is the main method which calculate velocity of object in vertical throw from some height just before collision with ground.
     *
     * @param height
     * @return velocity
     */
    double velocityBeforeColisionWithGround(double height);
}
