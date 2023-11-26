//package a2002Assignment;

public class PointsManager {
    private int points;

    public PointsManager() {
        this.points = 0;
    }

    public void addPoint() {
        this.points++;
    }

    public int getPoints() {
        return this.points;
    }
}
