package HorizontalAndVerticalThrows;

/**
 * Created by Michal on 09.05.2016.
 */
public class VerticalThrow {

    public static final double G = 9.81;

    double positionAfterSomeTime(double height, double time){
        double distance = Math.pow(time,2);
        distance=height-((G/2)*distance);
        if(distance<0)
            distance=0;
        return distance;
    }

    double velocityAfterSomeTime(double time){
        double velocity = G*time;
        return velocity;
    }

    double velocityBeforeColisionWithGround(double height){
        double velocity = Math.sqrt(2*G*height);
        return velocity;
    }
}
