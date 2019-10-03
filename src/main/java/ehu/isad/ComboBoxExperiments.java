package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {
    private ListView<Argazki> listViewOfArgazki;
    private ImageView imageView;
    private ObservableList<Argazki> argazkiList;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment 1");

        ComboBox comboBox = new ComboBox();

        List<String> bildumak =
                List.of("PS4 Jokoak", "Autoak", "Futbol Ligak");

        ObservableList<Bilduma> bildumaList =
                FXCollections.observableArrayList();

        bildumak.forEach((elem) -> {
            bildumaList.add(new Bilduma(elem));
        });

        comboBox.setItems(bildumaList);

        Map<String, List<Argazki>> bildumaMap = new HashMap<>();

        bildumaMap.put("PS4 Jokoak", List.of(
                new Argazki("FIFA20", "FIFA20.jpg"),
                new Argazki("NBA2k20", "NBA2k20.jpg"),
                new Argazki("Fortnite", "Fortnite.jpeg")
        ));

        bildumaMap.put("Autoak", List.of(
                new Argazki("Mercedes", "Mercedes.jpeg"),
                new Argazki("Ferrari", "Ferrari.png"),
                new Argazki("Audi", "Audi.png")
        ));

        bildumaMap.put("Futbol Ligak", List.of(
                new Argazki("Premier League", "Premier League.jpeg"),
                new Argazki("LaLiga Santander", "LaLiga Santander.jpeg"),
                new Argazki("Bundesliga", "Bundesliga.png")
        ));


        argazkiList =FXCollections.observableArrayList();
            argazkiList.addAll(bildumaMap.get("PS4 Jokoak"));
        //argazkiList.addAll(bildumaMap.get("Autoak"));
        //argazkiList.addAll(bildumaMap.get("Futbol Ligak"));

        listViewOfArgazki = new ListView<>(argazkiList);

        comboBox.setOnAction(e -> {
                    //System.out.println(comboBox.getValue());

                    argazkiList = FXCollections.observableArrayList();
                    Bilduma aukera = (Bilduma) comboBox.getValue();
                    String izena = aukera.getIzena();
                    argazkiList.addAll(bildumaMap.get(izena));
                    listViewOfArgazki.getItems().clear();
                    listViewOfArgazki.setItems(argazkiList);

        });
        imageView = new ImageView();

        comboBox.setEditable(false);

        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = observable.getValue().getFoto();

            try {
                imageView.setImage(lortuIrudia(fitx /* 48x48 */));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        /*
        comboBox.getItems().add("Jokoak");
        comboBox.getItems().add("Autoak");
        comboBox.getItems().add("");

        ListView Bilduma = new ListView();

        ImageView Argazkiak = new ImageView();

        comboBox.setEditable(false);

        comboBox.setOnAction(e -> {
            System.out.println( comboBox.getValue());

            if (comboBox.equals("Jokoak")) {
                Bilduma.getItems().add("FIFA");
                Bilduma.getItems().add("NBA");
                Bilduma.getItems().add("Fortnite");}
            if (comboBox.equals("Autoak")) {
                Bilduma.getItems().add("Mercedes");
                Bilduma.getItems().add("Ferrari");
                Bilduma.getItems().add("Audi");}
            if (comboBox.equals("Futboleko Ligak")) {
                Bilduma.getItems().add("Premier League");
                Bilduma.getItems().add("Liga Santander");
                Bilduma.getItems().add("Bundesliga");}
            });

        Bilduma.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    String balioa = (String) observable.getValue();
                    if (balioa.equals("FIFA")){
                        try {
                            Argazkiak.setImage(lortuIrudia("txina.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("NBA")){
                        InputStream is = getClass().getResourceAsStream("/" + "senegal.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }

                    if (balioa.equals("Fortnite")){
                        InputStream is = getClass().getResourceAsStream("/" + "paris.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }

                    if (balioa.equals("Mercedes")){
                        InputStream is = getClass().getResourceAsStream("/" + "txingak.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }

                    if (balioa.equals("Ferrari")){
                        InputStream is = getClass().getResourceAsStream("/" + "sokatira.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }

                    if (balioa.equals("Audi")){
                        InputStream is = getClass().getResourceAsStream("/" + "zaldiprobak.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }

                    if (balioa.equals("Premier League")){
                        InputStream is = getClass().getResourceAsStream("/" + "saskibaloia.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }

                    if (balioa.equals("Liga Santander")){
                        InputStream is = getClass().getResourceAsStream("/" + "tenisa.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }

                    if (balioa.equals("Bundesliga")){
                        InputStream is = getClass().getResourceAsStream("/" + "golf.jpg");
                        Image image = new Image(is);
                        Argazkiak.setImage(image);
                    }
                });
        */
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);

        HBox hbox = new HBox(comboBox, listViewOfArgazki, imageView);

        Scene scene = new Scene(hbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Image lortuIrudia(String location) throws IOException {

        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
