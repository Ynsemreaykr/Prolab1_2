import java.util.Random;
import java.util.*;

class Bilgisayar extends Oyuncular {

    public Bilgisayar(int bilgisayarID) {
        super(bilgisayarID, "Bilgisayar",0);
    }


    public List<SavasAraclari> kartSec(ArrayList<SavasAraclari> gecmisSecilenKartlar, Random rastgele) {

        List<SavasAraclari> secilenKartlarListesi = new ArrayList<>();
        int kartSayisi = 0;

        while (kartSayisi < 3) {
            int index = rastgele.nextInt(getKardListesi().size());
            SavasAraclari secilenKart = getKardListesi().get(index);

            if (!gecmisSecilenKartlar.contains(secilenKart)) {
                secilenKartlarListesi.add(secilenKart);
                gecmisSecilenKartlar.add(secilenKart);
                kartSayisi++;

                if (gecmisSecilenKartlar.size() == getKardListesi().size()) {
                    gecmisSecilenKartlar.clear();
                    gecmisSecilenKartlar.addAll(secilenKartlarListesi);
                }
            }
        }
        return secilenKartlarListesi;
    }

}