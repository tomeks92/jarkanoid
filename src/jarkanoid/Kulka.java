/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkanoid;

/**
 *
 * @author Tomasz
 */
public class Kulka {
    private int size;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double a;
    private int typ;

    public Kulka() {
        this.x = 100;
        this.y = 100;
        typ = 0;
        size = 10;
        this.vx = 0;
        this.vy = 0;
    }
    
    

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }
    
    public void odbij(char kier){
        if (kier=='|') vy=-vy;
        if (kier=='-') vx=-vx;
    }
}
