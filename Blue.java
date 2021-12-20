package Aqua;

    import java.util.*;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.*;
    import java.net.URL;
    import javax.sound.sampled.*;

    public class Blue
    {
        int x, y, s;
        Color c, d;
        public Blue()
        {
            x = 900;
            y = 405;
            c = new Color(250,200,50);
            d = new Color(250,230,100);
            s = 5;
        }

        public void draw(Graphics2D g){
            g.setColor(c);
            g.fillRect(x,y,50,75);
            g.setColor(d);
            g.fillRect(x,y+20,50,35);
            g.setColor(Color.black);
            g.drawString("FISH",x+12,y+35);
            g.drawString("FOOD",x+10,y+48);
        }

        public void right(){
            if(x<950){
                x+=s;
            }
        }

        public void left(){
            if(x>0){
                x-=s;
            }
        }

        public void up(){
            if(y>0){
                y-=s;
            }
        }

        public void down(){
            if(y<400){
                y+=s;
            }
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public void change(int v){
            if(v == 0){
                c = new Color(250,200,50);
                d = new Color(250,230,100);
            }
            if(v == 1){
                c = new Color(200,50,250);
                d = new Color(230,100,80);
            }
            if(v == 2){
                c = new Color(50,250,200);
                d = new Color(80,230,100);
            }
        }

        public Rectangle getRectangle(){
            return new Rectangle(x,y,50,75);
        }

        public Color getColor(){
            return c;
        }
    }