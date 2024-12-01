public class Ucak extends HavaAraclari {

    public Ucak(int seviyePuani) {
        super(seviyePuani);
        setDayaniklilik(20);
        setVurucGucu(10);
        setKaraVurusAvantaji(10);
    }

    @Override
    public void setAltsinif(String altsinif) {
        super.setAltsinif("Uçak");
    }

    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster();
    }

    @Override
    public void DurumGuncelle(int saldiriGucu) {
        setDayaniklilik(getDayaniklilik() - saldiriGucu );
    }

}
