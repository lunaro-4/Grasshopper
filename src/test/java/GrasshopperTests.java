import ipap.training.grasshopper.Grasshopper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class GrasshopperTests {
    @Test
    public void test1(){
        int[][] coords = {{2,0}, {1, 1}, {0, 1}};
        int frogX=0, frogY=0,frogLength=1;
        Grasshopper g = new Grasshopper(frogX,frogY,frogLength,coords);
        Assertions.assertEquals(3, Grasshopper.solve(g));
    }
    @Test
    public void test2(){
        int[][] coords = {{1,1},{2, 2}};
        int frogX=0, frogY=0,frogLength=100;
        Grasshopper g = new Grasshopper(frogX,frogY,frogLength,coords);
        Assertions.assertEquals(1, Grasshopper.solve(g));
    }
    @Test
    public void test3(){
        int[][] coords = {{1,1}, {2, 2}, {3, 3}};
        int frogX=0, frogY=0,frogLength=1;
        Grasshopper g = new Grasshopper(frogX,frogY,frogLength,coords);
        Assertions.assertEquals(0, Grasshopper.solve(g));
    }
}
