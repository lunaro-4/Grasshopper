import com.sun.prism.image.Coords;
import ipap.training.grasshopper.Coordinate;
import ipap.training.grasshopper.Frog;
import ipap.training.grasshopper.Grasshopper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class GrasshopperTests {
    @Test
    public void test1(){
        Coordinate[] coords = {new Coordinate(2,0),new Coordinate(1,1),new Coordinate(0,1)};
        Frog f = new Frog(0,0,1);
        Grasshopper g = new Grasshopper(f,coords);
        Assertions.assertEquals(3, Grasshopper.solve(g));
    }
    @Test
    public void test2(){
        Coordinate[] coords = {new Coordinate(1,1),new Coordinate(2,2)};
        Frog f = new Frog(0,0,100);
        Grasshopper g = new Grasshopper(f,coords);
        Assertions.assertEquals(1, Grasshopper.solve(g));
    }
    @Test
    public void test3(){
        Coordinate[] coords = {new Coordinate(1,1),new Coordinate(2,2),new Coordinate(3,3)};
        Frog f = new Frog(0,0,1);
        Grasshopper g = new Grasshopper(f,coords);
        Assertions.assertEquals(0, Grasshopper.solve(g));
    }
}
