package algo.javaFxGUI;

import algo.sorting.HeapSort;
import algo.sorting.InsertionSort;
import algo.sorting.MergeSort;
import algo.sorting.QuickSort;
import algo.sorting.RadixSort;
import algo.sorting.SelectionSort;
import algo.util.List;
import algo.util.Results;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGuiFile extends Application {

    private StringProperty algorithm = new SimpleStringProperty("Insertion sort");

    //Results
    private StringProperty dataType = new SimpleStringProperty();
    private StringProperty n = new SimpleStringProperty();
    private StringProperty sort = new SimpleStringProperty();
    private StringProperty comparisons = new SimpleStringProperty();
    private StringProperty movements = new SimpleStringProperty();
    private StringProperty time = new SimpleStringProperty();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.add(constructSortButtons(), 0, 0);
        gridPane.add(rightPortion(), 1, 0);
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    VBox constructSortButtons() {

        Button heapSort = new Button("Heap sort");
        Button insertionSort = new Button("Insertion sort");
        Button mergeSort = new Button("Merge sort");
        Button quickSort = new Button("Quick sort");
        Button radisSort = new Button("Radix sort");
        Button selectionSort = new Button("Selection sort");

        heapSort.setOnMouseClicked(e -> setAlgorithm(heapSort.getText()));
        insertionSort.setOnMouseClicked(e -> setAlgorithm(insertionSort.getText()));
        mergeSort.setOnMouseClicked(e -> setAlgorithm(mergeSort.getText()));
        quickSort.setOnMouseClicked(e -> setAlgorithm(quickSort.getText()));
        radisSort.setOnMouseClicked(e -> setAlgorithm(radisSort.getText()));
        selectionSort.setOnMouseClicked(e -> setAlgorithm(selectionSort.getText()));


        VBox vBox = new VBox(heapSort, insertionSort, mergeSort, quickSort, radisSort, selectionSort);
        vBox.setSpacing(0);
        vBox.setPrefHeight(300);

        return vBox;
    }

    Node currentAlgorithm(){
        Label label = new Label("Algorithm :");
        TextField textField = new TextField();
        textField.textProperty().bind(algorithm);
        textField.setEditable(false);

        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 0);
        gridPane.add(textField, 1, 0);

        return gridPane;
    }

    GridPane rightPortion(){
        GridPane gridPane = new GridPane();
        gridPane.add(currentAlgorithm(), 0, 0);
        gridPane.add(selectListProperty(), 0, 1);
        gridPane.add(experimentalResults(), 0, 2);
        return gridPane;
    }

    Node selectListProperty(){
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton inOrder = new RadioButton("inOrder");
        inOrder.setToggleGroup(toggleGroup);
        RadioButton reverseOrder = new RadioButton("ReverseOrder");
        reverseOrder.setToggleGroup(toggleGroup);
        RadioButton almostOrder = new RadioButton("AlmostOrder");
        almostOrder.setToggleGroup(toggleGroup);
        RadioButton random = new RadioButton("Random");
        random.setToggleGroup(toggleGroup);

        VBox vBox = new VBox(inOrder, almostOrder);
        VBox vBox2 = new VBox(reverseOrder, random);

        HBox hBox = new HBox(vBox, vBox2);

        Button create = new Button("Create");
        create.setOnMouseClicked(e -> {
            RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (radioButton != null) {
                String str = radioButton.getText();
                startSorting(str);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.add(hBox, 0, 0);
        gridPane.add(create, 0, 1);

        return gridPane;
    }
    Node experimentalResults(){
        Label nLabel = new Label("N :");
        TextField nText = new TextField();
        nText.textProperty().bind(n);

        Label dataLabel = new Label("DataType :");
        TextField dataField = new TextField();
        dataField.textProperty().bind(dataType);

        Label sortLabel = new Label("Sort :");
        TextField sortField = new TextField();
        sortField.textProperty().bind(sort);

        Label comparisonsLabel = new Label("Comparisons :");
        TextField comparison = new TextField();
        comparison.textProperty().bind(comparisons);

        Label movementsLabel = new Label("Movements: ");
        TextField movementsField = new TextField();
        movementsField.textProperty().bind(movements);

        Label timeLabel = new Label("Total time(millis):");
        TextField timeField = new TextField();
        timeField.textProperty().bind(time);

        GridPane gridPane = new GridPane();
        gridPane.add(nLabel, 0, 0);
        gridPane.add(dataLabel, 0, 1);
        gridPane.add(sortLabel, 0, 2);
        gridPane.add(comparisonsLabel, 0, 3);
        gridPane.add(movementsLabel, 0, 4);
        gridPane.add(timeLabel, 0, 5);
        
        gridPane.add(nText, 1, 0);
        gridPane.add(dataField ,1, 1);
        gridPane.add(sortField, 1, 2);
        gridPane.add(comparison, 1, 3);
        gridPane.add(movementsField, 1, 4);
        gridPane.add(timeField, 1, 5);

        return gridPane;
    }

    void startSorting(String txt){
        setDataType(txt);
        sortNow(txt);
    }

    void sortNow(String txt){
        String algo = algorithm.get();
        int[] list = getList(txt);
        Results results;
        switch (algo) {
            case "Heap sort":
                results = HeapSort.heapSort(list);
                break;
            case "Insertion sort":
                results = InsertionSort.insertionSort(list);
                break;
            case "Merge sort":
                results = MergeSort.mergeSort(list);
                break;
            case "Quick sort":
                results = QuickSort.quickSort(list);
                break;
            case "Radix sort":
                results = RadixSort.radixsort(list);
                break;
            case "Selection sort":
                results = SelectionSort.selectionSort(list);
                break;
            default:
                results = null;
                break;
        }
        n.set("" + results.getN());
        comparisons.set("" + results.getComparisons());
        movements.set("" + results.getMovements());
        time.set("" + results.getDuration());
        sort.set("" + results.getSort());

    }

    int[] getList(String txt){
        switch(txt.toLowerCase()){
            case "inorder":
                return List.getInOrder();
            case "reverseorder":
                return List.getReverseOrder();
            case "almostorder":
                return List.getAlmostOrder();
            case "random":
                return List.getRandomOrder();
            default : return null;
        }
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String type) {
        this.dataType.set(type);
    }

    /**
     * @param algorithm the algorithm to set
     */
    public void setAlgorithm(String list) {
        this.algorithm.set(list);
    }


}
