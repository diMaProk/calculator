package com.gmail.pdv.gui;

import java.awt.Dimension;
import javax.swing.JButton;


public class MyJButton extends JButton{

    public MyJButton(String name, String text) {
        super(text);
        super.setName(name);
        super.setPreferredSize(new Dimension(80, 50));
        
    }
    
    

}
