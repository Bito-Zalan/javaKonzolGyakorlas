package hu.szamalk.modell;


//szintén öröklődik a médiából || 4,szeretném ha a könyv rendezhető lenne : implements Comparable
public class Konyv extends Media implements Comparable<Konyv>{ //comparable irás után aláhuzza, itt implement methods
    //1,itt például megadunk saját adattagokat is
    private int kiadasiEv;
    private String cim;

    //3,pl nem adunk kiadásiévet, és ebben az esetben az alapértelmezett értéke 2000 ( ezt az öröklős cstr után ha kell)
    public Konyv(String szerzo, String cim) { //hozzáadunk még kézzel paramétert
       this(szerzo,cim,2000);

    }

    //konyvek.txt és a konyvtar ujsor(42.) megirása után hiba kijavitása, de más megoldást csinálunk
    /*public Konyv(String sor){
        String[] s = sor.split(";");
    }*/

    //2,itt akartunk adni még saját adattagot, és ezután generáltatjuk a constructort pirosvonalra kattintva. (ezis öröklődik médiából)
    public Konyv(String szerzo, String cim, int kiadasiEv) { //hozzáadunk még kézzel paramétert
        super(szerzo);
        //itt pedig beállitjuk a saját adattagokat
        this.cim = cim;
        this.kiadasiEv = kiadasiEv;
        //itt is dobhatunk saját kivételt nem cask a médiába
    }

    //5,az osztálynak szüksége lesz gettere
    public int getKiadasiEv() {
        return kiadasiEv;
    }

    public String getCim() {
        return cim;
    }

    //setter a leirás alapján (hogy kell e vagy nem)

    //4 folytatása,implements method után létrejött
    @Override
    public int compareTo(Konyv masik) {
        //alapértelmezett rendezés szempont: cim   <-- String tipusu
        //return this.cim.compareTo(masik.cim);
        //alapértelmezett rendezés szempont: kiadasiEv <-- int tipusu
        return this.kiadasiEv - masik.kiadasiEv;

        //egyéb rendezési szempont: Comparator<Kony> de másik osztályban
    }
}
