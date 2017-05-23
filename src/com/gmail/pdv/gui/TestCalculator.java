package com.gmail.pdv.gui;

import com.gmail.pdv.listeners.CalcButtonActionListener;
import com.gmail.pdv.listeners.CalcTextFieldFocusListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TestCalculator {
    
    public static final String INPUT_NUMBER = "Input number";
    
    private MyJButton btnAdd;
    private MyJButton btnSubstruct;
    private MyJButton btnDivide;
    private MyJButton btnMultiply;
    
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



    public static void main(String[] args) {
        
        setSkin();
        
        TestCalculator gui = new TestCalculator();
        
        gui.createLables();
        gui.createTextFields();
        gui.createButtons();
        gui.createPanels();
        gui.createFrame();
        
        
        
        
                    
    }

    //<editor-fold defaultstate="collapsed" desc="create GUI components">
    private static void setSkin() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            //UIManager.setLookAndFeel(new HiFiLookAndFeel()); // using skin from JTatoo library
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TestCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame.setDefaultLookAndFeelDecorated(true);
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
        
        addButtonListeners();
        
    }
    
    private void createPanels() {
        panel1 = new MyJPanel("panel1", new FlowLayout(FlowLayout.LEFT));
        panel2 = new MyJPanel("panel2", new FlowLayout(FlowLayout.CENTER));
        panel3 = new MyJPanel("panel3", new FlowLayout(FlowLayout.CENTER));
        
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
    
    
}
