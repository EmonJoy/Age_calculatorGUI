package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;

public class HelloController {

    @FXML
    private Button btn;

    @FXML
    private Button btn1;

    @FXML
    private TextField text1;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtMonth;

    @FXML
    private TextField txtResult;

    @FXML
    void ClearBtn(ActionEvent event) {
        text1.setText("");
        txtMonth.setText("");
        txtDate.setText("");
        txtResult.setText("");

    }

    @FXML
    void Mybtn(ActionEvent event) {
        try {
            int yearOfBirth, monthOfBirth, dayOfBirth;

            yearOfBirth = Integer.parseInt(text1.getText());
            monthOfBirth = Integer.parseInt(txtMonth.getText()) - 1;
            dayOfBirth = Integer.parseInt(txtDate.getText());

            Calendar today = Calendar.getInstance();
            int currentYear = today.get(Calendar.YEAR);
            int currentMonth = today.get(Calendar.MONTH);
            int currentDay = today.get(Calendar.DAY_OF_MONTH);

            int ageYears = currentYear - yearOfBirth;
            int ageMonths = currentMonth - monthOfBirth;
            int ageDays = currentDay - dayOfBirth;

            if (ageDays < 0) {
                ageMonths -= 1;
                today.add(Calendar.MONTH, -1);
                ageDays += today.getActualMaximum(Calendar.DAY_OF_MONTH);
            }

            if (ageMonths < 0) {
                ageYears -= 1;
                ageMonths += 12;
            }

            txtResult.setText("AGE: " + ageYears + " Year " + ageMonths + " Month " + ageDays + " Days ");

        } catch (NumberFormatException e) {
            txtResult.setText("Birth year should be an integer number.");
        }


    }


}



