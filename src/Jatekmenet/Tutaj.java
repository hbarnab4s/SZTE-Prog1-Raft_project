package Jatekmenet;
import Etel.*;
import Nyersanyag.*;
import Palya.*;

import java.util.*;

public class Tutaj {
    private int szelessegTutaj;
    private int magassagTutaj;
    private int tutajXpoz;
    private int tutajYpoz;
    public ArrayList<Pozicio> tutajpoziciok = new ArrayList<>();
    public Tutaj() {
        this.szelessegTutaj = 2;
        this.magassagTutaj = 2;
    }

    public Tutaj(int szelessegTutaj, int magassagTutaj) {
        this.szelessegTutaj = szelessegTutaj;
        this.magassagTutaj = magassagTutaj;
    }

    public int getSzelessegTutaj() {
        return szelessegTutaj;
    }

    public int getMagassagTutaj() {
        return magassagTutaj;
    }

    public void setSzelessegTutaj(int szelessegTutaj) {
        this.szelessegTutaj = szelessegTutaj;
    }

    public void setMagassagTutaj(int magassagTutaj) {
        this.magassagTutaj = magassagTutaj;
    }

    public int getTutajXpoz() {
        return tutajXpoz;
    }
    public void setTutajXpoz(int tutajXpoz) {
        this.tutajXpoz = tutajXpoz;
    }
    public int getTutajYpoz() {
        return tutajYpoz;
    }
    public void setTutajYpoz(int tutajYpoz) {
        this.tutajYpoz = tutajYpoz;
    }
    /**
     * tutajEpites metodus
     * @author hb
     * @param tutajSzelesseg a tutaj szelessege a tombben (ami a tenger)
     * @param tutajMagassag a tutaj magassaga a tombben (ami a tenger)
     * a metodus elhelyi a megadott szelessegu, magassagu tutajt a tengeren, a palya kozepere
     */

    public void tutajEpites(int tutajSzelesseg, int tutajMagassag){
        int szelessegFele = Jatek.palya.getSzelesseg()/2;
        int magassagFele = Jatek.palya.getMagassag()/2;
        Jatek.palya.tomb[magassagFele-1][szelessegFele-1] = "--- ";
        Jatek.palya.tomb[magassagFele-1][szelessegFele] = "--- ";
        Jatek.palya.tomb[magassagFele][szelessegFele-1] = "--- ";
        Jatek.palya.tomb[magassagFele][szelessegFele] = "--- ";
        tutajpoziciok.add(new Pozicio(magassagFele-1, szelessegFele-1));
        tutajpoziciok.add(new Pozicio(magassagFele-1, szelessegFele));
        tutajpoziciok.add(new Pozicio(magassagFele, szelessegFele-1));
        tutajpoziciok.add(new Pozicio(magassagFele, szelessegFele));

    }

    public void tutajtBovit(){
        if(Jatek.jatek.getDeszkadb() >= 2 && Jatek.jatek.getLeveldb() >= 2) {
            Jatek.palya.tomb[Jatek.jatekos.getJatekosX()-1][Jatek.jatekos.getJatekosY()] = "--- ";
            tutajpoziciok.add(new Pozicio(Jatek.jatekos.getJatekosX()-1, Jatek.jatekos.getJatekosY()));
            Jatek.jatek.setDeszkadb(Jatek.jatek.getDeszkadb()-2);
            Jatek.jatek.setLeveldb(Jatek.jatek.getLeveldb()-2);
            Jatek.jatekos.eleteroCsokkentes();
        }
    }


    public void tutajSeged() {
        for(Pozicio elem : tutajpoziciok) {
            Jatek.palya.tomb[elem.getMagassag()][elem.getSzelesseg()] = "--- ";
        }
        for(Pozicio elem : Jatek.halo.halopoziciok) {
            Jatek.palya.tomb[elem.getMagassag()][elem.getSzelesseg()] = "HAO ";
        }
        for(Pozicio elem : Jatek.tisztito.tisztitopoziciok) {
            Jatek.palya.tomb[elem.getMagassag()][elem.getSzelesseg()] = "VVV ";
        }
        for(Pozicio elem : Jatek.tuzhely.tuzhelypoziciok) {
            Jatek.palya.tomb[elem.getMagassag()][elem.getSzelesseg()] = "TTT ";
        }
    }
}
