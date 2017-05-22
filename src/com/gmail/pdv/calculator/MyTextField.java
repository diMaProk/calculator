package com.gmail.pdv.calculator;

import java.awt.Font;
import javax.swing.JTextField;


class MyTextField extends JTextField {

    public MyTextField(int columns) {
        super(columns);
        super.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
    }   
    

}
