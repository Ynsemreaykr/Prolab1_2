public abstract class KaraAraclari extends SavasAraclari {
    private String altsinif;
    private int denizVurusAvantaji;

    public KaraAraclari(int seviyePuani) {
        super(seviyePuani);
    }

    public String getAltsinif() {
        return altsinif;
    }
    public void setAltsinif(String altsinif) {
        this.altsinif = altsinif;
    }

    public int getDenizVurusAvantaji() {
        return denizVurusAvantaji;
    }
    public void setDenizVurusAvantaji(int denizVurusAvantaji) {
        this.denizVurusAvantaji = denizVurusAvantaji;
    }

    @Override
    public void setSinif(String sinif) {
        super.setSinif("Kara");
    }

    @Override
    public abstract void DurumGuncelle(int saldiriGucu);

}
