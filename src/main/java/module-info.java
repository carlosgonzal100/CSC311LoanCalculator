module org.example.csc311_loan_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc311_loan_calculator to javafx.fxml;
    exports org.example.csc311_loan_calculator;
}