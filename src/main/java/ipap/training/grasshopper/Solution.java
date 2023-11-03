package ipap.training.grasshopper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> list = readFromConsole();
        solveToConsole(createFrogFromList(list), extractCoords(list));
    }

    public static Coordinate[] extractCoords(ArrayList<Integer> list) {
        Coordinate[] coordinates = new Coordinate[list.get(0)];
        for (int i = 0; i < list.get(0); i++) {
            coordinates[i]=new Coordinate(list.get(i*2+4), list.get(i*2+5));

        }
        return coordinates;
    }

    public static Frog createFrogFromList(ArrayList<Integer> list){
        return new Frog(list.get(1), list.get(2), list.get(3));
    }


    public static void solveToConsole(Frog frog, Coordinate[] coordinateList) {
        Grasshopper g = new Grasshopper(frog, coordinateList);
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

    public static ArrayList<Integer> readFromFile(String fileName) throws FileNotFoundException {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));
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
