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

    /*
    Variables:

    //TextFields:
    annualInterestRate -- allows the user to enter the amount for the annual interest rate

    numberOfYears -- allows the user to enter the amount for the number of years for the loan

    loanAmount -- allows the user to enter the amount of the loan

    monthlyPayment -- holds the amount of the monthly payment after calculation

    totalPayment -- holds the amount of the total payment after calculation


    //variables:
    Double monthlyInterestRate: holds the calculation for the monthly interest rate

    int numberOfMonths: calculates and holds the number of months based off the number
    off years the user entered

    double monthlyAmountDue: calcuates and holds the monthly amount

    double totalAmountDue: calculates and holds the totalAmount
     */

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


    /**
     * Title: calculatePayments()
     * calculates the monthly payment and total payment based off the numbers
     * entered by the user. after calculation the payments are displayed in their
     * respective spots and the user will not be able to enter new values until
     * the reset button is pressed.
     */
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

    /**
     * resetCalculator()
     * resets the state of the calculator by allowing the user to enter
     * new values for calcuation(loan amount, number of years, annual interest rate)
     * and sets all values in all text fields to null.
     */
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
