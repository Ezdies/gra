module com.example.gra {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.gra to javafx.fxml;
    exports com.example.gra;
}