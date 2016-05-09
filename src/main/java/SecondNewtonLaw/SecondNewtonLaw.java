package SecondNewtonLaw;

import java.util.logging.Logger;

/**
 * Created by Szymon on 2016-04-30.
 */
public class SecondNewtonLaw {

    private final static Logger LOGGER = Logger.getLogger(SecondNewtonLaw.class.getName());

    double accelerationWithGivenMassAndForce(double mass, double force){
        double acceleration = force/mass;
        LOGGER.info("Acceleration is equal to: "+acceleration);
        return acceleration;
    }

    double forceWithGivenMassAndAcceleration(double mass, double acceleration){
        double force = mass * acceleration;
        LOGGER.info("Froce is equal to: "+force);
        return force;
    }

    double massWithGivenForceAndAcceleration(double acceleration, double force){
        double mass = force/acceleration;
        LOGGER.info("Mass is equal to: "+mass);
        return mass;
    }

    void validateMass(double checkMass){
    }
}
