package hu.szamalk.nezet;

import hu.szamalk.modell.Konyvtar;

import java.io.IOException;

//ehhez a többi fájl után nyulunk.
public class Konzol {

    //1, main létrehozása
    public static void main(String[] args) {
        new Konzol();
    }

    public Konzol(){
        //2,létrehozzuk a konyvtárat majd beállitjuk a metódusait
        Konyvtar k = new Konyvtar();
        //k.kiadottKonyvek2000UtanFajlban();// ha ennél a feladatnál a továbbdobást kell csinálni, akkor ezt  try/catch-be kell tenni.
        //try/catch-be rakva:
        try {
            k.kiadottKonyvek2000UtanFajlban();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cim: " + k.legfiatalabbKonyvCime());
    }
}
