package Nyersanyag;

import java.util.Random;

/**
 * Deszka osztaly
 * @author hb
 * a tengerben es a hordoban is nyersanyagok generalodnak. az egyik a deszka. Ebbol az osztalybol keszulnek el az objektumok, ez az osztaly a Nyersanyag osztaly gyerekosztalya.
 */
public class Deszka extends Nyersanyag{
    public Deszka(int nyersanyagTavolsag, String tipus, int x, int y) {
        super(nyersanyagTavolsag, tipus, x, y);
        mennyiseg = 0;
    }

}
