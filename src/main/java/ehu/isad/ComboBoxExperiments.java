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


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment 1");

        ComboBox comboBox = new ComboBox();

        List<String> bildumak = List.of("PS4 Jokoak","Autoak","Futbol Ligak");

        ObservableList<Bilduma> bildumaList = FXCollections.observableArrayList();

        bildumak.forEach((elem) -> {
            bildumaList.add(new Bilduma(elem));
        });

        comboBox.setItems(bildumaList);

        Map<String, List<Argazki>> bildumaMap = new HashMap<>();

        bildumaMap.put("PS4 Jokoak", List.of(
                new Argazki("FIFA20","FIFA20.jpg"),
                new Argazki("NBA2k20","NBA2k20.jpg"),
                new Argazki("Fortnite","Fortnite.jpeg")
        ));

        bildumaMap.put("Autoak", List.of(
                new Argazki("Mercedes","Mercedes.jpeg"),
                new Argazki("Ferrari","Ferrari.png"),
                new Argazki("Audi","Audi.png")
        ));

        bildumaMap.put("Futbol Ligak", List.of(
                new Argazki("Premier League","Premier League.jpeg"),
                new Argazki("LaLiga Santander","LaLiga Santander.jpeg"),
                new Argazki("Bundesliga","Bundesliga.png")
        ));

     
        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
        comboBox.setOnAction(e->{

            argazkiList.clear();

            if (comboBox.getValue().equals(bildumaList.get(0))){
                argazkiList.addAll(bildumaMap.get("PS4 Jokoak"));
            }

            if (comboBox.getValue().equals(bildumaList.get(1))){
                argazkiList.addAll(bildumaMap.get("Autoak"));
            }

            if (comboBox.getValue().equals(bildumaList.get(2))){
                argazkiList.addAll(bildumaMap.get("Futbol Ligak"));
            }
        });


        comboBox.setEditable(false);

        ListView listViewOfArgazki = new ListView<>(argazkiList);

        ImageView imageView = new ImageView();

        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = ((Argazki)observable.getValue()).getFitx();

            try {
                imageView.setImage(lortuIrudia(fitx /* 48x48 */));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        imageView.setFitHeight(150);
        imageView.setFitWidth(150);

        HBox hbox = new HBox(comboBox, listViewOfArgazki, imageView);

        Scene scene = new Scene(hbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Image lortuIrudia(String location) throws IOException {

        System.out.println(location);
        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
