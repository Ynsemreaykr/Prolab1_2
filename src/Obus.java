public class Obus extends KaraAraclari {
    public Obus(int seviyePuani) {
        super(seviyePuani);
        setDayaniklilik(20);
        setVurucGucu(10);
        setDenizVurusAvantaji(5);
    }

    @Override
    public void setAltsinif(String altsinif) {
        super.setAltsinif("Obus");
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
