package ipap.training.grasshopper;

import java.util.Objects;

public class Coordinate {
    int x, y;
    boolean frogReachable;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void checkReach(Frog f) {
        double reach = calcDist(x, f.x, y, f.y);
        if (reach <= f.tongueLength)
            frogReachable = true;
        else
            frogReachable = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    private static double calcDist(int x1, int x2, int y1, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
