module com.example.lesson03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lesson03 to javafx.fxml;
    exports com.example.lesson03;
}