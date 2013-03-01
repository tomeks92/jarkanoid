/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkanoid;

/**
 *
 * @author Tomasz Siuchniński
 */
public class Blok {
    private int x;
    private int y;
    private int width;
    private int height;
    private int bonus;
    private boolean zniszczony;
    
    Blok(int x, int y, int bonus){
        this.x = x;
        this.y = y;
        this.width = 35;
        this.height = 20;
        zniszczony = false;
        if (bonus == -1){
            
        } else {
            this.bonus=bonus;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public boolean isZniszczony() {
        return zniszczony;
    }

    public void setZniszczony(boolean zniszczony) {
        this.zniszczony = zniszczony;
    }
    
    public boolean hitTest(double x, double y){
        if((x>this.x&&x<(this.x+width))&&(y>this.y&&y<(this.y+height))){
            return true;
        } else{
            return false;
        }
    }
    
    public int uderz(){
        zniszczony = true;
        return bonus;
    }
}
