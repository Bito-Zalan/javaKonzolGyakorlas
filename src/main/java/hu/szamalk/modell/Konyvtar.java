package hu.szamalk.modell;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

//ebbena fájlban nincsenek system outok.

//média,konyv,ujság megkezdése után kezdjük ezt a filet.

//ha az a feladat hogy a könyvtár kitudja irni magát fileba akkor implements Serializable
public class Konyvtar implements Serializable {
    //1,adattagok létrehozása list importálása:util
    private List<Media> mediak;
    //fájlbeolvasáshoz akár 1 másik megoldás ***
    private List<Konyv> konyvek;

    //2,üres kstr
    public Konyvtar() { //10,ahhoz hogy használjuk  a konstruktort beállitjuk a Konzol fájlba. go Konzol.java
        //3,médiák beállítása üresre először
        mediak = new ArrayList<>();
        konyvek = new ArrayList<>(); //ez akkor kell ha fent nem mediak-at hanem konyvek-et használunk.
        //4,
        feltoltFajlbol();
    }

    //serializable után || //grafikus felületen is megcsináltuk
    public void konyvtarTartalmatBinarisFajlbaMent(){
        //try with resources szerkezet kellene ide de nem fejezzük be ezt a feladatot jelen esetben.
        /*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fajl.dat"));
        oos.writeObject(this);//Konzol.java-ban lévő k az ez a this*/
    }

    //5,fájl beolvasása
    private void feltoltFajlbol() {
        /*Files.readAllLines(Path.of("konyvek.txt"));
        itt aláhuzza a readalllinest, rákattintunk,
        feladat leirás alapján kivétel dobhatunk,
        vagy try catch-be tehetjük.*/
        try {
            //kezdőpont : sorok = Files.readAllLines(Path.of("konyvek.txt")); majd itt az aláhuzásra kattinva create local variable 'sorok'
            /*eredmény: */List<String>sorok = Files.readAllLines(Path.of("konyvek.txt"));
            //ezután feltöltés
            //sorok.for ciklus generálás
            for (String sor : sorok) {
                //köynveket olvasunk be tehát könyveket adunk hozzá.
                //mediak.add(new Konyv("szerző1","cim1"));
                //könyves másikmegoldás***
                //konyvek.add(new Konyv("szerző1","cim1")); file előtti
                /*konyvek.add(new Konyv(sor));//11 file.txt megírása után, ezután a sor létrehozás után a konyvben kell
                 egy uj kstr.de más megoldást csinálumk.*/
                //másik megoldás uj kstr helyett:
                String[] s = sor.split(";");
                String szerzo = s[0]; // első elem a fileban
                String cim = s[1]; // második elem a fileban
                int ev = Integer.parseInt(s[2]); //harmadik elem a fileban
                //utána létrehozunk egy uj könyvet
                konyvek.add(new Konyv(szerzo,cim,ev));
            }
        } catch (IOException e) {
            //akár itt is dobhatjuk a saját kivételt** ha a beolvasásnál kell
            throw new RuntimeException(e);
        }
    }

    //6,metódus ami visszaad egy listát ||getKonyvek metódus
    public List<Konyv> getKonyvek(){
        //itt azért példányositjuk hogy végig tudjunk menni rajta (ha nincs még máshol példányositva)
        //List<Konyv> konyvek = new ArrayList<>(); ez nem kell ha fent is beállitjuk adattagként
        //végig kell menni a médiákon
        for (Media media : mediak) {
            if (media instanceof Konyv) {//ha az adott média Könyv{
                //konyvek.add(media); ezt át castoljuk
                konyvek.add((Konyv) media);
            }
        }
        return konyvek;
    }
    //7,mivel tudjuk h van a könyvnek rendezése ezért uj példafeladat:a könyvnek lesz
    public List<Konyv> getKonyvekKiadasSzerintRendezve(){
        //List<Konyv> konyvek = getKonyvek();
        Collections.sort(konyvek);
        return konyvek;
    }

    //8. példa:
    public String legfiatalabbKonyvCime(){
        //List<Konyv> konyvek = getKonyvek();
        Konyv legfiatalabb = Collections.max(konyvek);
        return legfiatalabb.getCim();
        //vagy megadjuk a könyv legelső elemének a cimét nemfix de a semmitől jobb
        //return konyvek.get(0).getCim();
    }

    //8 ellentéte
    public String legregebbiKonyvCime(){
        //List<Konyv> konyvek = getKonyvek(); // ha sokszor van szükség erre a sorra akkor fájl tetején irjuk be adattagként a könyvek-et.
        Konyv legregebbi = Collections.min(konyvek);
        return legregebbi.getCim();
    }

    //9. példa
    public void kiadottKonyvek2000UtanFajlban() throws IOException {
        String kiIrTartalomString = ""; // fel kell tölteni, ez feladat.
        List<String> kiIrTartalomLista = new ArrayList<>(); // fel kell tölteni, ez feladat.
        Files.write(Path.of("kiadott2000UtaniKonyvek.txt"),kiIrTartalomString.getBytes());//itt aláhuzza a writeot,
        // rákattintva továbbdobjuk vagy try catchbe tesszük, feladat függő.
        //másik kiirás:
        Files.write(Path.of("kiadott2000UtaniKonyvek.txt"),kiIrTartalomLista);


    }

    //4,ha a feladat aztmondja: uj médiát felveszünk
    public void ujMediatFelvesz(Media media){
        mediak.add(media); // igy már ehhez a könyvtárhoz hozzá tudunk adni bármilyen médiát ami ugye könyv vagy ujság lehet az öröklődés miatt.

    }
}
