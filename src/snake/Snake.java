/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;

import javax.swing.JFrame;

/**
 *
 * @author Deeboo
 */
public class Snake {


    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Snake Game");
        jf.setBounds(10 , 10 , 905 , 700);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBackground(Color.DARK_GRAY);
        gamePlay gm = new gamePlay();
        jf.add(gm);
    }
    
}
