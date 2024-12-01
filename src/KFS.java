public class KFS extends KaraAraclari {
    private int havaVurusAvantaji = 20;

    public KFS(int seviyePuani) {
        super(seviyePuani);
        setDayaniklilik(10);
        setVurucGucu(10);
        setDenizVurusAvantaji(10);
        setHavaVurusAvantaji(havaVurusAvantaji);
    }

    public int getHavaVurusAvantaji() {
        return havaVurusAvantaji;
    }
    public void setHavaVurusAvantaji(int havaVurusAvantaji) {
        this.havaVurusAvantaji = havaVurusAvantaji;
    }

    @Override
    public void setAltsinif(String altsinif) {
        super.setAltsinif("Siha");
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
