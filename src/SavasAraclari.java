public abstract class SavasAraclari {
    private int seviyePuani = 0;
    private int dayaniklilik;
    private int vurucGucu;
    private String sinif;


    public SavasAraclari(int seviyePuani) {
        this.seviyePuani = seviyePuani;
    }


    public int getSeviyePuani() {
        return seviyePuani;
    }
    public void setSeviyePuani(int seviyePuani) {
        this.seviyePuani = seviyePuani;
    }

    public int getDayaniklilik() {
        return dayaniklilik;
    }
    public void setDayaniklilik(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public int getVurucGucu() {
        return vurucGucu;
    }
    public void setVurucGucu(int vurucGucu) {
        this.vurucGucu = vurucGucu;
    }

    public String getSinif() {
        return sinif;
    }
    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public void KartPuaniGoster() {}

    public abstract void DurumGuncelle(int saldiriGucu);
}
