package ipap.training.grasshopper;

public class Grasshopper {
    Coordinate[] coordinateArray;
    public static int solve(Grasshopper g){
        int ans =0;
        for (int i = 0; i <g.coordinateArray.length ; i++) {
            if (g.coordinateArray[i].frogReachable) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

    public Grasshopper(int frogX, int frogY, int frogLength ,int[][] coordinates) {
        coordinateArray = new Coordinate[coordinates.length];
        int i =0;
        for (int[] coor : coordinates) {
            Coordinate c = new Coordinate(coor[0], coor[1]);
            coordinateArray[i] = c;
            i++;
        }
        for (Coordinate c : coordinateArray) {
            c.checkReach(frogX,frogY,frogLength);
        }
    }

}

class Coordinate{
    int x,y;
    boolean frogReachable;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void checkReach(int frogX, int frogY, int frogLength){
        double reach = calcDist(x,frogX,y,frogY);
       if (reach<=frogLength)
           frogReachable =true;
       else
           frogReachable = false;
    }

    private static double calcDist(int x1, int x2, int y1, int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}