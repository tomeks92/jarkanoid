/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkanoid;

/**
 *
 * @author Tomasz Siuchniński
 */
public class Plytka {
    private int x;
    private int width;

    
    public Plytka() {
        x=400;
        width = 100;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    
}
