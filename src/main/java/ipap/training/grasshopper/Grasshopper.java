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

    public Grasshopper(Frog f , Coordinate[] coordinates) {
        coordinateArray = coordinates;
        for (Coordinate c : coordinateArray) {
            c.checkReach(f);
        }
    }

}

