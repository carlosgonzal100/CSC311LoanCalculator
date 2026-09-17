package org.example.csc311_loan_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/*
Note: i did have to search up how to do a few things, here is what i searched:

#how do i make the user not be able to write in a text field but not grey it out in java:
https://stackoverflow.com/questions/34387457/trying-to-make-jtextfield-uneditable
 */

/*
Note: AI DISCLOSURE: used CHATGPT to help me calculate the monthly interest rate and
the total payment for the calculate payments method here is the prompt i used. It then
proceeded to show me step by step how to calculate the numbers:

# how to calculate monthly payment from an annual interest rate, number of years and a loan amount
 */

public class HelloController {
    @FXML
    private TextField annualInterestRate;

    @FXML
    private TextField numberOfYears;

    @FXML
    private TextField loanAmount;

    @FXML
    private TextField monthlyPayment;

    @FXML
    private TextField totalPayment;


    @FXML
    protected void calculatePayments() {

        //turns annual percentage into an annual decimal rate
        double monthlyInterestRate = Double.parseDouble(annualInterestRate.getText()) / 100 / 12;

        //converts years to months
        int numberOfMonths = Integer.parseInt(numberOfYears.getText()) * 12;

        //calculates monthly payment
        double monthlyAmountDue =
                (Double.parseDouble(loanAmount.getText()) * monthlyInterestRate) /
                        (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));

        //calculates total payment
        double totalAmountDue = monthlyAmountDue * numberOfMonths;

        //sets the amount of the monthly payment in the monthly payment textfield
        monthlyPayment.setText(String.valueOf(monthlyAmountDue));


        //sets the total payment in the total payment textfield
        totalPayment.setText(String.valueOf(totalAmountDue));

        //gets rid of the numbers for annual interest rate
        //and disables the text field
        annualInterestRate.setText(null);
        annualInterestRate.setDisable(true);

        //gets rid of the numbers for number of years
        //and disables the text field
        numberOfYears.setText(null);
        numberOfYears.setDisable(true);

        //gets rid of the numbers for loan amount
        //and disables the text field
        loanAmount.setText(null);
        loanAmount.setDisable(true);
    }

    @FXML
    protected void resetCalculator(){
        //sets annualInterestRate textfield to null and
        //enables the field after calculating
        annualInterestRate.setText(null);
        annualInterestRate.setDisable(false);

        //sets numberOfYears textfield to null and
        //enables the field after calculating
        numberOfYears.setText(null);
        numberOfYears.setDisable(false);

        //sets loanAmount textfield to null and
        //enables the field after calculating
        loanAmount.setText(null);
        loanAmount.setDisable(false);

        //sets monthlyPayment and totalPayment textfields to null and
        monthlyPayment.setText(null);
        totalPayment.setText(null);
    }
}
