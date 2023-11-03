package ipap.training.grasshopper;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class GrasshopperController {

    Frog frog;
    Coordinate[] coordinates;
    HashMap<Coordinate, Button> coordToButton = new HashMap<>();
    AnimateGrasshopper agh;
    int deadStep;

    @FXML
    private Label debugText;

    @FXML
    private TextField fileTxt;

    @FXML
    private VBox vBox;

    @FXML
    protected void initialize(){
    }


    @FXML
    void readFromFile(ActionEvent event){
        try {
           ArrayList<Integer> bufferList = Solution.readFromFile(fileTxt.getText());
           debugText.setText("Read Succesful!");
           initVars(bufferList);
           renderMap();
        } catch (FileNotFoundException e) {
            debugText.setText(e.getMessage());
        }
    }

    protected void renderMap(){
        vBox.getChildren().clear();
        int xSize=0;
        for (int i = 0; i < coordinates.length;i++) {
            xSize=Math.max(xSize,coordinates[i].x);
        }
        xSize=Math.max(xSize,frog.x);
        for (int i = 0; i < coordinates.length; i++) {
            HBox row = new HBox();
            row.setSpacing(10);
            for (int j = 0; j < xSize; j++) {
                Button b = new Button(i+" "+j);
                b.setMinSize(50,50);
                b.setStyle("-fx-text-fill: black; -fx-background-color: white;");
                for (int k = 0; k < coordToButton.size(); k++) {
                    Coordinate c = new Coordinate(i,j);
                    if (coordToButton.containsKey(c))
                        coordToButton.put(c,b);
                }
                if (frog.x==i && frog.y==j)
                    b.setText("Frog");
                b.setOnAction(e -> animate());
                row.getChildren().add(b);
            }
            vBox.getChildren().add(row);
        }
//        System.out.println(coordToButton);
    }

    @FXML
    protected void animate(){
        renderMap();
        try{
            agh.interrupt();
            agh = null;
            agh= new AnimateGrasshopper(coordToButton.values().toArray(new Button[0]),deadStep);
        } catch (Exception e){
            agh= new AnimateGrasshopper(coordToButton.values().toArray(new Button[0]),deadStep);
        }
        agh.start();
    }

    private void initVars(ArrayList<Integer> list){
        frog = Solution.createFrogFromList(list);
        coordinates = Solution.extractCoords(list);
        for (int i = 0; i < coordinates.length; i++) {
            coordToButton.put(coordinates[i], null);
        }
        deadStep = Grasshopper.solve(new Grasshopper(frog,coordinates));
    }


}