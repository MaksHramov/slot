module com.example.slot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.slot to javafx.fxml;
    exports com.example.slot;
}