package com.gmail.pdv.gui;

import com.gmail.pdv.listeners.ChangeSkinActionListener;
import com.gmail.pdv.listeners.CalcButtonActionListener;
import com.gmail.pdv.listeners.CalcTextFieldFocusListener;
import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestCalculator {
    
    public static final String INPUT_NUMBER = "Input number";
    
    private MyJButton btnAdd;
    private MyJButton btnSubstruct;
    private MyJButton btnDivide;
    private MyJButton btnMultiply;
    private JButton btnChangeSkin;
    
    private MyJLabel labelOperand1;
    private MyJLabel labelOperand2;
    private MyJLabel labelResult;
    
    private MyTextField jtxtOperand1;
    private MyTextField jtxtOperand2;
    private MyTextField jtxtResult;
    
    private MyJPanel panel1;
    private MyJPanel panel2;
    private MyJPanel panel3;
    
    private JFrame frame;
    private int skinCounter = 0;

        
    static TestCalculator gui = new TestCalculator();


    public static void main(String[] args) {
        
        
        gui.setSkin();
        
        gui.createLables();
        gui.createTextFields();
        gui.createButtons();
        gui.createPanels();
        gui.createFrame();
        
    }

    //<editor-fold defaultstate="collapsed" desc="create GUI components">
    public void setSkin() {
           
        AbstractLookAndFeel currentSkin = new HiFiLookAndFeel();    // use skins form JTatoo lib
        
        switch (skinCounter){
            case 0: skinCounter++; 
                    break;
            case 1: currentSkin = new McWinLookAndFeel();
                    skinCounter++;
                    break;
            case 2: currentSkin = new AcrylLookAndFeel();
                    skinCounter++;
                    break;
            case 3: currentSkin = new AluminiumLookAndFeel();
                    skinCounter = 0;
                    break;                
            default: break;
    }
        
        
        try {
            UIManager.setLookAndFeel(currentSkin); 
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TestCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        if (frame != null){
            SwingUtilities.updateComponentTreeUI(frame);
        }
    }
    
    private void createLables() {
        labelOperand1 = new MyJLabel("Operand 1");
        labelOperand2 = new MyJLabel("Operand 2");
        labelResult = new MyJLabel("Result");
    }
    
    private void createTextFields() {
        jtxtOperand1 = new MyTextField(INPUT_NUMBER, 12);
        jtxtOperand2 = new MyTextField(INPUT_NUMBER, 12);
        
        jtxtResult = new MyTextField(15);
        jtxtResult.setEditable(false);
        jtxtResult.setFocusable(false);
        
        addTextFieldListeners();
    }
    
    private void createButtons() {
        btnAdd = new MyJButton("add","  +  ");
        btnSubstruct = new MyJButton("substract", "  -  ");
        btnDivide = new MyJButton("divide", "  /  ");
        btnMultiply = new MyJButton("multiply", "  x  ");
        
        btnChangeSkin = new JButton("Change skin");
        btnChangeSkin.setPreferredSize(new Dimension(120,30));
        btnChangeSkin.setFont(new Font(Font.SERIF, Font.ITALIC, 12));
        btnChangeSkin.setForeground(Color.ORANGE);
        
        addButtonListeners();
        addChangeSkinListeners();
        
    }
    
    private void createPanels() {
        panel1 = new MyJPanel("panel1", new FlowLayout(FlowLayout.LEFT));
        panel2 = new MyJPanel("panel2", new FlowLayout(FlowLayout.CENTER));
        panel3 = new MyJPanel("panel3", new FlowLayout(FlowLayout.TRAILING));
        
        panel1.add(labelOperand1);
        panel1.add(jtxtOperand1);
        panel1.add(labelOperand2);
        panel1.add(jtxtOperand2);
        
        panel2.add(btnAdd);
        panel2.add(btnSubstruct);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);
        
        panel3.add(labelResult);
        panel3.add(jtxtResult);
        panel3.add(btnChangeSkin);
        
    }
    
    private void createFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(2, 2));
        frame.setLocationRelativeTo(null);
        frame.setSize(450, 300);
        frame.setResizable(false);
        
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
        frame.getContentPane().add(panel3, BorderLayout.SOUTH);
        
        frame.setIconImage((new ImageIcon("icons/calc.png")).getImage());
        frame.setVisible(true);
    }
//</editor-fold>

    private void addButtonListeners() {
        CalcButtonActionListener b1 = new CalcButtonActionListener (jtxtOperand1, jtxtOperand2, jtxtResult);
        
        btnAdd.addActionListener(b1);
        btnDivide.addActionListener(b1);
        btnMultiply.addActionListener(b1);
        btnSubstruct.addActionListener(b1);
    }

    private void addTextFieldListeners() {
        
        jtxtOperand1.addFocusListener(new CalcTextFieldFocusListener(jtxtOperand1));
        
        jtxtOperand2.addFocusListener(new CalcTextFieldFocusListener(jtxtOperand2));        
    }
    
    private void addChangeSkinListeners() {
        
        btnChangeSkin.addActionListener(new ChangeSkinActionListener (gui));               
        
    }
    
    
}
