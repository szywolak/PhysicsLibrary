import java.util.logging.Logger;

/**
 * Created by Szymon on 2016-04-30.
 */
public class SecondNewtonLaw {
    public static final double ACCELERATIONOFGRAVITY = 9.81;

    private final static Logger LOGGER = Logger.getLogger(SecondNewtonLaw.class.getName());

    double accelerationWithGivenMassAndForce(double mass, int force){
        double acceleration = force/mass;
        return acceleration;
    }

}
