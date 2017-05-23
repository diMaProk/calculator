package com.gmail.pdv.listeners;

import com.gmail.pdv.calc.CalcOperations;
import com.gmail.pdv.gui.MyTextField;
import com.gmail.pdv.gui.TestCalculator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.OptionalDouble;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class CalcButtonActionListener implements ActionListener {
    
    private MyTextField jtxtOperand1;
    private MyTextField jtxtOperand2;
    private MyTextField jtxtResult;
    private Double a,b;
    
    public CalcButtonActionListener(MyTextField jtxtOperand1, MyTextField jtxtOperand2, MyTextField jtxtResult) {
        this.jtxtOperand1 = jtxtOperand1;
        this.jtxtOperand2 = jtxtOperand2;
        this.jtxtResult = jtxtResult;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)){
            return;
        }
        JButton btn = (JButton) e.getSource();
        
        a = parseDouble(jtxtOperand1);
        b = parseDouble(jtxtOperand2);        
        
        if (a != null && b !=null){
            switch (btn.getName()) {
                case "add":
                    jtxtResult.setText(String.valueOf(CalcOperations.add(a, b)));
                    break;
                case "substract":
                    jtxtResult.setText(String.valueOf(CalcOperations.substarct(a, b)));
                    break;
                case "divide":
                    jtxtResult.setText(String.valueOf(CalcOperations.divide(a, b)));
                    break;
                case "multiply":
                    jtxtResult.setText(String.valueOf(CalcOperations.multiply(a, b)));
                    break;
                default:
                    break;
            }
        }
        
    }
    
    private Double parseDouble (MyTextField txtField) {
        try {
            return Double.parseDouble(txtField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(txtField, "Only numbers 0-9 and \".\" as a decimal separator\n are accepted for input");
            txtField.setText(TestCalculator.INPUT_NUMBER);
            txtField.setForeground(Color.GRAY);
        }
        return null;
    }
    
    

}
