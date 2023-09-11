package Jatekmenet;

import java.util.*;

/**
 * Capa osztaly
 * @author hb
 * @version 1.0
 * A Capa osztalyban hozok letre minden metodust, ami a capaval kapcsolatos. A mozgasa, ha vegez a karakterrel, stb.
 */
public class Capa {
    private int capaX;
    private int capaY;
    private int kivedett;

    public Capa(){
        this.capaX = 17;
        this.capaY = 18;
    }

    public int getCapaX() {
        return capaX;
    }

    public void setCapaX(int capaX) {
        this.capaX = capaX;
    }

    public int getCapaY() {
        return capaY;
    }

    public void setCapay(int capaY) {
        this.capaY = capaY;
    }

    public void setCapaY(int capaY) {
        this.capaY = capaY;
    }

    public int getKivedett() {
        return kivedett;
    }

    public void setKivedett(int kivedett) {
        this.kivedett = kivedett;
    }

    /**
     * capaElhelyezes metodus
     * @author hb
     * A capat elhelyezi a kezdeti pociciojan.
     */
    public void capaElhelyezes(){
        Jatek.palya.tomb[this.capaX][this.capaY] = "CCC ";
    }

    public boolean capaKill(){
        if(capaX == Jatek.jatekos.getJatekosX() && capaY == Jatek.jatekos.jatekosY && !Jatek.landzsa.isVanLandzsa()){
            return true;
        } else if(capaX == Jatek.jatekos.getJatekosX() && capaY == Jatek.jatekos.jatekosY && Jatek.landzsa.isVanLandzsa() && this.kivedett <= 5) {
            this.kivedett++;
            return false;
        } else if (capaX == Jatek.jatekos.getJatekosX() && capaY == Jatek.jatekos.jatekosY && Jatek.landzsa.isVanLandzsa() && this.kivedett > 5) {
            return true;
        }
        return false;
    }

    public void capaMozgas(){
        Random random = new Random();
        int randomX = random.nextInt(3);
        int randomY = random.nextInt(3);
        if(Math.abs(Jatek.tutaj.getTutajXpoz()-capaX) < 7 && Math.abs(Jatek.tutaj.getTutajXpoz()-capaX) > 2 && Math.abs(Jatek.tutaj.getTutajYpoz()-capaY) < 7 && Math.abs(Jatek.tutaj.getTutajYpoz()-capaY) > 2) {
            if(Jatek.tutaj.getTutajXpoz()-capaX > 0 && Jatek.tutaj.getTutajYpoz()-capaY > 0){

            }
            if(randomX == 1) {
                Jatek.palya.tomb[this.capaX][this.capaY] = "*** ";
                this.capaX = this.capaX-1;
            }
            else if(randomX == 2) {
                Jatek.palya.tomb[this.capaX][this.capaY] = "*** ";
                this.capaX = this.capaX+1;
            }
            if(randomY == 1) {
                Jatek.palya.tomb[this.capaX][this.capaY] = "*** ";
                this.capaY = this.capaY-1;
            }
            else if(randomY == 2) {
                Jatek.palya.tomb[this.capaX][this.capaY] = "*** ";
                this.capaY = this.capaY+1;
            }
        } else if(Jatek.tutaj.getTutajXpoz()-capaX > 0 && Jatek.tutaj.getTutajYpoz()-capaY > 0) {
            Jatek.palya.tomb[this.capaX][this.capaY] = "*** ";
            this.capaX = this.capaX +1;
            this.capaY = this.capaY-1;
        } else if(Jatek.tutaj.getTutajXpoz()-capaX < 0 && Jatek.tutaj.getTutajYpoz()-capaY < 0) {
            Jatek.palya.tomb[this.capaX][this.capaY] = "*** ";
            this.capaX = this.capaX-1;
            this.capaY = this.capaY+1;
        } else {
            return;
        }
    }
}
