module com.example.cddd {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.cddd to javafx.fxml;
    exports com.example.cddd;
    exports model;
    opens model to javafx.fxml;
    exports view;
    opens view to javafx.fxml;
}