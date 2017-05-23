package com.gmail.pdv.listeners;

import com.gmail.pdv.gui.TestCalculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class ChangeSkinActionListener implements ActionListener {

    private TestCalculator calcObj;
    
    public ChangeSkinActionListener(TestCalculator calcObj) {
       this.calcObj = calcObj;     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calcObj.setSkin();
    }
       

}
