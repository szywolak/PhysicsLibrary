/**
 * Created by Michal on 09.05.2016.
 */
public class HorizontalThrow {

    public static final double G = 9.81;

    double speedAfterTime(double startSpeed, double time){
        double speed = Math.sqrt(Math.pow(startSpeed,2)+Math.pow(time*G,2));
        return speed;
    }

    double speedBeforeColisionWithGround(double startSpeed, double height){
        double speed = Math.sqrt(Math.pow(startSpeed,2)+2*G*height);
        return speed;
    }
    double timeUntilColisionWithGround(double height){
        double time = Math.sqrt(2*height/G);
        return time;
    }

    double range(double startSpeed, double height){
        double range = startSpeed * Math.sqrt(2*height/G);
        return range;
    }

    double pathY(double startSpeed, double height, double x){
        double y = height - ((G*Math.pow(x,2))/(2*Math.pow(startSpeed,2)));
        return y;
    }
}
