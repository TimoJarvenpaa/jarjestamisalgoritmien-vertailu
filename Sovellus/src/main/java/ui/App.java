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
        HBox options = new HBox(250);
        VBox arrayOptions = new VBox(5);
        VBox repeatOptions = new VBox(5);

        // Järjestettävän taulukon pituuden valinta
        ToggleGroup arrayLength = new ToggleGroup();
        Text arrayTitle = new Text("Array length");

        RadioButton rb1 = new RadioButton("100");
        rb1.setUserData("100");
        rb1.setToggleGroup(arrayLength);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("1000");
        rb2.setUserData("1000");
        rb2.setToggleGroup(arrayLength);

        RadioButton rb3 = new RadioButton("10 000");
        rb3.setUserData("10000");
        rb3.setToggleGroup(arrayLength);
        
        arrayOptions.getChildren().addAll(arrayTitle, rb1, rb2, rb3);
        
        // Taulukon järjestämiskertojen lukumäärän valinta
        ToggleGroup repeats = new ToggleGroup();
        Text repeatsTitle = new Text("Repeats");
        
        RadioButton rb4 = new RadioButton("1");
        rb4.setUserData("1");
        rb4.setToggleGroup(repeats);
        rb4.setSelected(true);

        RadioButton rb5 = new RadioButton("10");
        rb5.setUserData("10");
        rb5.setToggleGroup(repeats);

        RadioButton rb6 = new RadioButton("100");
        rb6.setUserData("100");
        rb6.setToggleGroup(repeats);

        repeatOptions.getChildren().addAll(repeatsTitle, rb4, rb5, rb6);
        
        options.getChildren().addAll(arrayOptions, repeatOptions);
        
        Button button = new Button("Compare");

        // Järjestämisalgoritmien valinta
        CheckBox ins, bub, mer, qui;

        ins = new CheckBox("Insertion");
        bub = new CheckBox("Bubble");
        mer = new CheckBox("Merge");
        qui = new CheckBox("Quick (Median-of-three)");

        TextArea ta = new TextArea();

        layout.getChildren().addAll(options, ins, bub, mer, qui, ta, button);

        Scene scene = new Scene(layout);

        // Vertailunapin tapahtumankäsittelijä
        button.setOnAction(event -> {

            ta.clear();
            
            int selectedLength = Integer.parseInt(arrayLength.getSelectedToggle().getUserData().toString());
            RandomArrayGenerator r = new RandomArrayGenerator(selectedLength);
            
            int selectedRepeats = Integer.parseInt(repeats.getSelectedToggle().getUserData().toString());

            int[] arrayToSort = r.getRandomArray();

            if (ins.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort insertion = new InsertionSort(copiedArray, selectedRepeats);
                ta.appendText("Insertion sort: " + insertion.getAverageTime() + " ns\n");
            }

            if (bub.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort bubble = new BubbleSort(copiedArray, selectedRepeats);
                ta.appendText("Bubble sort: " + bubble.getAverageTime() + " ns\n");
            }
            
            if (mer.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort merge = new MergeSort(copiedArray, selectedRepeats);
                ta.appendText("Merge sort: " + merge.getAverageTime() + " ns\n");
            }
            
            if (qui.isSelected()) {
                int[] copiedArray = new int[arrayToSort.length];
                System.arraycopy(arrayToSort, 0, copiedArray, 0, arrayToSort.length);
                Sort quick = new QuickSort(copiedArray, selectedRepeats);
                ta.appendText("Quick sort: " + quick.getAverageTime() + " ns\n");
            }

        });

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(App.class);
    }

}
