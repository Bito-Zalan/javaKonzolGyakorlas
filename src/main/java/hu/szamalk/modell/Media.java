package hu.szamalk.modell;

import java.util.UUID;

public class Media {
    //1,adattagok létrehozása(ezek még az öröklődő fájlok megirása előtt)
    private UUID id;
    private String szerzo;


    //2,konstruktornak minden adattagot inicializálnia kell (szintén öröklődő fájlok megírása előtt)
    public Media(String szerzo) {
        this.szerzo = szerzo;
        //id = UUID.randomUUID(); setter megoldja , meghivom ehelyett a settert.
        setId();
        //itt is dobhatunk saját kivételt**
        //itt ujság és könyv probléma lesz,
    }

    //3,kellenek getterek
    public UUID getId() {
        return id;
    }

    public String getSzerzo() {
        return szerzo;
    }

    //itt pl akarunk settert csinálni
    //id-re saját settert kell irni
    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
        //itt is dobhatunk saját kivételt pl ha a szerző nem megfelelő**
    }
}
