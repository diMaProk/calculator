package com.gmail.pdv.gui;

import java.awt.Font;
import javax.swing.JLabel;


public class MyJLabel extends JLabel {

    public MyJLabel(String text) {
        super(text);
        super.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
    }
   
}
