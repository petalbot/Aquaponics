package Aqua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Vietnam extends JFrame implements Runnable, KeyListener, MouseListener
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    int ban, dep, qua;
    Korea f[] = new Korea[6];
    Food m[] = new Food[8888];
    boolean b;
    Blue blue;
    double r;
    int c,d;
    int j, l, q, v, n, bar, lab;
    int pl[], ant[], mat[], thew[], al[], an[], jt[], wa[], ter[], im[], mor[], tal[], it[], de[], ll[], hoa[], bang[];
    int leaf[], light[];
    int la, st;
    Color bark, dark;
    int ammonia;
    int bl, ock;
    Color gear, ball, mo, re, na, mes, pu, mp, tu, be, water;
    int move;
    int flow, grow;
    int all, won;
    int sp;
    Clip w;
    int go;
    boolean on;
    public Vietnam()
    {
        con.setLayout(new FlowLayout());
        on = true;
        go = 0;
        sp = 200;
        won = 0;
        all = 0;
        grow = 100;
        flow = 60;
        water = new Color(200,240,220);
        tu = new Color(245,250,240);
        be = new Color(200,210,205);
        move = 0;
        mp = new Color(30,30,80);
        pu = new Color(50,50,100);
        mes = new Color(200,250,200);
        na = new Color(150,175,150);
        re = new Color(100,125,100);
        mo = new Color(100,200,100);
        ball = new Color(50,150,50);
        gear = new Color(30,100,10);
        j = 0;
        ammonia = 0;
        lab = 0;
        bar = 0;
        l = 0;
        q = 0;
        v = 0;
        n = 0;
        ban = 100;
        dep = 150;
        qua = 200;
        for (int x = 0; x<f.length; x++){
            f[x] = new Korea();
        }
        for(int y = 0; y<m.length; y++){
            m[y] = new Food(c,d);
        }
        b = true;
        r = 0;
        blue = new Blue();
        la = 150;
        st = 200;
        pl = new int[]{la,la+30,la+30};
        ant = new int[]{st-10,st,st+30};
        mat = new int[]{la+65,la+35,la+35};
        thew = new int[]{la+100,la+130,la+130};
        al = new int[]{la+165,la+135,la+135};
        an = new int[]{la+170,la+200,la+200};
        jt = new int[]{la+235,la+205,la+205};
        wa = new int[]{la+220,la+250,la+250};
        ter = new int[]{la+285,la+255,la+255};
        im = new int[]{la+320,la+350,la+350};
        mor = new int[]{la+385,la+355,la+355};
        tal = new int[]{la+400,la+430,la+430};
        it = new int[]{la+465,la+435,la+435};
        de = new int[]{la+520,la+550,la+550};
        ll = new int[]{la+585,la+555,la+555};
        hoa = new int[]{la+620,la+650,la+650};
        bang = new int[]{la+685,la+655,la+655};
        bark = new Color(255,50,50);
        dark = new Color(200,150,50);
        leaf = new int[]{500,400,600};
        light = new int[]{0,100,100};
        bl = -1000;
        ock = -500;
        try{
            URL url  = this.getClass().getClassLoader().getResource("water.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            w = AudioSystem.getClip();
            w.open(audioIn);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        addKeyListener(this);
        addMouseListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();
    }

    public void run()
    {
        try{
            while(true)
            {
                t.sleep(67);
                for (int x = 0; x<f.length; x++){
                    f[x].move();
                }
                for (int x = 0; x<f.length; x++)
                {
                    for (int y = 0; y<m.length; y++)
                    {
                        if (f[x].getRectangle().intersects(m[y].getRectangle()))
                        {
                            if(f[x].eat()<=0){
                                if(f[x].getColor().equals(blue.getColor())){
                                    if(f[x].status().equals(bark)){
                                        f[x].orange();
                                        go = 0;
                                    }
                                    else if(f[x].status().equals(dark)){
                                        f[x].green();
                                        all = all+1;
                                        go = 0;
                                    }
                                    m[y].van();
                                }
                            }
                        }
                    }
                }
                if(ammonia>=20 && j == 0){
                    JOptionPane.showMessageDialog(null,"Game over: toxic ammonia levels killed fish.");
                    j = 1;
                    bl = 0;
                    ock = 500;
                    ban = 50;
                    dep = 75;
                    qua = 100;
                    ball = gear;
                    mo = gear;
                    na = re;
                    mes = re;
                    move = 1;
                    on = false;
                }
                if(flow >= 60){
                    flow-=3;
                }
                else if(flow<=60){
                    flow+=3;
                }
                for (int y = 0; y<m.length; y++){
                    if(m[y].getY()>=1000 || (m[y].getY()>=500 && (m[y].getX()<=0 || m[y].getX()>=1000))){
                        m[y].van();
                        ammonia = ammonia+1;
                        go = 0;

                    }
                }
                for (int y = 0; y<m.length; y++){
                    if(m[y].getY()<=1000 && (m[y].getY()>=500 && (m[y].getX()>=0 || m[y].getX()<=1000))){
                        go = 1;
                    }
                }
                if(on = true){
                    w.loop(Clip.LOOP_CONTINUOUSLY);
                }
                if(on = false){
                    w.stop();
                }
                if(all == f.length && won == 0){
                    JOptionPane.showMessageDialog(null,"You won!");
                    won = 1;
                    sp = 170;
                    grow = 130;
                    st = 170;
                    ant = new int[]{st-10,st,st+30};
                    move = 1;
                }
                repaint();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics gr)
    {
        Image i=createImage(getSize().width, getSize().height);
        Graphics2D g = (Graphics2D)i.getGraphics();
        g.setColor(new Color(ban,dep,qua));
        g.fillRect(0,0,1000,1000);
        g.setColor(new Color(200,200,200));
        g.fillRect(490,100,20,330);
        g.setColor(new Color(30,30,100));
        g.fillPolygon(leaf,light,3);
        g.fillOval(400,50,200,100);
        g.setColor(new Color(250,230,240));
        g.fillOval(420,70,160,60);
        g.setColor(new Color(250,250,150));
        g.fillOval(475,70,50,20);
        g.setColor(water);
        g.fillOval(bl+1070,ock+745,flow+10,70);
        g.setColor(new Color(ban,dep,qua));
        g.fillOval(50,250,60,60);
        g.setColor(water);
        g.fillRect(900,500,flow-40,80);
        g.setColor(tu);
        g.fillRect(20,240,20,660);
        g.fillRect(40,240,60,20);
        g.setColor(new Color(150,100,0));
        g.fillRect(50,300,900,180);
        g.setColor(new Color(100,150,200));
        g.setFont(new Font("Vivaldi", Font.PLAIN,50));
        g.drawString("Hit i for instructions.",320,460);
        g.setColor(new Color(100,200,250));
        g.setFont(new Font("Garamond",Font.PLAIN, 60));
        g.drawString("Ammonia: "+ammonia+" (Must stay below 20)",105,390);
        g.setColor(pu);
        g.fillRect(0,850,75,150);
        g.setColor(gear);
        g.fillPolygon(pl,ant,3);
        g.fillPolygon(mat,ant,3);
        g.fillPolygon(thew,ant,3);
        g.fillPolygon(al,ant,3);
        g.setColor(ball);
        g.fillPolygon(an,ant,3);
        g.fillPolygon(jt,ant,3);
        g.fillPolygon(wa,ant,3);
        g.setColor(mo);
        g.fillPolygon(ter,ant,3);
        g.fillPolygon(im,ant,3);
        g.fillPolygon(mor,ant,3);
        g.fillPolygon(tal,ant,3);
        g.fillPolygon(ter,ant,3);
        g.setColor(ball);
        g.fillPolygon(it,ant,3);
        g.setColor(gear);
        g.fillPolygon(de,ant,3);
        g.fillPolygon(ll,ant,3);
        g.fillPolygon(hoa,ant,3);
        g.fillPolygon(bang,ant,3);
        g.setColor(re);
        g.fillRect(180,sp,5,grow);
        g.fillRect(280,sp,5,grow);
        g.fillRect(350,sp,5,grow);
        g.setColor(na);
        g.fillRect(400,sp,5,grow);
        g.setColor(mes);
        g.fillRect(500,sp,5,grow);
        g.setColor(na);
        g.fillRect(580,sp,5,grow);
        g.setColor(re);
        g.fillRect(700,sp,5,grow);
        g.fillRect(800,sp,5,grow);
        for (int x = 0; x<f.length; x++)
        {
            f[x].draw(g);
        }
        c = blue.getX()+25;
        d = blue.getY();
        g.dispose();
        Graphics2D g3 = (Graphics2D)i.getGraphics();
        for(int y = 0; y<m.length; y++){
            m[y].draw(g3);
        }
        g3.dispose();
        Graphics2D g2 = (Graphics2D)i.getGraphics();
        g2.rotate(r,blue.getX()+25,blue.getY()+47);
        blue.draw(g2);
        g2.dispose();
        Graphics2D g4 = (Graphics2D)i.getGraphics();
        g4.setColor(new Color(100,100,100));
        g4.fillRect(0,480,1000,20);
        g4.setColor(new Color(ban,dep,qua));
        g4.fillRect(bl,ock,1000,500);
        g4.setColor(new Color(50,50,50));
        g4.fillOval(bl+420,ock-430,160,60);
        g4.setColor(be);
        g4.fillRect(bl+20,ock-260,20,660);
        g4.fillRect(bl+40,ock-260,60,20);
        g4.setColor(mp);
        g4.fillRect(bl,ock+350,75,150);
        g4.setColor(new Color(50,50,50));
        g4.fillRect(bl,ock-20,1000,20);
        g4.setColor(new Color(70,50,0));
        g4.fillRect(bl+50,ock-200,900,180);
        g4.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        Vietnam frame = new Vietnam();
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void keyReleased(KeyEvent k){
        if(move == 0){
            if(k.getKeyCode() == 73){
                JOptionPane.showMessageDialog(null,"Feed the fish in this aquaponics system according to color by aiming pellets at them and turning their bars green.");
                JOptionPane.showMessageDialog(null,"Click on the container to change color. Use arrow keys to move. r rotates to the left. t rotates to the right. s releases food.");
                JOptionPane.showMessageDialog(null, "You can only drop more food after the previous pellet has been eaten or goes beyond feeding range.");
                JOptionPane.showMessageDialog(null,"Aqua.Food of the wrong color or food not dropped in the right place will not be eaten, which will increase ammonia levels.");
                JOptionPane.showMessageDialog(null,"Too much ammonia will kill the fish and shut down the system!");
                JOptionPane.showMessageDialog(null,"Feeding all fish will not produce too much ammonia, but fish health will be improved, and plants can grow through nutrient absorption..");
            }
        }
        if(go == 0){
            if(k.getKeyCode() == 83){
                q = blue.getX();
                v = blue.getY();
                m[l].fall(q+10,v,r);
                l++;
                n = 1;
            }
        }

    }

    public void keyPressed(KeyEvent k){
        if(move == 0){
            if(k.getKeyCode() == 37){
                blue.left();
            }
            if(k.getKeyCode() == 38){
                blue.up();
            }
            if(k.getKeyCode() == 39){
                blue.right();
            }
            if(k.getKeyCode() == 40){
                blue.down();
            }

            if(k.getKeyCode() == 82){
                if (r >= -3.14){
                    r-=0.195;
                }
                else if(r<-3.14){
                    r = 3.14;
                }
            }
            else if(k.getKeyCode() == 84){
                if(r <= 3.14){
                    r+=0.195;
                }
                else if(r>3.14){
                    r = -3.14;
                }
            }
        }
    }

    public void keyTyped(KeyEvent k){}

    public void mouseClicked(MouseEvent m){
        if(move == 0){
            if(blue.getRectangle().contains(m.getPoint())){
                blue.change(lab);
                lab++;
                if(lab>=3){
                    lab = 0;
                }
            }
        }
    }

    public void mousePressed(MouseEvent m){}

    public void mouseReleased(MouseEvent m){}

    public void mouseEntered(MouseEvent m){}

    public void mouseExited(MouseEvent m){}
}
