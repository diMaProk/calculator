package com.gmail.pdv.calculator;

import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class MyJPanel extends JPanel{

    public MyJPanel(String name, LayoutManager lManager) {
        super(lManager);
        super.setName(name);
        super.setPreferredSize(new Dimension(400, 100));
        super.setBorder(BorderFactory.createEtchedBorder());
    }
    

}
