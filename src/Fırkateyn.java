public class Fırkateyn extends DenizAraclari {

    public Fırkateyn(int seviyePuani) {
        super(seviyePuani);
        setDayaniklilik(25);
        setVurucGucu(10);
        setHavaVurusAvantaji(5);
    }

    @Override
    public void setAltsinif(String altsinif) {
        super.setAltsinif("Fırkateyn");
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
