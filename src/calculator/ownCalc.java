/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author chhhh
 */
public class ownCalc extends JFrame implements ActionListener{
    
    int width = 500;
    int height = 500;
    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[16];
    String[] string = { "7" , "8" , "9" , "x" ,
                        "4" , "5" , "6" , "/" ,
                        "1" , "2" , "3" , "+" ,
                        "0" , "=" , "." , "-" 
                        };
    Font font = new Font("Arial", Font.BOLD, 14);
    
    ownCalc() {
        //Set the initial value
        String title = "Testing Calculator good";
        
        setTitle("Testing Calculator Good");
        
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Set up the outer panel layout to fit for the content
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        
        //prepare each row with their own panel
        for (int i =0; i<5; i++){
            row[i] = new JPanel();
        }
        
        //set up the row into the outer panel
        row[0].setLayout(f1);
        for (int i =1; i<5; i++){
            row[i].setLayout(f2);
        }
        
        
        setVisible(true);
        
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
