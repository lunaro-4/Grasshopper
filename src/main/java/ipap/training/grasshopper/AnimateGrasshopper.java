package ipap.training.grasshopper;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

import java.util.Arrays;

public class AnimateGrasshopper extends Thread{

    Button[] bArr;
    int deadStep;

    public AnimateGrasshopper(Button[] bArr, int deadStep) {

        this.bArr = bArr;
        this.deadStep=deadStep;
    }



    @Override
   public  void run(){
        for (int i = 0; i < bArr.length; i++) {
            try {
                Button b = bArr[i];
                Button bSample;
                if (deadStep!=0 && i==deadStep-2){
                    b.setStyle("-fx-text-fill: white; -fx-background-color: red;");
                    Platform.runLater(() ->b.setText("GHop") );
                    break;
                }
                b.setStyle("-fx-text-fill: white; -fx-background-color: green;");
                String s = b.getText();
                Platform.runLater(() ->b.setText("GHop") );

                sleep(500);

                b.setStyle("-fx-text-fill: black; -fx-background-color: white;");
                Platform.runLater(() ->b.setText(s) );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
   }
}
