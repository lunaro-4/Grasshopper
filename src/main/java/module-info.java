module ipap.training.grasshopper {
    requires javafx.controls;
    requires javafx.fxml;


    opens ipap.training.grasshopper to javafx.fxml;
    exports ipap.training.grasshopper;
}