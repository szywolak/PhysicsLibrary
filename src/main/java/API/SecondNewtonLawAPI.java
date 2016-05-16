package API;

/**
 * Created by Szymon on 2016-05-16.
 */
public interface SecondNewtonLawAPI {

    /**
     * This is the main method which converts mass and force to acceleration.
     * @param mass
     * @param force
     * @return acceleration
     */
    double accelerationWithGivenMassAndForce(double mass, double force);

    /**
     * This is the main method which converts mass and acceleration to force.
     * @param mass
     * @param acceleration
     * @return Force
     */
    double forceWithGivenMassAndAcceleration(double mass, double acceleration);

    /**
     * This is the main method which converts force and acceleration to mass.
     * @param force
     * @param acceleration
     * @return mass
     */
    double massWithGivenForceAndAcceleration(double acceleration, double force);
}
