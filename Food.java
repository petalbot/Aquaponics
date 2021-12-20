package Aqua;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Food
{
    int x, y;
    double q, u;
    Color a;
    boolean visible;
    double rotate;
    public Food(int c, int d)
    {
        x = c;
        y = d;
        q = 10;
        u = 10;
        a = new Color(200,150,150);
    }

    public void draw(Graphics2D g){
        g.setColor(a);
        g.fillOval(x,y,10,10);
        move();
    }

    public void move()
    {
        x+=q;
        y-=u;
        if(x <= -500 || x >= 1500 || y <= -500 || y >= 1500){
            q = 0;
            u = 0;
            visible = false;
        }
    }

    public void fall(int j, int b, double ro){
        x = j;
        y = b;
        rotate = ro;
        u = (double)(30*Math.cos(ro));
        q = (double)(30*Math.sin(ro));
        if(x<=0 || x>=1000 || y<=0 || y>=1000){
            q = 0;
            u = 0;
            rotate = 0;
        }
    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,5,5);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void van(){
        x = -100;
        y = -100;
        q = 0;
        u = 0;
    }
}
