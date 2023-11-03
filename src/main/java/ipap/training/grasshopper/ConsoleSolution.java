package ipap.training.grasshopper;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleSolution {

    public static void main(String[] args) {
        ArrayList<Integer> list = ConsoleSolution.readFromConsole();
        int[][] coordinateList = ConsoleSolution.extractCoords(list);
        ConsoleSolution.solveToConsole(list, coordinateList);
    }

    public static int[][] extractCoords(ArrayList<Integer> list) {
        int[][] coordinateList = new int[list.get(0)][2];
        for (int i = 0; i < list.get(0); i++) {
            coordinateList[i] = new int[]{list.get(i*2+4), list.get(i*2+5)};

        }
        return coordinateList;
    }

    public static void solveToConsole(ArrayList<Integer> list, int[][] coordinateList) {
        Grasshopper g = new Grasshopper(list.get(1), list.get(2), list.get(3), coordinateList);
        int solution = Grasshopper.solve(g);
        if (solution ==0)
            System.out.println("Yes");
        else
            System.out.println(solution);
    }

    public static ArrayList<Integer> readFromConsole(){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < list.get(0); i++) {
            list.add(sc.nextInt());
            list.add(sc.nextInt());
        }
        return list;
    }

}
