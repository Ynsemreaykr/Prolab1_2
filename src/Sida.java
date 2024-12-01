public class Sida extends DenizAraclari{
    private int karaVurusAvantaji = 10;
    public Sida(int seviyePuani) {
        super(seviyePuani);
        setDayaniklilik(15);
        setVurucGucu(10);
        setHavaVurusAvantaji(10);
        setKaraVurusAvantaji(karaVurusAvantaji);
    }

    public int getKaraVurusAvantaji() {
        return karaVurusAvantaji;
    }
    public void setKaraVurusAvantaji(int karaVurusAvantaji) {
        this.karaVurusAvantaji = karaVurusAvantaji;
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