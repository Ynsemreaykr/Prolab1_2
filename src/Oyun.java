import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Oyun {
    private static Oyuncular bilgisayar;
    private static Oyuncular kullanici;
    private static ArrayList<SavasAraclari> araclar;
    private static ArrayList<SavasAraclari> gecmisSecilenKartlarkullanıcı;
    private static ArrayList<SavasAraclari> gecmisSecilenKartlarbilgisayar;
    private static Random rastgele;
    private static String dosyaAdi = "savas.txt";
    private static PrintWriter file;

    public Oyun() throws IOException {
        bilgisayar = new Bilgisayar(1);
        kullanici = new Kullanici(2);
        araclar = new ArrayList<>();
        gecmisSecilenKartlarkullanıcı = new ArrayList<>();
        gecmisSecilenKartlarbilgisayar = new ArrayList<>();
        rastgele = new Random();
        file = new PrintWriter(new FileWriter(dosyaAdi));
    }

    public static void main(String[] args) {
        GUI.launch(GUI.class, args);
        file.close();
    }

    public int desteEkle(){
        Random rastgele = new Random();
        int kontrol = 0;

        if (kullanici.getKardListesi().size() > 1){
            if (kullanici.getSkor() < 20) {
                int index = rastgele.nextInt(3);
                SavasAraclari yeniKart = aracOlustur(araclar.get(index), kullanici.getSkor());
                kullanici.desteAta(yeniKart);
                file.println("Kullanıcı skoru 20'den azdır Destesine eklenen kart : " + yeniKart);
            } else {
                SavasAraclari yeniKart = aracOlustur(araclar.get(rastgele.nextInt(araclar.size())), kullanici.getSkor());
                kullanici.desteAta(yeniKart);
                file.println("Kullanıcı skoru 20'den fazladır Destesine eklenen kart : " + yeniKart);
            }
        }

        if (bilgisayar.getKardListesi().size() > 1){
            if (bilgisayar.getSkor() < 20) {
                int index = rastgele.nextInt(3);
                SavasAraclari yeniKart = aracOlustur(araclar.get(index), bilgisayar.getSkor());
                bilgisayar.desteAta(yeniKart);
                file.println("Bilgisayar skoru 20'den azdır Destesine eklenen kart : " + yeniKart);
            } else {
                SavasAraclari yeniKart = aracOlustur(araclar.get(rastgele.nextInt(araclar.size())), bilgisayar.getSkor());
                bilgisayar.desteAta(yeniKart);
                file.println("Bilgisayar skoru 20'den fazladır Destesine eklenen kart : " + yeniKart);
            }
        }

        SavasAraclari rastgeleArac = null;

        if(bilgisayar.getKardListesi().size() == 1){
            kontrol = 1;
            for (int i = 0; i < 2; i++) {
                if (bilgisayar.getSkor() < 20) {
                    int index = rastgele.nextInt(3);
                    rastgeleArac = aracOlustur(araclar.get(index), bilgisayar.getSkor());
                } else {
                    rastgeleArac = aracOlustur(araclar.get(rastgele.nextInt(araclar.size())), bilgisayar.getSkor());
                }
                bilgisayar.desteAta(rastgeleArac);
                file.println("Bilgisayar son bir kartı kalmıştır 2 tane kart ekleniyor : " + rastgeleArac);
            }

        }
        if(kullanici.getKardListesi().size() == 1){
            kontrol = 1;
            for (int i = 0; i < 2; i++) {
                if (kullanici.getSkor() < 20) {
                    int index = rastgele.nextInt(3);
                    rastgeleArac = aracOlustur(araclar.get(index), kullanici.getSkor());
                } else {
                    rastgeleArac = aracOlustur(araclar.get(rastgele.nextInt(araclar.size())), kullanici.getSkor());
                }
                kullanici.desteAta(rastgeleArac);
                file.println("Kullanıcı son bir kartı kalmıştır 2 tane kart ekleniyor : " + rastgeleArac);
            }

        }

        return kontrol;
    }

    public void desteAta() {
        araclar.add(new Ucak(0));
        araclar.add(new Obus(0));
        araclar.add(new Fırkateyn(0));
        araclar.add(new Siha(0));
        araclar.add(new Sida(0));
        araclar.add(new KFS(0));

        Random rastgele = new Random();

        SavasAraclari rastgeleArac = null;

        for (int i = 0; i < 6; i++) {

            if (bilgisayar.getSkor() < 20) {
                int index = rastgele.nextInt(3);
                rastgeleArac = aracOlustur(araclar.get(index), bilgisayar.getSkor());
            } else {
                rastgeleArac = aracOlustur(araclar.get(rastgele.nextInt(araclar.size())), bilgisayar.getSkor());
            }

            bilgisayar.desteAta(rastgeleArac);

            if (kullanici.getSkor() < 20) {
                int index = rastgele.nextInt(3);
                rastgeleArac = aracOlustur(araclar.get(index), kullanici.getSkor());
            } else {
                rastgeleArac = aracOlustur(araclar.get(rastgele.nextInt(araclar.size())), kullanici.getSkor());
            }

            kullanici.desteAta(rastgeleArac);
        }
        file.println("Atanan Kart Destesi :\nBilgisayar Destesi\n" + bilgisayar.getKardListesi());
        file.println("\nKullanıcı Destesi\n" + kullanici.getKardListesi());

    }

    public void savasYap(List<SavasAraclari> kullaniciKartlari, List<SavasAraclari> bilgisayarKartlari, List<SavasAraclari> gecmisSecilenKartlarKul, List<SavasAraclari> gecmisSecilenKartlarBil) {
        for (int i = 0; i < 3; i++) {
            SavasAraclari kullaniciKart = kullaniciKartlari.get(i);
            SavasAraclari bilgisayarKart = bilgisayarKartlari.get(i);

            file.println("\nSavaşan kartlar Kullanıcı : " + kullaniciKart + " ve Bilgisayar : "+ bilgisayarKart);

            int kullaniciVurusGucu = kullaniciKart.getVurucGucu();
            int bilgisayarVurusGucu = bilgisayarKart.getVurucGucu();

            file.print("Kullanıcının "+ kullaniciKart + " kartının  vuruş gücü : |" + kullaniciVurusGucu + "| 'dur.");
            if (kullaniciKart instanceof KaraAraclari) {
                if (kullaniciKart instanceof KFS && "Hava".equals(bilgisayarKart.getSinif())) {
                    kullaniciVurusGucu += ((KFS) kullaniciKart).getHavaVurusAvantaji();
                    file.println("Düşman aracı Hava olan " + bilgisayarKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + kullaniciVurusGucu + "| olmuştur.");
                }
                else if (bilgisayarKart instanceof DenizAraclari) {
                    kullaniciVurusGucu += ((KaraAraclari) kullaniciKart).getDenizVurusAvantaji();
                    file.println("Düşman aracı Deniz olan " + bilgisayarKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + kullaniciVurusGucu + "| olmuştur.");
                }
                else
                    file.println(" Avantajlı düşman yoktur.");

            } else if (kullaniciKart instanceof DenizAraclari) {
                if (kullaniciKart instanceof Sida && "Kara".equals(bilgisayarKart.getSinif())) {
                    kullaniciVurusGucu += ((Sida) kullaniciKart).getKaraVurusAvantaji();
                    file.println("Düşman aracı Kara olan " + bilgisayarKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + kullaniciVurusGucu + "| olmuştur.");
                }
                else if (bilgisayarKart instanceof HavaAraclari) {
                    kullaniciVurusGucu += ((DenizAraclari) kullaniciKart).getHavaVurusAvantaji();
                    file.println("Düşman aracı Hava olan " + bilgisayarKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + kullaniciVurusGucu + "| olmuştur.");
                }
                else
                    file.println(" Avantajlı düşman yoktur.");

            } else if (kullaniciKart instanceof HavaAraclari) {
                if (kullaniciKart instanceof Siha && "Deniz".equals(bilgisayarKart.getSinif())) {
                    kullaniciVurusGucu += ((Siha) kullaniciKart).getDenizVurusAvantaji();
                    file.println("Düşman aracı Deniz olan " + bilgisayarKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + kullaniciVurusGucu + "| olmuştur.");
                }
                else if (bilgisayarKart instanceof KaraAraclari) {
                    kullaniciVurusGucu += ((HavaAraclari) kullaniciKart).getKaraVurusAvantaji();
                    file.println("Düşman aracı Kara olan " + bilgisayarKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + kullaniciVurusGucu + "| olmuştur.");
                }
                else
                    file.println(" Avantajlı düşman yoktur.");
            }


            file.print("Bilgisayarın "+ bilgisayarKart + " kartının  vuruş gücü : |" + bilgisayarVurusGucu + "| 'dur.");
            if (bilgisayarKart instanceof KaraAraclari) {
                if (bilgisayarKart instanceof KFS && "Hava".equals(kullaniciKart.getSinif())) {
                    bilgisayarVurusGucu += ((KFS) bilgisayarKart).getHavaVurusAvantaji();
                    file.println("Düşman aracı Hava olan " + kullaniciKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + bilgisayarVurusGucu + "| olmuştur.");
                }
                else if (kullaniciKart instanceof DenizAraclari) {
                    bilgisayarVurusGucu += ((KaraAraclari) bilgisayarKart).getDenizVurusAvantaji();
                    file.println("Düşman aracı Deniz olan " + kullaniciKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + bilgisayarVurusGucu + "| olmuştur.");
                }
                else
                    file.println(" Avantajlı düşman yoktur.");
            } else if (bilgisayarKart instanceof DenizAraclari) {
                if (bilgisayarKart instanceof Sida && "Kara".equals(kullaniciKart.getSinif())) {
                    bilgisayarVurusGucu += ((Sida) bilgisayarKart).getKaraVurusAvantaji();
                    file.println("Düşman aracı Kara olan " + kullaniciKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + bilgisayarVurusGucu + "| olmuştur.");
                }
                else if (kullaniciKart instanceof HavaAraclari) {
                    bilgisayarVurusGucu += ((DenizAraclari) bilgisayarKart).getHavaVurusAvantaji();
                    file.println("Düşman aracı Hava olan " + kullaniciKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + bilgisayarVurusGucu + "| olmuştur.");
                }
                else
                    file.println(" Avantajlı düşman yoktur.");
            } else if (bilgisayarKart instanceof HavaAraclari) {
                if (bilgisayarKart instanceof Siha && "Deniz".equals(kullaniciKart.getSinif())) {
                    bilgisayarVurusGucu += ((Siha) bilgisayarKart).getDenizVurusAvantaji();
                    file.println("Düşman aracı Deniz olan " + kullaniciKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + bilgisayarVurusGucu + "| olmuştur.");
                }
                else if (kullaniciKart instanceof KaraAraclari) {
                    bilgisayarVurusGucu += ((HavaAraclari) bilgisayarKart).getKaraVurusAvantaji();
                    file.println("Düşman aracı Kara olan " + kullaniciKart + " kartına avantajı eklenmiştir. Toplam vuruş gücü : |" + bilgisayarVurusGucu + "| olmuştur.");
                }
                else
                    file.println(" Avantajlı düşman yoktur.");
            }

            bilgisayarKart.DurumGuncelle(kullaniciVurusGucu);
            kullaniciKart.DurumGuncelle(bilgisayarVurusGucu);

            if(kullaniciKart.getDayaniklilik() <= 0 || bilgisayarKart.getDayaniklilik() <= 0) {
                int bilgisayarGeciciSeviye= bilgisayarKart.getSeviyePuani();
                if( bilgisayarGeciciSeviye < 10 && bilgisayarKart.getDayaniklilik() <= 0 ){
                    bilgisayarGeciciSeviye=10;
                }

                int kullaniciGeciciSeviye= kullaniciKart.getSeviyePuani();
                if( kullaniciGeciciSeviye < 10 && kullaniciKart.getDayaniklilik() <= 0 ){
                    kullaniciGeciciSeviye=10;
                }

                if (kullaniciKart.getDayaniklilik() <= 0 && bilgisayarKart.getDayaniklilik() >0) {
                    bilgisayarKart.setSeviyePuani( bilgisayarGeciciSeviye + kullaniciGeciciSeviye );
                    bilgisayar.skorGuncelle(bilgisayar.getSkor() + kullaniciGeciciSeviye);
                    file.println("Bilgisayarın " + bilgisayarKart +" kartı kullanıcının " + kullaniciKart + "kartını öldürdü.");
                    file.println(bilgisayarKart + " kartının yeni seviye puanı : |" + bilgisayarKart.getSeviyePuani() + "| olmuştur.");
                    file.println("Bilgisayarın yeni skoru da : |" + bilgisayar.getSkor() + "| olmuştur.");
                }
                else if (bilgisayarKart.getDayaniklilik() <= 0 && kullaniciKart.getDayaniklilik() > 0) {
                    kullaniciKart.setSeviyePuani(kullaniciGeciciSeviye + bilgisayarGeciciSeviye);
                    kullanici.skorGuncelle(kullanici.getSkor() + bilgisayarGeciciSeviye);
                    file.println("Kullanıcının " + kullaniciKart +" kartı bilgisayarın " + bilgisayarKart + "kartını öldürdü.");
                    file.println(kullaniciKart + " kartının yeni seviye puanı : |" + kullaniciKart.getSeviyePuani() + "| olmuştur.");
                    file.println("Kullanıcının yeni skoru da : |" + kullanici.getSkor() + "| olmuştur.");
                }
                else if(bilgisayarKart.getDayaniklilik() <= 0 && kullaniciKart.getDayaniklilik() <= 0 ){
                    kullanici.skorGuncelle( bilgisayarGeciciSeviye + kullanici.getSkor() );
                    bilgisayar.skorGuncelle(kullaniciGeciciSeviye + bilgisayar.getSkor());
                    file.println("Her iki kart da ölmüştür.\nBilgisayarın " + bilgisayarKart +" kartı kullanıcının " + kullaniciKart + "kartını öldürdü.");
                    file.println("Bilgisayarın yeni skoru : |" + bilgisayar.getSkor() + "| olmuştur.");
                    file.println("Kullanıcının " + kullaniciKart +" kartı bilgisayarın " + bilgisayarKart + "kartını öldürdü.");
                    file.println("Kullanıcının yeni skoru da : |" + kullanici.getSkor() + "| olmuştur.");
                }

                if (kullaniciKart.getDayaniklilik() <= 0) {
                    file.println("Kullanıcınınn kartı öldü : " + kullaniciKart );
                    Iterator<SavasAraclari> iterator = kullanici.getKardListesi().iterator();
                    Iterator<SavasAraclari> iterator1 = gecmisSecilenKartlarKul.iterator();

                    while (iterator.hasNext()) {
                        SavasAraclari kart = iterator.next();
                        if (kart.equals(kullaniciKart)) {
                            iterator.remove();
                        }
                    }
                    while (iterator1.hasNext()) {
                        SavasAraclari kart = iterator1.next();
                        if (kart.equals(kullaniciKart)) {
                            iterator1.remove();
                        }
                    }
                }

                if (bilgisayarKart.getDayaniklilik() <= 0) {
                    file.println("Bilgisayarın kartı öldü : " + bilgisayarKart );
                    Iterator<SavasAraclari> iterator = bilgisayar.getKardListesi().iterator();
                    Iterator<SavasAraclari> iterator1 = gecmisSecilenKartlarBil.iterator();

                    while (iterator.hasNext()) {
                        SavasAraclari kart = iterator.next();
                        if (kart.equals(bilgisayarKart)) {
                            iterator.remove();
                        }
                    }
                    while (iterator1.hasNext()) {
                        SavasAraclari kart = iterator1.next();
                        if (kart.equals(bilgisayarKart)) {
                            iterator1.remove();
                        }
                    }
                }

            }
        }
    }

    private static SavasAraclari aracOlustur(SavasAraclari arac, int oyuncuSkoru) {
        if (oyuncuSkoru < 20) {
            if (arac instanceof Ucak) {
                return new Ucak(0);
            } else if (arac instanceof Obus) {
                return new Obus(0);
            } else if (arac instanceof Fırkateyn) {
                return new Fırkateyn(0);
            }
        } else {
            if (arac instanceof Ucak) {
                return new Ucak(0);
            } else if (arac instanceof Obus) {
                return new Obus(0);
            } else if (arac instanceof Fırkateyn) {
                return new Fırkateyn(0);
            } else if (arac instanceof Siha) {
                return new Siha(0);
            } else if (arac instanceof KFS) {
                return new KFS(0);
            } else if (arac instanceof Sida) {
                return new Sida(0);
            }
        }

        return null;
    }

    public PrintWriter getFile() {
        return file;
    }

    public Random getRastgele() {
        return rastgele;
    }

    public ArrayList<SavasAraclari> getGecmisSecilenKartlarbilgisayar() {
        return gecmisSecilenKartlarbilgisayar;
    }

    public ArrayList<SavasAraclari> getGecmisSecilenKartlarkullanıcı() {
        return gecmisSecilenKartlarkullanıcı;
    }

    public Oyuncular getBilgisayar() {
        return bilgisayar;
    }

    public Oyuncular getKullanici() {
        return kullanici;
    }

    public List<SavasAraclari> getBilgisayarKartlar() {
        return bilgisayar.getKardListesi();
    }

    public List<SavasAraclari> getKullaniciKartlar() {
        return kullanici.getKardListesi();
    }

}