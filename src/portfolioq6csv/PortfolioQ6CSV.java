/**
 * Portfolio Question 5
 * SangJoon Lee
 * 30024165
 * 30/04/2021
 */

package portfolioq6csv;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class PortfolioQ6CSV extends Application {
    
    Stage stage;
    Scene scene;
    HBox hBox;
    VBox vBox;
    TableView<RowData> table;
    String[] test = {"t1", "t2", "t3", "t4"};
    String[] datas = {"2323", "3333", "4444", "555"};
    RowData newData = new RowData();
    
    @Override
    public void start(Stage stage) {
        newData.setRowData(datas);
        stage.setTitle("Portfolio Q6 Read & Write CSV");
        table = new TableView<>();
        //buttons
        Button deleteButton = new Button("Delete Row");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        Button openButton = new Button("Open File");
        openButton.setOnAction(e -> openButtonClicked());

        Button saveButton = new Button("Save File");
        saveButton.setOnAction(e -> saveButtonClicked());
        
        //layout
        hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(deleteButton, openButton, saveButton);
        
        vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);
        
        scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
    public void makeWindow() {
        System.out.println("function accessed");
//        TableColumn<RowData, String>[] tableColumns = new TableColumn[CSVHandler.getColumnCount()];
//        for (int i = 0; i < CSVHandler.getColumnCount(); i++) {
//            RowData.getRowData();
//            tableColumns[i] = new TableColumn<>(CSVHandler.getTitle()[i]);
//            tableColumns[i].setMaxWidth(100);
//            tableColumns[i].setCellValueFactory(new PropertyValueFactory<>(RowData.getRowData()[i]));
//            
//        }
//        for (int i = 0; i < CSVHandler.getColumnCount(); i++) {
//            table = new TableView<>();
//            table.getColumns().add(tableColumns[i]);
//        }
        TableColumn<RowData, String>[] tableColumns = new TableColumn[4];
        for (int i = 0; i < 4; i++) {
            RowData.getRowData();
            tableColumns[i] = new TableColumn<>(test[i]);
            tableColumns[i].setMaxWidth(100);
            tableColumns[i].setCellValueFactory(new PropertyValueFactory<>(RowData.getRowData()[i]));
            
        }
        for (int i = 0; i < 4; i++) {
            table = new TableView<>();
            table.getColumns().add(tableColumns[i]);
        }
//        vBox.getChildren().addAll(table, hBox);
//        scene = new Scene(vBox);
//        stage.setScene(scene);
//        stage.show();
    }
    
    public void deleteButtonClicked() {
        ObservableList<RowData> resultSelected, allResults;
        allResults = table.getItems();
        resultSelected = table.getSelectionModel().getSelectedItems();
        resultSelected.forEach(allResults::remove);
    }

    public void openButtonClicked() {
        System.out.println("Open button clicked");
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            table.setItems(CSVHandler.readCSV(file));
            
            makeWindow();
        }
    }

    public void saveButtonClicked() {
        ObservableList<RowData> results;
        results = table.getItems();
        CSVHandler.writeCSV(results);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
