package hu.szamalk.modell;


//ujság öröklődik a médiából extends
public class Ujsag extends Media{
    //szülő fájl konstruktora után hibás, piros vonalra kattintva legeneráltatjuk a constructort.
    public Ujsag(String szerzo) {
        super(szerzo);
    }

}
