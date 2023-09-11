package Jatekmenet;

import java.util.Map;
import java.util.Random;
import Palya.*;
import Etel.*;
import Nyersanyag.*;
import Jatekmenet.*;

/**
 * Jatekos osztaly
 * @version 1.0
 * @author hb
 * int szomjusag: alaperteke 100, minden cselekvessel csokken 1-et
 * int ehseg: alaperteke 100, minden cselekvessel csokken 1-et
 * int jatekosX: a karakter pozicioja magassag szempontjabol
 * int jatekosY: a karakter pozicioja szelesseg szempontjabol
 */

public class Jatekos {
    protected int szomjusag;
    protected int ehseg;
    protected int jatekosX;
    protected int jatekosY;

    public Jatekos(int jatekosX, int jatekosY){
        this.szomjusag = 100;
        this.ehseg = 100;
        this.jatekosX = jatekosX;
        this.jatekosY = jatekosY;
    }


    public int getJatekosX() {
        return jatekosX;
    }

    public void setJatekosX(int jatekosX) {
        this.jatekosX = jatekosX;
    }

    public int getJatekosY() {
        return jatekosY;
    }

    public void setJatekosY(int jatekosY) {
        this.jatekosY = jatekosY;
    }

    public int getSzomjusag() {
        return szomjusag;
    }

    public void setSzomjusag(int szomjusag) {
        this.szomjusag = szomjusag;
    }

    public int getEhseg() {
        return ehseg;
    }

    public void setEhseg(int ehseg) {
        this.ehseg = ehseg;
    }

    /**
     * jatekosMegjelenites metodus
     * @author hb
     * elhelyezi a palyan a karaktert. ezt a metodust meg kell hivni a Jatek osztaly main fuggvenyeben
     */
    public void jatekosMegjelenites(){
        Jatek.palya.tomb[this.jatekosX][this.jatekosY] = "KKK ";

    }

    /**
     * mozgasSegedMetodus
     * @author hb
     * ezt minden mozgassal kapcsolatos metodus (ld lejjebb) meg kell hivni, ez felel azert, hogy a karakter mozgatasa megfeleloen mukodjon
     */
    public void mozgasSegedMetodus(){
        //Jatek.palya.tomb[this.jatekosX][this.jatekosY] = Jatek.palya.tombMasolat[this.jatekosX][this.jatekosY];
        Jatek.palya.tomb[this.jatekosX][this.jatekosY] = "*** ";
        Jatek.tutaj.tutajSeged();
    }

    /**
     * eleteroCsokkentes
     * @author hb
     * ezt minden cselekvesnel meg kell hivni, mivel a jatek eloirasa, hogy minden cselekvessel csokkent egyet mind a karakter ehsege, mind a szomjusaga (tehat ehesebb es szomjasabb lesz
     */
    public void eleteroCsokkentes(){
        this.szomjusag--;
        this.ehseg--;
    }

    /**
     * mozgasfel metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole feljebb levo elemre
     */
    public void mozgasfel(){
        mozgasSegedMetodus();
        this.jatekosX = this.jatekosX-1;
        eleteroCsokkentes();
    }
    /**
     * mozgasle metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole lejjebb levo elemre
     */
    public void mozgasle(){
        mozgasSegedMetodus();
        this.jatekosX = this.jatekosX+1;
        eleteroCsokkentes();
    }
    /**
     * mozgasjobbra metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole jobbra levo elemre
     */
    public void mozgasjobbra(){
        mozgasSegedMetodus();
        this.jatekosY = this.jatekosY+1;
        eleteroCsokkentes();
    }
    /**
     * mozgasbalra metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole balra levo elemre
     */
    public void mozgasbalra(){
        mozgasSegedMetodus();
        this.jatekosY = this.jatekosY-1;
        eleteroCsokkentes();
    }
    /**
     * mozgasAtlosanFelJobbra metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole atlosan felfele es jobbra levo elemre
     */
    public void mozgasAtlosanFelJobbra(){
        mozgasSegedMetodus();
        this.jatekosX = this.jatekosX-1;
        this.jatekosY = this.jatekosY+1;
        eleteroCsokkentes();
    }
    /**
     * mozgasAtlosanFelBalra metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole atlosan felfele es balra levo elemre
     */
    public void mozgasAtlosanFelBalra(){
        mozgasSegedMetodus();
        this.jatekosX = this.jatekosX-1;
        this.jatekosY = this.jatekosY-1;
        eleteroCsokkentes();
    }
    /**
     * mozgasAtlosanLeJobbra metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole atlosan lefele, jobbra levo elemre
     */
    public void mozgasAtlosanLeJobbra(){
        mozgasSegedMetodus();
        this.jatekosX = this.jatekosX+1;
        this.jatekosY = this.jatekosY+1;
        eleteroCsokkentes();
    }
    /**
     * mozgasAtlosanLeBalra metodus
     * @author hb
     * amennyiben ezt a metodust meghivjuk a Jatek osztaly main fuggvenyeben, akkor a karakter athelyezodik a tole atlosan lefele, balra levo elemre
     */
    public void mozgasAtlosanLeBalra(){
        mozgasSegedMetodus();
        this.jatekosX = this.jatekosX+1;
        this.jatekosY = this.jatekosY-1;
        eleteroCsokkentes();
    }

    /**
     * eszik metodus
     * @author hb
     * ha az eszik metodust meghivjuk a Jatek osztaly main fuggvenyeben, a karakter ehseget reprezentalo ertek 60-nal no. amennyiben igy 100 fole emelkedne az ertek, akkor mindenkeppen csak 100 lesz
     */
    public void eszik(){
        for(Pozicio elem : Jatek.tuzhely.tuzhelypoziciok) {
            if(Jatek.jatekos.getJatekosX() == elem.getMagassag() && Jatek.jatekos.getJatekosY() == elem.getSzelesseg() && Jatek.tuzhely.getElteltLepes() >=25) {
                this.ehseg += 60;
                if(this.ehseg > 100) {
                    this.ehseg = 100;
                }
                Jatek.tuzhely.setElteltLepes(0);
                eleteroCsokkentes();
            } else {
                System.out.println("Sajnos meg nem eheted meg a tuzhelyen keszulo etelt. ");
                eleteroCsokkentes();
            }
        }
    }
    /**
     * iszik metodus
     * @author hb
     * ha az iszik metodust meghivjuk a Jatek osztaly main fuggvenyeben, a karakter szomjusagat reprezentalo ertek 40-nel no. amennyiben igy 100 fole emelkedne az ertek, akkor mindenkeppen csak 100 lesz
     */
    public void iszik(){
        for(Pozicio elem : Jatek.tisztito.tisztitopoziciok) {
            if(Jatek.jatekos.getJatekosX() == elem.getMagassag() && Jatek.jatekos.getJatekosY() == elem.getSzelesseg() && Jatek.tisztito.getElteltLepesek() >=25) {
                this.szomjusag += 40;
                if(this.szomjusag > 100) {
                    this.szomjusag = 100;
                }
                Jatek.tisztito.setElteltLepesek(0);
                eleteroCsokkentes();
            } else {
                System.out.println("Sajnos meg nem sikerult megtisztitani egy teljes pohar vizet, terj vissza kesobb. Ne feledd, az ivashoz a viztisztito poziciojara kell allnod!");
                eleteroCsokkentes();
            }
        }
    }
}
