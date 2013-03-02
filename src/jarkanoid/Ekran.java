/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkanoid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tomasz Siuchniński
 */
public class Ekran extends JPanel implements Runnable {

    private Plytka plytka;
    private ArrayList<Kulka> kulki;
    private ArrayList<Blok> bloki;
    private ArrayList<BufferedImage> plytkiImg;
    private ArrayList<BufferedImage> kulkiImg;
    private ArrayList<BufferedImage> blokiImg;
    private boolean start;
    private int zniszczone;
    private int cel;
    private Okno okno;
     

    Ekran(int cel, Plytka plytka, ArrayList<Kulka> kulki, ArrayList<Blok> bloki, Okno okno) throws IOException, InterruptedException {

        this.setDoubleBuffered(true);
        start = false;
        
        plytkiImg = new ArrayList<>();
        plytkiImg.add(ImageIO.read(new File("stdp.bmp")));
        kulkiImg = new ArrayList<>();
        kulkiImg.add(ImageIO.read(new File("stdb.bmp")));
        blokiImg = new ArrayList<>();
        blokiImg.add(ImageIO.read(new File("block1.bmp")));

        this.okno = okno;
        this.kulki = kulki;
        this.bloki = bloki;
        this.cel = cel;
        this.setSize(800, 600);
        this.plytka = plytka;



        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
                formMouseClicked(evt);
            }
        });
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                formMouseClicked(evt);
            }
        });

    }

    
    public int getZniszczone() {
        return zniszczone;
    }

    public void setZniszczone(int zniszczone) {
        this.zniszczone = zniszczone;
    }

    public int getCel() {
        return cel;
    }

    public void setCel(int cel) {
        this.cel = cel;
    }

    @Override
    public void paintComponent(Graphics g) {
       
        BufferedImage buff = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = buff.createGraphics();
        
        g2.drawRect(0, 0, 800, 600);
        for (Kulka k : kulki) {
            g2.drawImage(kulkiImg.get(k.getTyp()), (int) (k.getX() - k.getSize() / 2), (int) (k.getY() - k.getSize() / 2), null);
        }
        for (Blok b : bloki) {
            if (!b.isZniszczony()) {
                g2.drawImage(blokiImg.get(0), (int) (b.getX()), (int) (b.getY()), null);
            }

        }

        g2.drawImage(plytkiImg.get(0), plytka.getX() - 50, 535, null);
        
        g.drawImage(buff, 0, 0, null);
    }

    private void formMouseMoved(java.awt.event.MouseEvent evt) {
        if (evt.getX() > plytka.getWidth() / 2 && evt.getX() < this.getWidth() - plytka.getWidth() / 2) {
            plytka.setX(evt.getX());
        } else {
            if (evt.getX() < plytka.getWidth() / 2 + 1) {
                plytka.setX(plytka.getWidth() / 2);
            } else {
                plytka.setX(this.getWidth() - plytka.getWidth() / 2);
            }

        }


    }
    
     private void formMouseClicked(java.awt.event.MouseEvent evt) {
        start=true;
        kulki.get(0).setVx(-2);
        kulki.get(0).setVy(2);
    }
    @Override
    public void run() {
        while (zniszczone<cel && kulki.get(0).getY()<600) {
            try {
                Thread.sleep(5);
                
                if (!start) {
                    kulki.get(0).setX(plytka.getX()+20);
                    kulki.get(0).setY(540-kulki.get(0).getSize());
                } else {


                    for (Kulka k : kulki) {
                        if (k.getY() + k.getSize() < 540 + k.getSize() / 2 && k.getY() + k.getSize() + k.getVy() > 540 + k.getSize() / 2 && plytka.getX() - plytka.getWidth() / 2 < k.getX() + k.getSize() && plytka.getX() + plytka.getWidth() / 2 > k.getX()) {
                            k.odbij('|');
                            double kier = ((k.getX() + k.getSize()) - (plytka.getX())) / plytka.getWidth();
                            //if (kier<0) 
                            kier = -kier;
                            k.setVx(2 * kier * k.getVy());
                        }  //DOPRACOWAĆ!!!


                        if (k.getY() - k.getSize()/2 + k.getVy() < 0 - k.getSize() / 2) {
                            k.odbij('|');
                        }

                        if (k.getX() - k.getSize()/2 + k.getVx() < 0 - k.getSize() / 2) {
                            k.odbij('-');
                        }
                        if (k.getX() + k.getSize()/2 + k.getVx() > 800) {
                            k.odbij('-');
                        }

                        for (Blok b : bloki) {
                            if (!b.isZniszczony()) {
                                if (b.hitTest(k.getX() + k.getSize() / 2 + k.getVx(), k.getY() - k.getSize()/2 + k.getVy())) {
                                    //if(k.getY()+k.getSize()/2>b.getY()+b.getHeight()){
                                    k.odbij('|');
                                    //}
                                    b.uderz();
                                    zniszczone++;
                                } else if (b.hitTest(k.getX() + k.getSize() / 2 + k.getVx(), k.getY() + k.getSize()/2 + k.getVy())) {
                                    //if(k.getY()+k.getSize()/2<b.getY()){
                                    k.odbij('|');
                                    //}
                                    b.uderz();
                                    zniszczone++;
                                } else if (b.hitTest(k.getX() - k.getSize()/2 + k.getVx(), k.getY() + k.getSize() / 2 + k.getVy())) {
                                    // if(k.getX()+k.getSize()/2>b.getX()+b.getWidth()){
                                    k.odbij('-');
                                    //}
                                    b.uderz();
                                    zniszczone++;
                                } else if (b.hitTest(k.getX() + k.getVx()/2, k.getY() + k.getSize() / 2 + k.getVy())) {
                                    //if(k.getX()+k.getSize()/2<b.getX()){
                                    k.odbij('-');
                                    //}
                                    b.uderz();
                                    zniszczone++;
                                }
                            }
                        }

                        k.setY(k.getY() + k.getVy());
                        k.setX(k.getX() + k.getVx());
                    }
                }
                this.repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ekran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        okno.remove(this);
        okno.getMenu().setVisible(true);
    }
}
