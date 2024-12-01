import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class GUI extends Application {

    private int kontrol = 0;
    private int adimSayisi = 5;
    private int adim = 0;
    List<SavasAraclari> bilgisayarSecilenKartlar;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1400, 1000);

        Controller controller = loader.getController();
        Oyun oyun = new Oyun();

        oyun.desteAta();
        bilgisayarSecilenKartlar= oyun.getBilgisayar().kartSec(oyun.getGecmisSecilenKartlarbilgisayar(), oyun.getRastgele());

        controller.gosterKardlar(oyun.getKullaniciKartlar(), oyun.getBilgisayarKartlar(),oyun.getGecmisSecilenKartlarkullanıcı(),bilgisayarSecilenKartlar);
        controller.taraf_skor_goster(oyun.getKullanici().SkorGoster(),oyun.getBilgisayar().SkorGoster());

        Button nextStepButton = (Button) root.lookup("#nextStepButton");

        nextStepButton.setOnAction(event -> savaşYapButton(oyun, controller, nextStepButton));

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void savaşYapButton(Oyun oyun, Controller controller, Button nextStepButton) {
        controller.temizleSecilenKartlar();
        if (adim <= adimSayisi) {
            oyun.getFile().println("\nAdım sayısı : " + (adim+1));
            if (kontrol == 0) {
                bilgisayarSecilenKartlar= oyun.getBilgisayar().kartSec(oyun.getGecmisSecilenKartlarbilgisayar(), oyun.getRastgele());
                oyun.getFile().println("\nBilgisayar Seçilen Kartlar :\n" + bilgisayarSecilenKartlar);
                oyun.getFile().println("\nKullanıcı Seçilen Kartlar :\n" + controller.getKullaniciSecilenKartlar());
                oyun.savasYap(controller.getKullaniciSecilenKartlar(), bilgisayarSecilenKartlar,oyun.getGecmisSecilenKartlarkullanıcı(), oyun.getGecmisSecilenKartlarbilgisayar());
                controller.getKullaniciSecilenKartlar().clear();

                kontrol = oyun.desteEkle();
                controller.taraf_skor_goster(oyun.getKullanici().getSkor(),oyun.getBilgisayar().getSkor());
                controller.gosterKardlar(oyun.getKullaniciKartlar(), oyun.getBilgisayarKartlar(),oyun.getGecmisSecilenKartlarkullanıcı(),bilgisayarSecilenKartlar);
                adim++;

            } else if (kontrol == 1) {
                List<SavasAraclari> bilgisayarSecilenKartlar = oyun.getBilgisayar().kartSec(oyun.getGecmisSecilenKartlarbilgisayar(), oyun.getRastgele());

                oyun.savasYap(controller.getKullaniciSecilenKartlar(), bilgisayarSecilenKartlar,oyun.getGecmisSecilenKartlarkullanıcı(), oyun.getGecmisSecilenKartlarbilgisayar());
                controller.getKullaniciSecilenKartlar().clear();

                controller.taraf_skor_goster(oyun.getKullanici().getSkor(),oyun.getBilgisayar().getSkor());
                controller.gosterKardlar(oyun.getKullaniciKartlar(), oyun.getBilgisayarKartlar(), (List<SavasAraclari>) oyun.getGecmisSecilenKartlarkullanıcı(),bilgisayarSecilenKartlar );
                adim++;
                nextStepButton.setDisable(true);
            }

            if (adim == adimSayisi || oyun.getBilgisayar().getKardListesi().isEmpty() || oyun.getKullanici().getKardListesi().isEmpty()) {
                nextStepButton.setDisable(true);
                if(oyun.getKullanici().getSkor() > oyun.getBilgisayar().getSkor()) {
                    controller.kazananigoster(oyun.getKullanici().getSkor(), "KULLANICI");
                }
                else if(oyun.getBilgisayar().getSkor() > oyun.getKullanici().getSkor()) {
                    controller.kazananigoster(oyun.getBilgisayar().getSkor(),"BİLGİSAYAR");
                }
                else{
                    int kullaniciDayaniklilikToplam = 0;
                    int bilgisayarDayaniklilikToplam = 0;
                    int dayanıklılıkFark = 0;

                    for (SavasAraclari kart : oyun.getKullanici().getKardListesi()) {
                        kullaniciDayaniklilikToplam += kart.getDayaniklilik();
                    }

                    for (SavasAraclari kart : oyun.getBilgisayar().getKardListesi()) {
                        bilgisayarDayaniklilikToplam += kart.getDayaniklilik();
                    }

                    if (kullaniciDayaniklilikToplam > bilgisayarDayaniklilikToplam) {
                        dayanıklılıkFark = kullaniciDayaniklilikToplam - bilgisayarDayaniklilikToplam;
                        oyun.getKullanici().skorGuncelle(dayanıklılıkFark + oyun.getKullanici().getSkor());

                        controller.kazananigoster(kullaniciDayaniklilikToplam, "KULLANICI KAZANDI\n(DAYANIKLILIK)");
                    } else if (bilgisayarDayaniklilikToplam > kullaniciDayaniklilikToplam) {
                        dayanıklılıkFark = bilgisayarDayaniklilikToplam - kullaniciDayaniklilikToplam;
                        oyun.getBilgisayar().skorGuncelle(dayanıklılıkFark + oyun.getBilgisayar().getSkor());

                        controller.kazananigoster(bilgisayarDayaniklilikToplam, "BİLGİSAYAR KAZANDI\n (DAYANIKLILIK)");
                    } else {
                        controller.kazananigoster(0, "BERABERE (DAYANIKLILIK)");
                    }
                }

            }

        }
    }
}
