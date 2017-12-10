package com.handl.java.demo_12;

import java.awt.*;

/**
 * Created by handl on 2017/10/16.
 */
public class BufferMovingCircle extends NoBufferMovingCircle {
    Graphics graphics = null;

    public void init(){
        super.init();
        graphics = image.getGraphics();
    }

    public void paint(Graphics g){
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,200,100);
        drawCircle(graphics);
        g.drawImage(image,0,0,this);
    }

}
