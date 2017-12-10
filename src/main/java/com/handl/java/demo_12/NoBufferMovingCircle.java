package com.handl.java.demo_12;

import javafx.scene.paint.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Created by handl on 2017/10/16.
 */
public class NoBufferMovingCircle  extends JApplet implements Runnable{
    Image image = null;
    Thread thread;
    int x = 5;
    int move =1;

    public void init(){
        image = createImage(230,160);
    }

    public void start(){
        if (thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {
        try {
            while (true){
                x += move;
                if((x>105)||(x<5))
                    move *= -1;
                repaint();
                Thread.sleep(10);
            }
        }catch (Exception e){

        }
    }

    public void drawCircle(Graphics gc){
        Graphics2D g = (Graphics2D) gc;
        g.setColor(Color.GREEN);
        g.fillRect(0,0,200,100);
        g.setColor(Color.red);
        g.fillOval(x,5,90,90);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,200,100);
        drawCircle(g);

    }
}
