public abstract class HavaAraclari extends SavasAraclari {
    private String altsinif;
    private int karaVurusAvantaji;

    public HavaAraclari(int seviyePuani) {
        super(seviyePuani);
    }

    public String getAltsinif() {
        return altsinif;
    }
    public void setAltsinif(String altsinif) {
        this.altsinif = altsinif;
    }

    public int getKaraVurusAvantaji() {
        return karaVurusAvantaji;
    }
    public void setKaraVurusAvantaji(int karaVurusAvantaji) {
        this.karaVurusAvantaji = karaVurusAvantaji;
    }

    @Override
    public void setSinif(String sinif) {
        super.setSinif("Hava");
    }


    @Override
    public abstract void DurumGuncelle(int saldiriGucu);

}
