package Aqua;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Korea
{
    int x, y, q;
    Rectangle r;
    Random ran;
    Random ra;
    boolean b;
    int ta[];
    int i[];
    int l[];
    int fi[];
    int nd[];
    int low[];
    Color c, d, p;
    int f, j, s;
    int e;
    public Korea()
    {
        ran = new Random();
        ra = new Random();
        x = ran.nextInt(1000);
        y = ran.nextInt(429)+551;
        r = new Rectangle(x,y,175,100);
        b = true;
        q = ran.nextInt(10)+10;
        s = ra.nextInt(3);
        if(s == 0){
            c = new Color(250,200,50);
            d = new Color(250,230,100);
        }
        if(s == 1){
            c = new Color(200,50,250);
            d = new Color(230,100,80);
        }
        if(s == 2){
            c = new Color(50,250,200);
            d = new Color(80,230,100);
        }
        ta = new int[] {x+50,x+75,x+100};
        i = new int[]{y+25,y-25,y+25};
        l = new int[]{y+25,y+75,y+25};
        fi = new int[]{x+10,x+60,x+55};
        nd = new int[]{y+10,y-20,y+5};
        low = new int[]{y+40,y+70,y+45};
        f = x+10;
        j = x+10;
        p = new Color(255,50,50);
        e = 0;
    }

    public void draw(Graphics2D g){
        g.setColor(p);
        g.fillRect(x,y-40,75,15);
        g.setColor(d);
        nd = new int[]{y+10,y-20,y+5};
        i = new int[]{y+25,y-25,y+25};
        l = new int[]{y+25,y+75,y+25};
        g.fillPolygon(ta,i,3);
        g.fillPolygon(ta,l,3);
        g.fillPolygon(fi,nd,3);
        g.fillPolygon(fi,low,3);
        g.setColor(c);
        g.fillOval(x,y,75,50);
        g.setColor(d);
        g.fillOval(f,y+10,15,15);
        g.setColor(Color.black);
        g.fillOval(j,y+14,7,7);
    }

    public void move(){
        if(x<=900 && b == true){
            x+=q;
            ta = new int[] {x+25,x-50,x-25};
            fi = new int[]{x+65,x+15,x+20};
            f = x+50;
            j = x+54;
        }
        else if(x>900)
        {
            x-=q;
            b = false;
            ta = new int[] {x+50,x+125,x+100};
            fi = new int[]{x+10,x+60,x+55};
            f = x+10;
            j = x+14;
        }
        else if (x>=0 && b == false){
            x-=q;
            ta = new int[] {x+50,x+125,x+100};
            fi = new int[]{x+10,x+60,x+55};
            f = x+10;
            j = x+14;
        }
        else if(x<0){
            x+=q;
            b = true;
            ta = new int[] {x+25,x-50,x-25};
            fi = new int[]{x+65,x+15,x+20};
            f = x+50;
            j = x+54;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Rectangle getRectangle(){
        return new Rectangle(x-50,y,150,75);
    }

    public void change(){
        c = new Color(200,150,50);
    }

    public Color getColor(){
        return c;
    }

    public Color status(){
        return p;
    }

    public void orange(){
        p = new Color(200,150,50);
    }

    public void green(){
        p = new Color(25,150,50);
        e = 1;
    }

    public int eat(){
        return e;
    }
}

