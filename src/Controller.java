import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.text.TextAlignment;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    public HBox kullaniciDeste;
    @FXML
    public HBox bilgisayarDeste;
    @FXML
    public HBox kullaniciSkor;
    @FXML
    public HBox bilgisayarSkor;
    @FXML
    private HBox bosCerceveAlanı;
    @FXML
    private HBox bosCerceveAlanı2;


    private List<SavasAraclari> kullaniciSecilenKartlar;
    public Controller() {
        this.kullaniciSecilenKartlar = new ArrayList<>();
    }
    int secildi_mi=0;


    public void taraf_skor_goster(int skorKullancıcı, int skorBılgısayar) {
        kullaniciSkor.getChildren().clear();
        bilgisayarSkor.getChildren().clear();

        VBox vboxkullanıcı = new VBox();
        Text kullanıcıskor = new Text();

        vboxkullanıcı.setSpacing(10.0);
        vboxkullanıcı.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); -fx-padding: 10;");
        vboxkullanıcı.setPrefSize(150, 100);
        vboxkullanıcı.setAlignment(Pos.CENTER);

        kullanıcıskor.setText("KULLANICI SKOR : " + skorKullancıcı);
        kullanıcıskor.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-alignment: center;");
        kullanıcıskor.setTextAlignment(TextAlignment.CENTER);

        vboxkullanıcı.getChildren().add(kullanıcıskor);
        kullaniciSkor.getChildren().add(vboxkullanıcı);

        VBox vboxbılgısayar = new VBox();
        Text bılgısayarskor = new Text();

        vboxbılgısayar.setSpacing(10.0);
        vboxbılgısayar.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); -fx-padding: 10;");
        vboxbılgısayar.setPrefSize(150, 100);
        vboxbılgısayar.setAlignment(Pos.CENTER);

        bılgısayarskor.setText("BİLGİSAYAR SKOR : " + skorBılgısayar);
        bılgısayarskor.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-alignment: center;");
        bılgısayarskor.setTextAlignment(TextAlignment.CENTER);

        vboxbılgısayar.getChildren().add(bılgısayarskor);
        bilgisayarSkor.getChildren().add(vboxbılgısayar);
    }

    @FXML
    private HBox kazanan;
    public void kazananigoster(int skor, String galip) {
        VBox vboxkullanıcı = new VBox();
        vboxkullanıcı.setSpacing(10.0);
        vboxkullanıcı.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); -fx-padding: 10;");
        vboxkullanıcı.setPrefSize(350, 350);
        vboxkullanıcı.setAlignment(Pos.CENTER);

        ImageView kupaResmi = new ImageView(new Image(getClass().getResource("Foto/kupa.png").toExternalForm()));
        kupaResmi.setFitWidth(150);
        kupaResmi.setFitHeight(150);

        Text kazananskor = new Text(galip + "\nKAZANDI");
        kazananskor.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-alignment: center;");
        kazananskor.setTextAlignment(TextAlignment.CENTER);

        vboxkullanıcı.getChildren().addAll(kupaResmi, kazananskor);

        kazanan.getChildren().add(vboxkullanıcı);
    }


    @FXML
    public void initialize() {
        bosCerceveAlanı.getChildren().clear();
        bosCerceveAlanı2.getChildren().clear();

        for (int i = 0; i < 3; i++) {
            VBox emptyBox = new VBox();
            emptyBox.setSpacing(10.0);
            emptyBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); -fx-padding: 10; -fx-border-color: black; -fx-border-width: 2px;");
            emptyBox.setPrefSize(120, 150);
            bosCerceveAlanı.getChildren().add(emptyBox);
        }

        for (int i = 0; i < 3; i++) {
            VBox emptyBox = new VBox();
            emptyBox.setSpacing(10.0);
            emptyBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); -fx-padding: 10; -fx-border-color: black; -fx-border-width: 2px;");
            emptyBox.setPrefSize(120, 150);
            bosCerceveAlanı2.getChildren().add(emptyBox);
        }
    }

    int i=0;
    public int secileni_Ekle(SavasAraclari arac , List<SavasAraclari>kullanicigecmisSecilenKartlar,List<SavasAraclari> bilgisayarSecilenKartlar) {
        if (!kullanicigecmisSecilenKartlar.contains(arac)) {
            kullaniciSecilenKartlar.add(arac);
            kullanicigecmisSecilenKartlar.add(arac);
            Kullanici_Secilen_Karti_Goster(arac);
            if(i==3){
                i=0;
            }
            Bilgisayar_Secilen_Karti_Goster(bilgisayarSecilenKartlar.get(i));
            i++;
            secildi_mi=1;

            return secildi_mi;

        }
        else{
            secildi_mi=0;
            return secildi_mi;
        }

    }


    public void temizleSecilenKartlar() {
        for (Node node : bosCerceveAlanı.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;
                vbox.getChildren().clear();
            }
        }
        for (Node node : bosCerceveAlanı2.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;
                vbox.getChildren().clear();
            }
        }
    }


    public void Bilgisayar_Secilen_Karti_Goster(SavasAraclari arac) {
        for (Node node : bosCerceveAlanı2.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;

                if (vbox.getChildren().isEmpty()) {
                    ImageView imageView = new ImageView();
                    imageView.setImage(new Image(getClass().getResourceAsStream(resim_yukle(arac))));
                    imageView.setFitWidth(100.0);
                    imageView.setFitHeight(100.0);

                    Text cardInfoText = new Text();
                    cardInfoText.setText(
                            arac.getClass().getSimpleName().toUpperCase() + "\n" +
                                    "Seviye Puanı : " + arac.getSeviyePuani() + "\n" +
                                    "Dayanıklılık : " + arac.getDayaniklilik() + "\n" +
                                    "Vuruş Gücü : " + arac.getVurucGucu()
                    );


                    vbox.setStyle("-fx-border-color: black; -fx-border-width: 3px; -fx-border-radius: 5px; -fx-padding: 5px; -fx-background-color: lightgray;");
                    cardInfoText.setTextAlignment(TextAlignment.CENTER);

                    vbox.setAlignment(Pos.CENTER);
                    vbox.setSpacing(10.0);

                    vbox.getChildren().addAll(imageView, cardInfoText);
                    break;
                }
            }
        }
    }


    private void Kullanici_Secilen_Karti_Goster(SavasAraclari arac) {

        for (Node node : bosCerceveAlanı.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;

                if (vbox.getChildren().isEmpty()) {
                    ImageView imageView = new ImageView();
                    imageView.setImage(new Image(getClass().getResourceAsStream(resim_yukle(arac))));
                    imageView.setFitWidth(100.0);
                    imageView.setFitHeight(100.0);

                    Text cardInfoText = new Text();
                    cardInfoText.setText(
                            arac.getClass().getSimpleName().toUpperCase() + "\n" +
                                    "Seviye Puanı : " + arac.getSeviyePuani() + "\n" +
                                    "Dayanıklılık : " + arac.getDayaniklilik() + "\n" +
                                    "Vuruş Gücü : " + arac.getVurucGucu()
                    );

                    vbox.setStyle("-fx-border-color: black; -fx-border-width: 3px; -fx-border-radius: 5px; -fx-padding: 5px; -fx-background-color: lightgray;");
                    cardInfoText.setTextAlignment(TextAlignment.CENTER);

                    vbox.setAlignment(Pos.CENTER);
                    vbox.setSpacing(10.0);

                    vbox.getChildren().addAll(imageView, cardInfoText);
                    break;
                }
            }
        }
    }



    public void gosterKardlar(List<SavasAraclari> kullaniciKardlar, List<SavasAraclari> bilgisayarKardlar,List<SavasAraclari>kullanicigecmisSecilenKartlar,List<SavasAraclari> bilgisayarSecilenKartlar) {

        String imagePath = getClass().getResource("Foto/arka_plan.jpg").toExternalForm();
        kullaniciDeste.getScene().getRoot().setStyle(
                "-fx-background-image: url('" + imagePath + "'); " +
                        "-fx-background-size: contain; " +
                        "-fx-background-repeat: no-repeat; " +
                        "-fx-background-position: center center;"
        );


        kullaniciDeste.getChildren().clear();


        for (SavasAraclari arac : kullaniciKardlar) {
            VBox vbox = new VBox();
            vbox.setSpacing(10.0);

            ImageView imageView = new ImageView();
            imageView.setImage(new Image(getClass().getResourceAsStream(resim_yukle(arac))));
            imageView.setFitWidth(192.0);
            imageView.setFitHeight(200.0);

            Text cardInfoText = new Text();
            cardInfoText.setText(arac.getClass().getSimpleName().toUpperCase() + "\n" +
                    "Seviye Puanı : " + arac.getSeviyePuani() + "\n" +
                    "Dayanıklılık : " + arac.getDayaniklilik() + "\n" +
                    "Vuruş Gücü : " + arac.getVurucGucu());

            vbox.setStyle("-fx-border-color: black; -fx-border-width: 3px; -fx-border-radius: 5px; -fx-padding: 5px; -fx-background-color: lightgray;");


            if (kullanicigecmisSecilenKartlar.contains(arac)) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(-0.9);
                imageView.setEffect(colorAdjust);
                imageView.setDisable(true);
            }


            imageView.setOnMouseClicked(event -> {
                if(kullaniciSecilenKartlar.size()<3) {
                    secildi_mi=secileni_Ekle(arac,kullanicigecmisSecilenKartlar,bilgisayarSecilenKartlar);
                    if (secildi_mi==1) {
                        if (kullanicigecmisSecilenKartlar.contains(arac)) {
                            ColorAdjust colorAdjust1 = new ColorAdjust();
                            colorAdjust1.setBrightness(-0.5);
                            imageView.setEffect(colorAdjust1);
                            imageView.setDisable(true);
                        }

                        if (kullanicigecmisSecilenKartlar.size() == kullaniciKardlar.size()) {

                            List<SavasAraclari> silinecekKartlar = new ArrayList<>();
                            for (SavasAraclari arac2 : kullanicigecmisSecilenKartlar) {
                                if (!kullaniciSecilenKartlar.contains(arac2)) {
                                    silinecekKartlar.add(arac2);
                                }
                            }

                            kullanicigecmisSecilenKartlar.removeAll(silinecekKartlar);

                            efekt_ekle(kullaniciDeste, kullanicigecmisSecilenKartlar);

                            List<SavasAraclari> yeniListe = new ArrayList<>();
                            for (SavasAraclari arac2 : kullaniciKardlar) {
                                if (!kullanicigecmisSecilenKartlar.contains(arac2)) {
                                    yeniListe.add(arac2);
                                }
                            }

                            efekt_kaldir(kullaniciDeste, yeniListe);

                            ColorAdjust colorAdjust1 = new ColorAdjust();
                            colorAdjust1.setBrightness(-0.5);
                            imageView.setEffect(colorAdjust1);
                            imageView.setDisable(true);

                        }
                    }
                }

            });

            vbox.getChildren().addAll(cardInfoText, imageView);
            kullaniciDeste.getChildren().add(vbox);

        }

        bilgisayarDeste.getChildren().clear();

        for (SavasAraclari arac : bilgisayarKardlar) {
            VBox vbox = new VBox();
            vbox.setSpacing(0.0);
            vbox.setStyle("-fx-border-color: black; -fx-border-width: 3px; -fx-border-radius: 5px; -fx-padding: 0; -fx-background-color: white;");

            ImageView imageView = new ImageView();
            imageView.setImage(new Image(getClass().getResourceAsStream("Foto/uno.png")));
            imageView.setFitWidth(192.0);
            imageView.setFitHeight(250.0);
            imageView.setPreserveRatio(true);

            vbox.getChildren().add(imageView);

            bilgisayarDeste.getChildren().add(vbox);
        }
    }

    @FXML
    private void onNextStepButtonClick() {
    }

    private void efekt_kaldir(HBox cardContainer, List<SavasAraclari> yeniListe) {
        for (Node node : cardContainer.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;
                for (Node child : vbox.getChildren()) {
                    if (child instanceof ImageView) {
                        ImageView imageView = (ImageView) child;
                        imageView.setEffect(null);
                        imageView.setDisable(false);
                    }
                }
            }
        }
    }

    private void efekt_ekle(HBox cardContainer, List<SavasAraclari> selectedCards) {
        for (SavasAraclari arac1 : selectedCards) {
            for (Node node : cardContainer.getChildren()) {
                if (node instanceof VBox) {
                    VBox vbox1 = (VBox) node;
                    for (Node child : vbox1.getChildren()) {
                        if (child instanceof ImageView) {
                            ImageView imageView2 = (ImageView) child;

                            if (imageView2.getImage() == null) {
                                continue;
                            }

                            if (imageView2.getImage().getUrl() == null) {
                                continue;
                            }

                            if (imageView2.getImage().getUrl().equals(getClass().getResource(resim_yukle(arac1)).toString())) {
                                ColorAdjust colorAdjust = new ColorAdjust();
                                colorAdjust.setBrightness(-0.9);
                                imageView2.setEffect(colorAdjust);
                                imageView2.setDisable(true);
                            }
                        }
                    }
                }
            }
        }

    }

    private String resim_yukle(SavasAraclari arac) {
        if (arac instanceof Ucak) return "Foto/ucak.jpg";
        else if (arac instanceof Siha) return "Foto/siha.jpg";
        else if (arac instanceof Fırkateyn) return "Foto/firkateyn.jpeg";
        else if (arac instanceof KFS) return "Foto/KFS.jpg";
        else if (arac instanceof Obus) return "Foto/obus.jpeg";
        else if (arac instanceof Sida) return "Foto/sida.jpg";
        return "/Foto/default.jpg";
    }

    public List<SavasAraclari> getKullaniciSecilenKartlar() {
        return kullaniciSecilenKartlar;
    }
}
