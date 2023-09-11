package Nyersanyag;

import java.util.ArrayList;
import java.util.Random;
import Etel.*;

/**
 * Hordo osztaly
 * @author hb
 * @version 1.0
 * A hordo osztalybol jon majd letre a hordo objektum. A hordo specialis helyzetben van, mivel tovabbi nyersanyagok+burgonya lehet benne
 * ket listat hozok letre, az egyikben a nyersanyagokat, a masikban a burgonyat tarolom.
 */
public class Hordo extends Nyersanyag{
    public ArrayList<Nyersanyag> hordobanNyersanyag = new ArrayList<Nyersanyag>();
    public ArrayList<Etel> hordobanBurgonya = new ArrayList<Etel>();
    public Hordo(int nyersanyagTavolsag, String tipus, int x, int y) {
        super(nyersanyagTavolsag, tipus, x, y);
        mennyiseg = 0;
    }

    /**
     * hordoFeltoltes metodus
     * @author hb
     * @param ny a Nyersanyag osztaly nyersanyagGeneralas metodusaban legeneralt nyersanyagot atadom ennek a metodusnak, es hozzaadom a nyersanyagokat tarolo listahoz.
     */
    public void hordoFeltoltes(Nyersanyag ny){
        hordobanNyersanyag.add(ny);
    }
    /**
     * hordoFeltoltesBurgonya metodus
     * @author hb
     * @param e a Nyersanyag osztaly nyersanyagGeneralas metodusaban legeneralt burgonyat atadom ennek a metodusnak, es hozzaadom a burgonyakat tarolo listahoz.
     */
    public void hordoFeltoltesBurgonya(Etel e) {
        hordobanBurgonya.add(e);
    }



}
