/**
 * Created by Michal on 09.05.2016.
 */
public class VerticalThrow {

    public static final double G = 9.81;

    double positionAfterSomeTime(double height, double time){
        double distance = Math.pow(time,2);
        distance=height-((G/2)*distance);
        return distance;
    }

    double speedAfterSomeTime(double time){
        double speed = G*time;
        return speed;
    }

    double speedBeforeColisionWithGround(double height){
        double speed = Math.sqrt(2*G*height);
        return speed;
    }
}
