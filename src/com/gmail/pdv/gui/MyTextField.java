package com.gmail.pdv.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;


public class MyTextField extends JTextField {

    public MyTextField(int columns) {
        super(columns);
        super.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
    }   

    public MyTextField(String INPUT_NUMBER, int columns) {
        this (columns);
        super.setText(INPUT_NUMBER);
        super.setForeground(Color.GRAY);
        
    }
    

}
