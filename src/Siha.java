public class Siha extends HavaAraclari {
    private int denizVurusAvantaji = 10;

    public Siha(int seviyePuani) {
        super(seviyePuani);
        setDayaniklilik(15);
        setVurucGucu(10);
        setKaraVurusAvantaji(10);
        setDenizVurusAvantaji(denizVurusAvantaji);
    }

    public int getDenizVurusAvantaji() {
        return denizVurusAvantaji;
    }
    public void setDenizVurusAvantaji(int denizVurusAvantaji) {
        this.denizVurusAvantaji = denizVurusAvantaji;
    }

    @Override
    public void setAltsinif(String altsinif) {super.setAltsinif("Siha");}

    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster();
    }

    @Override
    public void DurumGuncelle(int saldiriGucu) {
        setDayaniklilik(getDayaniklilik() - saldiriGucu );
    }

}
