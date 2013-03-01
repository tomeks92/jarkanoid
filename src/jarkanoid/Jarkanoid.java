/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkanoid;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Tomasz Siuchniński
 */
public class Jarkanoid {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Plytka plytka;
        Ekran ekran;
        Okno okno;
        ArrayList<Kulka> kulki;
        ArrayList<Blok> bloki;
        
        plytka = new Plytka();
        kulki = new ArrayList<>();
        kulki.add(new Kulka());
        bloki = new ArrayList<>();
        bloki.add(new Blok(200, 250, 0));
        ekran = new Ekran(plytka,kulki,bloki);
        new Thread(ekran).start();
                 
        okno = new Okno(plytka,kulki,bloki);
        okno.add(ekran);  
    }
}
