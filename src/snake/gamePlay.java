/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Deeboo
 */
public class gamePlay extends JPanel implements KeyListener,ActionListener{
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];
    
    
    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    
    
    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon snakeimage;
    
    private int[] enemyxpos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,
    500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    
    private int[] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,
    500,525,550,575,600,625};
    private ImageIcon enemyimage;
    private Random random = new Random();
    
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);
    
    private Timer timer;
    private int delay = 170;
    
    private int snakelength = 3;
    private int moves = 0;
    private int scores = 0;
    
    private ImageIcon imageTitle;
    
    public gamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();
    }
    public void paint(Graphics g){
        if(moves == 0){
           
            snakexlength[0] = 100;
            snakexlength[1] = 75;
            snakexlength[2] = 50;
            
            snakeylength[0] = 100;
            snakeylength[1] = 100;
            snakeylength[2] = 100;
        }
        
        
        //border of title image
    g.setColor(Color.WHITE);
    g.drawRect(24 , 10 , 851 , 55);
    
    
    imageTitle = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\snaketitle.jpg");
    imageTitle.paintIcon(this, g, 25, 11);
            //border of game play
    g.setColor(Color.WHITE);
    g.drawRect(24 , 74 , 851 , 577);
    g.setColor(Color.BLACK);
    g.fillRect(25, 75, 850, 575);
    
    //draw the scores
    g.setColor(Color.WHITE);
    g.setFont(new Font("arial", Font.PLAIN , 17));
    g.drawString("Score : " +scores, 780, 30);
    
    g.drawString("Length : " +snakelength, 780, 50);
    
    
    rightmouth = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\rightmouth.png");
    rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
    
    for(int i = 0 ; i<snakelength ; i++){
    if(i==0 && right){
        rightmouth = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\rightmouth.png");
        rightmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
    }
    
    if(i==0 && left){
        leftmouth = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\leftmouth.png");
        leftmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
    }
    
    if(i==0 && up){
        upmouth = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\upmouth.png");
        upmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
    }
    
    if(i==0 && down){
        downmouth = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\downmouth.png");
        downmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
    }
    
     if(i!=0){
        snakeimage = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\snakeimage.png");
        snakeimage.paintIcon(this, g, snakexlength[i], snakeylength[i]);
    }
    }
    
    enemyimage = new ImageIcon("C:\\Users\\Deeboo\\Documents\\NetBeansProjects\\Snake\\src\\enemy.png");
    enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
    if(enemyxpos[xpos] == snakexlength[0] && enemyypos[ypos] == snakeylength[0]){
    
        snakelength++;
        scores++;
        xpos = random.nextInt(34);
        ypos = random.nextInt(23);
    }
    
     

         for(int j=1 ; j<snakelength ; j++){
     
          if(snakexlength[j]==snakexlength[0] && snakeylength[j]==snakeylength[0]){
          
              right = false;
              left = false;
              up = false;
              down  = false;
              
              g.setColor(Color.WHITE);
              g.setFont(new Font("arial" , Font.BOLD , 55));
              g.drawString("Game Over !!", 300, 300);
              
               g.setFont(new Font("arial" , Font.BOLD , 25));
              g.drawString("Click Space to Restart !!", 350, 340);
          }
     }
    
    
    g.dispose();
    }

    
 
    
      @Override
    public void actionPerformed(ActionEvent ae) {
        if(right){
        
        for(int i = snakelength-1 ; i>=0 ; i--){
             snakeylength[i+1] = snakeylength[i];
        }
        
        for(int i = snakelength ; i>=0 ; i--){
            if(i == 0){
            snakexlength[i] = snakexlength[i]+25;
            }
            else{
              snakexlength[i] = snakexlength[i-1];
            }
            if(snakexlength[i] > 850){
               snakexlength[i] = 25;
            }
        }
        repaint();
        }
        
    if(left){
        
        for(int i = snakelength-1 ; i>=0 ; i--){
             snakeylength[i+1] = snakeylength[i];
        }
        
        for(int i = snakelength ; i>=0 ; i--){
            if(i == 0){
            snakexlength[i] = snakexlength[i]-25;
            }
            else{
              snakexlength[i] = snakexlength[i-1];
            }
            if(snakexlength[i] < 25){
               snakexlength[i] = 850;
            }
        }
        repaint();
        }
    
    if(up){
        
        for(int i = snakelength-1 ; i>=0 ; i--){
             snakexlength[i+1] = snakexlength[i];
        }
        
        for(int i = snakelength ; i>=0 ; i--){
            if(i == 0){
            snakeylength[i] = snakeylength[i]-25;
            }
            else{
              snakeylength[i] = snakeylength[i-1];
            }
            if(snakeylength[i] < 75){
               snakeylength[i] = 625;
            }
        }
        repaint();
        }
    
    if(down){
        
        for(int i = snakelength-1 ; i>=0 ; i--){
             snakexlength[i+1] = snakexlength[i];
        }
        
        for(int i = snakelength ; i>=0 ; i--){
            if(i == 0){
            snakeylength[i] = snakeylength[i]+25;
            }
            else{
              snakeylength[i] = snakeylength[i-1];
            }
            if(snakeylength[i] > 625){
               snakeylength[i] = 75;
            }
        }
        repaint();
        }
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_RIGHT){
       moves++;
       if(!left){
       right = true;
       }
       else{
       right = false;
       left = true;
       }
       up = false;
       down = false;
       }
       
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
       moves++;
       if(!right){
       left = true;
       }
       else{
       left = false;
       right = true;
       }
       up = false;
       down = false;
       }
        
         if(e.getKeyCode() == KeyEvent.VK_UP){
       moves++;
       if(!down){
       up = true;
       }
       else{
       up = false;
       down = true;
       }
       right = false;
       left = false;
       }
         
          if(e.getKeyCode() == KeyEvent.VK_DOWN){
       moves++;
       if(!up){
       down = true;
       }
       else{
       down = false;
       up = true;
       }
       right = false;
       left = false;
       }
          
    if(e.getKeyCode() == KeyEvent.VK_SPACE){
          
          moves = 0;
          scores = 0;
          snakelength = 3;
          repaint();
        
        }
          
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
