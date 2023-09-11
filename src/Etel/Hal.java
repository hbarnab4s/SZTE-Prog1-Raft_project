package Etel;

import Jatekmenet.*;

import java.util.*;
import java.util.Map.Entry;

/**
 * Hal osztaly
 * @author hb
 * @version 1.0
 * A halakat a tengerbol lehet kifogni. Ebben az osztalyban valositom meg azt a metodust, ami a hal kifogasara/nem kifogasara szolgal
 */
public class Hal extends Etel{
    protected int halmennyiseg;
    private boolean tudokhalaszni = true;
    public Hal(String nev, int ehsegCsillapitas) {
        super(nev, ehsegCsillapitas);
        this.halmennyiseg = 0;
    }

    public boolean isTudokhalaszni() {
        return tudokhalaszni;
    }

    public void setTudokhalaszni(boolean tudokhalaszni) {
        this.tudokhalaszni = tudokhalaszni;
    }

    public int getHalmennyiseg() {
        return halmennyiseg;
    }

    public void setHalmennyiseg(int halmennyiseg) {
        this.halmennyiseg = halmennyiseg;
    }

    /**
     * horgaszik metodus
     * @author hb
     * eloszor egy random szamot hozok letre, ami 0-9999 kozott van.
     * amennyiben a szam 0-2499 kozott van, akkor sikerult kifogni egy halat, egyebkent nem
     * lekezelem azt is, hogy a karakter a vizben all-e
     */
    public void horgaszik(){
        for(Pozicio elem : Jatek.tutaj.tutajpoziciok) {
            if(Jatek.jatekos.getJatekosX() == elem.getMagassag() && Jatek.jatekos.getJatekosY() == elem.getSzelesseg()) {
                this.tudokhalaszni = false;
                break;
            } else{
                this.tudokhalaszni = true;
            }
        }
        if(!tudokhalaszni) {
            System.out.println("Itt sajnos nem lehet halat fogni. Menj ki a vizbe!");
        }
        if(tudokhalaszni) {
            Random random = new Random();
            int randomszam = random.nextInt(10000);
            if(randomszam < 2500) {
                this.halmennyiseg++;
                System.out.println("Gratulalok, kifogtal egy halat!");
            }else {
                System.out.println("Sajnos most nem sikerult halat fognod.");
            }
        }
    }
}
