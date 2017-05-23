package com.gmail.pdv.listeners;

import com.gmail.pdv.gui.MyTextField;
import com.gmail.pdv.gui.TestCalculator;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class CalcTextFieldFocusListener implements FocusListener{ 
    
    private MyTextField txtField;

    public CalcTextFieldFocusListener(MyTextField txtField) {
        this.txtField = txtField;
    }
    
    
    @Override
    public void focusGained(FocusEvent e) {
        if (txtField.getText().trim().equals(TestCalculator.INPUT_NUMBER)){
            txtField.setText("");
            txtField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (txtField.getText().trim().equals("")){
            txtField.setText(TestCalculator.INPUT_NUMBER);
            txtField.setForeground(Color.GRAY);
        }
    }

   
}
