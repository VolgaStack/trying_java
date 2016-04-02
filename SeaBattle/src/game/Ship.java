package game;

import util.Point;

/**
 * Created by kdm on 02.04.16.
 */
public class Ship {

    private Point startPoint;
    private Point endPoint;

    public Ship(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
}
