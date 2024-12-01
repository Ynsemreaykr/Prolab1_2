public abstract class DenizAraclari extends SavasAraclari {
    private String altsinif;
    private int havaVurusAvantaji;


    public DenizAraclari(int seviyePuani) {
        super(seviyePuani);
    }

    public String getAltsinif() {
        return altsinif;
    }
    public void setAltsinif(String altsinif) {
        this.altsinif = altsinif;
    }

    public int getHavaVurusAvantaji() {
        return havaVurusAvantaji;
    }
    public void setHavaVurusAvantaji(int havaVurusAvantaji) {
        this.havaVurusAvantaji = havaVurusAvantaji;
    }

    @Override
    public void setSinif(String sinif) {
        super.setSinif("Deniz");
    }

    @Override
    public abstract void DurumGuncelle(int saldiriGucu);
}
