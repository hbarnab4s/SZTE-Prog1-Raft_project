package Nyersanyag;

import java.util.Random;

/**
 * Hulladek osztaly
 * @author hb
 * @version 1.0
 * a tengerben es a hordoban is nyersanyagok generalodnak. az egyik a hulladek. Ebbol az osztalybol keszulnek el az objektumok, ez az osztaly a Nyersanyag osztaly gyerekosztalya.
 */
public class Hulladek extends Nyersanyag{
    public Hulladek(int nyersanyagTavolsag, String tipus, int x, int y) {
        super(nyersanyagTavolsag, tipus, x, y);
        mennyiseg = 0;
    }
}
