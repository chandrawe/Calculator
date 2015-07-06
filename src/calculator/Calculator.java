/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author chhhh
 */
public class Calculator extends JFrame implements ActionListener {

    private static final int w = 380;
    private static final int h = 250;
    
    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    
    String[] buttonString = {"7", "8", "9", "+",
                             "4", "5", "6", "-",
                             "1", "2", "3", "*",
                             ".", "/", "C", "V",
                             "+/-", "=", "0"
                            };
    
    //each for different types of components
    int[] dimW = { 300, 45, 100, 90};
    //35 for display, 40 for buttons
    int[] dimH = { 35, 40};
    
    //Setting up the display dimensions
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rightColDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDim = new Dimension(dimW[3], dimH[1]);
    
    boolean[] function = new boolean[4];
    double[] temporary = {0,0};
    
    JTextArea display = new JTextArea (1,20);
    Font font = new Font("Times New Roman", Font.BOLD, 13);
    
    static double memory = 0;
    
    
    Calculator() {    //constructor same as class name
        super("Calculator Testing");
        //setDesign();
        setSize(w, h);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5, 5);
        setLayout(grid);
        
        
        //making the condition for booleans
        //we want to have all of it to refer to false
        for (int i =0; i<4; i++) {
            function[i] = false;
        }
        
        //setting up form layout
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        
        //initialize JPanel Row inside
        for (int i=0; i<5; i++){
            row[i] = new JPanel();
        }
        
        //setting up row into the layout
        //because row is for display, put in different layout
        row[0].setLayout(f1);
        for (int i=1; i<5; i++){
            row[i].setLayout(f2);
        }
        
        //setting up button
        for (int i =0; i<19; i++){
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        
        //setting up display layer
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        //setting up sizes
        display.setPreferredSize(displayDimension);
        
        //placing the buttons
        for(int i = 0; i<14;i++ ){
            button[i].setPreferredSize(regularDimension);
        }
        for(int i = 14; i<18; i++){
            button[i].setPreferredSize(rightColDimension);
        }
        button[18].setPreferredSize(zeroButDim);
        
        //Add the components into panel, and panels into the frame.
        row[0].add(display);
        add(row[0]);
        
        //row 1
        for(int i =0; i<4; i++){
            row[1].add(button[i]);
        }
        row[1].add(button[14]);
        add(row[1]);
        
        //row 2
        for(int i =4; i<8; i++){
            row[2].add(button[i]);
        }
        row[2].add(button[15]);
        add(row[2]);
        
        //row 3
        for(int i =8; i<12; i++){
            row[3].add(button[i]);
        }
        row[3].add(button[16]);
        add(row[3]);
        
        //row 4
        row[4].add(button[18]);
        for (int i = 12; i < 14; i++){
            row[4].add(button[i]);
        }
        row[4].add(button[17]);
        add(row[4]);
        
        
        setVisible(true);
        
    }
    
    public final void setDesign(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == button[0])
            display.append("7");
        if (ae.getSource() == button[1])
            display.append("8");
        if (ae.getSource() == button[2])
            display.append("9");
        if (ae.getSource() == button[3]){
            //add function[0]
            temporary[0] =Double.parseDouble(display.getText());
            function[0]= true;
            display.setText("");
        }
        if (ae.getSource() == button[4])
            display.append("4");
        if (ae.getSource() == button[5])
            display.append("5");
        if (ae.getSource() == button[6])
            display.append("6");    
        if (ae.getSource() == button[7]){
            //substract function[1]
            temporary[0] =Double.parseDouble(display.getText());
            function[1]= true;
            display.setText("");
        }   
        if (ae.getSource() == button[8])
            display.append("1");
        if (ae.getSource() == button[9])
            display.append("2");
        if (ae.getSource() == button[10])
            display.append("3");    
        if (ae.getSource() == button[11]){
            //multiply function[2]
            temporary[0] =Double.parseDouble(display.getText());
            function[2]= true;
            display.setText("");
        }  
        if (ae.getSource() == button[12])
            display.append(".");
        if (ae.getSource() == button[13]){
            //divide function[3]
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if (ae.getSource() == button[14])
            clear();    
        if (ae.getSource() == button[15])
            getSqrt();
        if (ae.getSource() == button[16])
            posNeg();
        if (ae.getSource() == button[17])
            getResult();
        if (ae.getSource() == button[18])
            display.append("0");
    }
    
    public void clear(){
        try{
            display.setText("");
            for(int i = 0; i<4; i++){
                function[i] = false; //sets the functions back to false
            }
            for (int i =0 ; i<2; i++){
                temporary[i] = 0; //Sets our temporary variables back to 0
            }
        }catch(NullPointerException e){
            System.err.print(e);
        }
    }
    
    public void getSqrt(){
        try{
            double value = Math.sqrt(Double.parseDouble(display.getText()));
            //Create a variable for value, and use Math's square root to find value
            display.setText(Double.toString(value));
        }catch (NumberFormatException e){
            System.err.print(e);
        }
    }
    
    public void posNeg(){
        try{
            double value = Double.parseDouble(display.getText());
            if (value != 0) {
                value = value * -1;
                display.setText(Double.toString(value));
            } else {
                
            }
        }catch (NumberFormatException e){
            System.err.print(e);
        }
    }
    
    public void getResult(){
        double result = 0; //variable for result
        temporary [1] = Double.parseDouble(display.getText()); //our second temporary number from display
        String temp0 = Double.toString(temporary[0]); //Necessary string to get the text from first text
        String temp1 = Double.toString(temporary[1]); //Necessary string to get the text from second text
        
        try {
            if (temp0.contains("-")){ //if first string contains -
                String[] temp00 = temp0.split("-", 2); // split string into 2 at -
                temporary[0] = (Double.parseDouble(temp00[1]) * - 1); // put string back in double with the real value
            }
            if (temp1.contains("-")){ //if first string contains -
                String[] temp01 = temp1.split("-", 2); // split string into 2 at -
                temporary[1] = (Double.parseDouble(temp01[1]) * - 1); // put string back in double with the real value
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        try {
            if (function[2] == true) //Start off with multiplication
                result = temporary [0] * temporary [1];
            else if (function[3] == true ) //Start off with division
                result = temporary[0] / temporary[1];
            else if (function[0] == true ) //Start with addition
                result = temporary[0] + temporary[1];
            else if (function[1] == true) //Start with substraction
                result = temporary[0] - temporary[1];
            display.setText(Double.toString(result));
            for (int i =0; i<4 ; i++){
                function[i] = false; //setting back all to normal setting
            }
        } catch (NumberFormatException e){
            System.err.print(e);
        }
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ownCalc c = new ownCalc();
        
    }
    
}
