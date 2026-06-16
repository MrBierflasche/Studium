package ms.prog2.exercises.set13;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DiashowApp extends Application {

    private List<File> images;
    private int currentIndex = 0;

    private ImageView imageView;
    private Text infoText;

    private SlideshowThread slideshowThread = null;
    @Override
    public void start(Stage stage) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Fotoverzeichnis auswählen");
        File dir = chooser.showDialog(null);

        if (dir == null) {
            throw new IllegalStateException("Kein Verzeichnis ausgewählt. Programm wird beendet.");
        }

        File[] allFiles = dir.listFiles();
        if (allFiles == null || allFiles.length == 0) {
            throw new IllegalStateException("Verzeichnis ist leer.");
        }

        // Alle JPG-Dateien im Verzeichnis einlesen
        images = Arrays.stream(allFiles)
                .filter(f -> f.isFile() && f.getName().toLowerCase().endsWith(".jpg"))
                .sorted().toList();

        if (images.isEmpty()) {
            throw new IllegalStateException("Keine JPG-Bilder im gewählten Verzeichnis gefunden.");
        }

        imageView = new ImageView();
        imageView.setPreserveRatio(true); // Seitenverhältnis 16:9 bleibt beim Vergrößern erhalten
        imageView.setSmooth(true); // Bild wird beim Vergrößern nicht pixelig

        infoText = new Text();
        infoText.setFont(Font.font("SansSerif", 14));
        infoText.setFill(Color.WHITE);

        StackPane root = new StackPane(imageView, infoText);
        root.setStyle("-fx-background-color: black;");
        StackPane.setAlignment(infoText, Pos.BOTTOM_RIGHT);
        // Abstand vom Fensterrand
        infoText.setTranslateX(-10);
        infoText.setTranslateY(-10);

        Scene scene = new Scene(root, 900, 650);

        // ImageView an Fenstergröße binden
        imageView.fitWidthProperty().bind(scene.widthProperty());
        imageView.fitHeightProperty().bind(scene.heightProperty());

        // Mausevents abfangen
        scene.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                // Wenn die Diashow läuft, beendet Links-Klick sie
                if (slideshowThread != null && slideshowThread.isAlive()) {
                    stopSlideshow();
                } else {
                    // Links-Klick manuell nächstes Bild
                    nextImage();
                }
            } else if (e.getButton() == MouseButton.SECONDARY) {
                // Rechts-Klick startet die Diashow
                if (slideshowThread == null || !slideshowThread.isAlive()) {
                    startSlideshow();
                }
            }
        });

        stage.setTitle("Sideshow App (mouse-left: next, mouse-right:slideshow");
        stage.setScene(scene);
        stage.show();

        // Erstes Bild anzeigen
        showImage(currentIndex);
    }

    //Wechselt zum nächsten Bild. Beim Letzten kommt wieder das erste
    private void nextImage() {
        currentIndex = (currentIndex + 1) % images.size();
        showImage(currentIndex);
    }

    //Zeigt das Bild mit dem gegebenen Index an.
    private void showImage(int index) {
        File file = images.get(index);
        Image img = new Image(file.toURI().toString());
        imageView.setImage(img);
        infoText.setText((index + 1) + " / " + images.size() + "  –  " + file.getName());
    }

    // Startet Thread für die Diashow
    private void startSlideshow() {
        slideshowThread = new SlideshowThread();
        slideshowThread.setDaemon(true); // Verhindert, dass der Thread das Beenden der App blockiert
        slideshowThread.start();
    }

    // Beendet die Diashow über das Flag
    private void stopSlideshow() {
        if (slideshowThread != null) {
            slideshowThread.cancel();
        }
    }

    private class SlideshowThread extends Thread {
        // Abbruch Flag
        private volatile boolean running = true;

        @Override
        public void run() { //
            while (running) {
                try {
                    // 2 Sekunden warten
                    Thread.sleep(2000);

                    // Prüfen, ob während des Schlafens abgebrochen wurde
                    if (!running) {
                        break;
                    }

                    // UI-Änderungen an den JavaFX Application Thread geben
                    Platform.runLater(() -> {
                        if (running) {
                            nextImage();
                        }
                    });

                } catch (InterruptedException e) {
                    // Bei Unterbrechung => Schleife beenden
                    running = false;
                }
            }
        }

        // Setzt das Flag zum Schleife Beenden
        public void cancel() {
            running = false;
            this.interrupt(); // Weckt den Thread auf, falls er gerade im sleep()
        }
    }
}
