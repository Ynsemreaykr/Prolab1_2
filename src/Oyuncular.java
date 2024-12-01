import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Oyuncular {
    private int oyuncuID;
    private String oyuncuAdi;
    private int skor;
    private List<SavasAraclari> kartListesi;

    public Oyuncular(int oyuncuID, String oyuncuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
        this.kartListesi = new ArrayList<>();
    }
    public Oyuncular() {
        this.kartListesi = new ArrayList<>();
    }

    public int SkorGoster() {
        return getSkor();
    }

    public void desteAta(SavasAraclari kart) {
        kartListesi.add(kart);
    }

    public abstract List<SavasAraclari>kartSec(ArrayList<SavasAraclari> gecmisSecilenKartlar, Random rastgele);

    public void skorGuncelle(int deger) {
        this.skor = deger;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public int getSkor() {
        return skor;
    }

    public List<SavasAraclari> getKardListesi() {
        return kartListesi;
    }
}
