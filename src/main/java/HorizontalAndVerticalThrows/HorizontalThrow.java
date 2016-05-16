package HorizontalAndVerticalThrows;

/**
 * Created by Michal on 09.05.2016.
 */
public class HorizontalThrow {

    public static final double G = 9.81;

    double velocityAfterTime(double startVelocity, double time){
        double velocity = Math.sqrt(Math.pow(startVelocity,2)+Math.pow(time*G,2));
        return velocity;
    }

    double velocityBeforeColisionWithGround(double startVelocity, double height){
        double velocity = Math.sqrt(Math.pow(startVelocity,2)+2*G*height);
        return velocity;
    }
    double timeUntilColisionWithGround(double height){
        double time = Math.sqrt(2*height/G);
        return time;
    }

    double range(double startVelocity, double height){
        double range = startVelocity * Math.sqrt(2*height/G);
        return range;
    }

    double pathY(double startVelocity, double height, double x){
        double y = height - ((G*Math.pow(x,2))/(2*Math.pow(startVelocity,2)));
        return y;
    }
}
