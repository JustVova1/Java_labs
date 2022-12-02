module com.example.lab5_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentapp to javafx.fxml;
    exports com.example.studentapp;
    opens com.example.studentapp.view to javafx.fxml;
    exports com.example.studentapp.view;
}