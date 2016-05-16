package SecondNewtonLaw;

import API.SecondNewtonLawAPI;

import java.util.logging.Logger;

/**
 * Created by Szymon on 2016-04-30.
 */
public class SecondNewtonLaw implements SecondNewtonLawAPI{

    private final static Logger LOGGER = Logger.getLogger(SecondNewtonLaw.class.getName());

    public double accelerationWithGivenMassAndForce(double mass, double force){
        double acceleration = force/mass;
        LOGGER.info("Acceleration is equal to: "+acceleration);
        return acceleration;
    }


    public double forceWithGivenMassAndAcceleration(double mass, double acceleration){
        double force = mass * acceleration;
        LOGGER.info("Force is equal to: "+force);
        return force;
    }

    public double massWithGivenForceAndAcceleration(double acceleration, double force){
        double mass = force/acceleration;
        LOGGER.info("Mass is equal to: "+mass);
        return mass;
    }
}
