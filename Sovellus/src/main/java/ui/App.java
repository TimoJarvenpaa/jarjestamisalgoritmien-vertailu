package ui;

import domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.RandomArrayGenerator;

/**
 * Sovelluksen graafisesta käyttöliittymästä vastaava luokka.
 */
public class App extends Application {

    @Override
    public void start(Stage window) {
        VBox layout = new VBox(5);
        HBox options = new HBox(50);
        VBox arrayOptions = new VBox(5);
        VBox repeatOptions = new VBox(5);
        VBox rangeOptions = new VBox(5);
        VBox timeOptions = new VBox(5);

        layout.setStyle("-fx-padding: 10 30 20 30;"); //top, right, bottom, left
        options.setStyle("-fx-padding: 0 0 20 0;");

        // Järjestettävän taulukon pituuden valinta
        ToggleGroup arrayLength = new ToggleGroup();
        Text arrayTitle = new Text("Array length");

        RadioButton rb1 = createRadioButton("100", arrayLength, "100", true);
        RadioButton rb2 = createRadioButton("1000", arrayLength, "1000", false);
        RadioButton rb3 = createRadioButton("10 000", arrayLength, "10000", false);
        RadioButton rb11 = createRadioButton("100 000", arrayLength, "100000", false);

        arrayOptions.getChildren().addAll(arrayTitle, rb1, rb2, rb3, rb11);

        // Taulukon järjestämiskertojen lukumäärän valinta
        ToggleGroup repeats = new ToggleGroup();
        Text repeatsTitle = new Text("Repeats");

        RadioButton rb4 = createRadioButton("1", repeats, "1", true);
        RadioButton rb5 = createRadioButton("10", repeats, "10", false);
        RadioButton rb6 = createRadioButton("100", repeats, "100", false);

        repeatOptions.getChildren().addAll(repeatsTitle, rb4, rb5, rb6);

        // Taulukon lukujen arvovälin valinta
        ToggleGroup range = new ToggleGroup();
        Text rangeTitle = new Text("Number range");

        RadioButton rb7 = createRadioButton("1-10", range, "10", true);
        RadioButton rb8 = createRadioButton("1-100", range, "100", false);
        RadioButton rb9 = createRadioButton("1-1000", range, "1000", false);
        RadioButton rb10 = createRadioButton("1-10000", range, "10000", false);

        rangeOptions.getChildren().addAll(rangeTitle, rb7, rb8, rb9, rb10);

        // Mittaustulosten esitysmuodon valinta
        ToggleGroup timeFormat = new ToggleGroup();
        Text timeTitle = new Text("Time format");

        RadioButton rb12 = createRadioButton("ns", timeFormat, "ns", true);
        RadioButton rb13 = createRadioButton("ms", timeFormat, "ms", false);
        RadioButton rb14 = createRadioButton("s", timeFormat, "s", false);

        timeOptions.getChildren().addAll(timeTitle, rb12, rb13, rb14);

        options.getChildren().addAll(arrayOptions, repeatOptions, rangeOptions, timeOptions);

        Button button = new Button("Compare");

        // Järjestämisalgoritmien valinta
        CheckBox ins, bub, mer, qui, cou, rad, hea, intr;

        ins = new CheckBox("Insertion");
        bub = new CheckBox("Bubble");
        mer = new CheckBox("Merge");
        qui = new CheckBox("Quick (Median-of-three)");
        cou = new CheckBox("Counting");
        rad = new CheckBox("Radix");
        hea = new CheckBox("Heap");
        intr = new CheckBox("Intro");

        TextArea ta = new TextArea();

        layout.getChildren().addAll(options, ins, bub, mer, qui, cou, rad, hea, intr, ta, button);

        Scene scene = new Scene(layout);

        // Vertailunapin tapahtumankäsittelijä
        button.setOnAction(event -> {

            ta.clear();

            int selectedLength = Integer.parseInt(arrayLength.getSelectedToggle().getUserData().toString());
            RandomArrayGenerator r = new RandomArrayGenerator(selectedLength);

            int selectedRepeats = Integer.parseInt(repeats.getSelectedToggle().getUserData().toString());
            int selectedRange = Integer.parseInt(range.getSelectedToggle().getUserData().toString());
            String selectedTime = timeFormat.getSelectedToggle().getUserData().toString();

            int[] arrayToSort = r.getRandomArray(selectedRange);

            if (ins.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort insertion = new InsertionSort(copiedArray, selectedRepeats);
                ta.appendText("Insertion sort: " + timeFormat(insertion.getMedianTime(), selectedTime));
            }

            if (bub.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort bubble = new BubbleSort(copiedArray, selectedRepeats);
                ta.appendText("Bubble sort: " + timeFormat(bubble.getMedianTime(), selectedTime));
            }

            if (mer.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort merge = new MergeSort(copiedArray, selectedRepeats);
                ta.appendText("Merge sort: " + timeFormat(merge.getMedianTime(), selectedTime));
            }

            if (qui.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort quick = new QuickSort(copiedArray, selectedRepeats);
                ta.appendText("Quick sort: " + timeFormat(quick.getMedianTime(), selectedTime));
            }

            if (cou.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort count = new CountingSort(copiedArray, selectedRepeats);
                ta.appendText("Counting sort: " + timeFormat(count.getMedianTime(), selectedTime));
            }

            if (rad.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort radix = new RadixSort(copiedArray, selectedRepeats);
                ta.appendText("Radix sort: " + timeFormat(radix.getMedianTime(), selectedTime));
            }

            if (hea.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort heap = new HeapSort(copiedArray, selectedRepeats);
                ta.appendText("Heap sort: " + timeFormat(heap.getMedianTime(), selectedTime));
            }

            if (intr.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort intro = new IntroSort(copiedArray, selectedRepeats);
                ta.appendText("Intro sort: " + timeFormat(intro.getMedianTime(), selectedTime));
            }

        });

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(App.class);
    }

    /**
     * Apumetodi radiopainikkeiden luomiseen.
     *
     * @param buttonText painikkeen teksti
     * @param toggleGroup painikkeen kategoria
     * @param userData painikkeen välittämä tieto
     * @param selected onko painike oletusarvoisesti valittuna
     * @return
     */
    private RadioButton createRadioButton(String buttonText, ToggleGroup toggleGroup, String userData, boolean selected) {
        RadioButton button = new RadioButton();
        button.setText(buttonText);
        button.setToggleGroup(toggleGroup);
        button.setUserData(userData);
        if (selected) {
            button.setSelected(true);
        }
        return button;
    }

    /**
     * Apumetodi, jonka avulla mittaustulosten esitystapa voidaan tulostaa
     * valitun vaihtoehdon perusteella.
     *
     * @param time mittaustulos nanosekunteina
     * @param selectedTimeFormat valittu ajan esitysmuoto (ns, ms, s)
     * @return mittaustuloksen merkkijonoesitys
     */
    private String timeFormat(long time, String selectedTimeFormat) {
        if (selectedTimeFormat.equals("ns")) {
            return "" + time + " ns\n";
        }
        if (selectedTimeFormat.equals("ms")) {
            double milliseconds = time / 1000000.0;
            return "" + milliseconds + " ms\n";
        } else {
            double seconds = time / 1000000000.0;
            return "" + seconds + " s\n";
        }
    }

}
