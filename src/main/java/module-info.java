module org.example.demoassignment2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.demoassignment2 to javafx.fxml;
    exports org.example.demoassignment2;
}