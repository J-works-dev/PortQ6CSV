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
import java.util.ArrayList;

public class PortfolioQ6CSV extends Application {
    
    Stage stage;
    Scene scene;
    HBox hBox;
    VBox vBox;
    TableView<RowData> table;
    ObservableList<RowData> results;
    TableColumn<RowData, Integer> col1;
    TableColumn<RowData, Integer> col2;
    TableColumn<RowData, Integer> col3;
    TableColumn<RowData, Integer> col4;
    TableColumn<RowData, Integer> col5;
    TableColumn<RowData, Integer> col6;
    
    @Override
    public void start(Stage stage) {
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
    public void makeTable() {
        switch(CSVHandler.getColumnCount()) {
            case 1:
                col1 = new TableColumn<>(CSVHandler.getTitle()[0]);
                col1.setMinWidth(100);
                col1.setCellValueFactory(new PropertyValueFactory<>("data1"));
                
                table.getColumns().addAll(col1);
                break;
            case 2:
                col1 = new TableColumn<>(CSVHandler.getTitle()[0]);
                col1.setMinWidth(100);
                col1.setCellValueFactory(new PropertyValueFactory<>("data1"));
                col2 = new TableColumn<>(CSVHandler.getTitle()[1]);
                col2.setMinWidth(100);
                col2.setCellValueFactory(new PropertyValueFactory<>("data2"));
                
                table.getColumns().addAll(col1, col2);
                break;
            case 3:
                col1 = new TableColumn<>(CSVHandler.getTitle()[0]);
                col1.setMinWidth(100);
                col1.setCellValueFactory(new PropertyValueFactory<>("data1"));
                col2 = new TableColumn<>(CSVHandler.getTitle()[1]);
                col2.setMinWidth(100);
                col2.setCellValueFactory(new PropertyValueFactory<>("data2"));
                col3 = new TableColumn<>(CSVHandler.getTitle()[2]);
                col3.setMinWidth(100);
                col3.setCellValueFactory(new PropertyValueFactory<>("data3"));
                
                table.getColumns().addAll(col1, col2, col3);
                vBox.getScene().getWindow().sizeToScene();
                break;
            case 4:
                col1 = new TableColumn<>(CSVHandler.getTitle()[0]);
                col1.setMinWidth(100);
                col1.setCellValueFactory(new PropertyValueFactory<>("data1"));
                col2 = new TableColumn<>(CSVHandler.getTitle()[1]);
                col2.setMinWidth(100);
                col2.setCellValueFactory(new PropertyValueFactory<>("data2"));
                col3 = new TableColumn<>(CSVHandler.getTitle()[2]);
                col3.setMinWidth(100);
                col3.setCellValueFactory(new PropertyValueFactory<>("data3"));
                col4 = new TableColumn<>(CSVHandler.getTitle()[3]);
                col4.setMinWidth(100);
                col4.setCellValueFactory(new PropertyValueFactory<>("data4"));
                
                table.getColumns().addAll(col1, col2, col3, col4);
                vBox.getScene().getWindow().sizeToScene();
                break;
            case 5:
                col1 = new TableColumn<>(CSVHandler.getTitle()[0]);
                col1.setMinWidth(100);
                col1.setCellValueFactory(new PropertyValueFactory<>("data1"));
                col2 = new TableColumn<>(CSVHandler.getTitle()[1]);
                col2.setMinWidth(100);
                col2.setCellValueFactory(new PropertyValueFactory<>("data2"));
                col3 = new TableColumn<>(CSVHandler.getTitle()[2]);
                col3.setMinWidth(100);
                col3.setCellValueFactory(new PropertyValueFactory<>("data3"));
                col4 = new TableColumn<>(CSVHandler.getTitle()[3]);
                col4.setMinWidth(100);
                col4.setCellValueFactory(new PropertyValueFactory<>("data4"));
                col5 = new TableColumn<>(CSVHandler.getTitle()[4]);
                col5.setMinWidth(100);
                col5.setCellValueFactory(new PropertyValueFactory<>("data5"));
                
                table.getColumns().addAll(col1, col2, col3, col4, col5);
                vBox.getScene().getWindow().sizeToScene();
                break;
            case 6:
                col1 = new TableColumn<>(CSVHandler.getTitle()[0]);
                col1.setMinWidth(100);
                col1.setCellValueFactory(new PropertyValueFactory<>("data1"));
                col2 = new TableColumn<>(CSVHandler.getTitle()[1]);
                col2.setMinWidth(100);
                col2.setCellValueFactory(new PropertyValueFactory<>("data2"));
                col3 = new TableColumn<>(CSVHandler.getTitle()[2]);
                col3.setMinWidth(100);
                col3.setCellValueFactory(new PropertyValueFactory<>("data3"));
                col4 = new TableColumn<>(CSVHandler.getTitle()[3]);
                col4.setMinWidth(100);
                col4.setCellValueFactory(new PropertyValueFactory<>("data4"));
                col5 = new TableColumn<>(CSVHandler.getTitle()[4]);
                col5.setMinWidth(100);
                col5.setCellValueFactory(new PropertyValueFactory<>("data5"));
                col6 = new TableColumn<>(CSVHandler.getTitle()[5]);
                col6.setMinWidth(100);
                col6.setCellValueFactory(new PropertyValueFactory<>("data6"));
                
                table.getColumns().addAll(col1, col2, col3, col4, col5, col6);
                vBox.getScene().getWindow().sizeToScene();
                break;
        }
        
//        System.out.println("function accessed");
//        System.out.println(CSVHandler.getColumnCount());
//        System.out.println(test[0]);
//        System.out.println(datas[0]);
//        System.out.println(CSVHandler.getTitle()[0]);
////        TableColumn<RowData, String>[] tableColumns = new TableColumn[CSVHandler.getColumnCount()];
//        ArrayList<TableColumn> tableColumns = new ArrayList<TableColumn>();
//        for (int i = 0; i < CSVHandler.getColumnCount(); i++) {
////            String name = CSVHandler.getTitle()[i];            
////            tableColumns[i].add(new TableColumn<>(CSVHandler.getTitle()[i]));
//            TableColumn<RowData, Integer> temp = new TableColumn<>(CSVHandler.getTitle()[i]);
//            temp.setMinWidth(100);
//            temp.setCellValueFactory(new PropertyValueFactory<>(RowData.getData1()));
//            tableColumns.add(temp);
//            RowData.getRowData();
////            tableColumns[i].setMaxWidth(100);
////            tableColumns[i].setCellValueFactory(new PropertyValueFactory<>(RowData.getRowData()[i]));
//            
//        }
//        for (int i = 0; i < CSVHandler.getColumnCount(); i++) {
//            table.getColumns().add(tableColumns.get(i));
//        }
////        TableColumn<RowData, String>[] tableColumns = new TableColumn[4];
////        for (int i = 0; i < 3; i++) {
////            RowData.getRowData();
////            tableColumns[i] = new TableColumn<>(test[i]);
////            tableColumns[i].setMaxWidth(100);
////            tableColumns[i].setCellValueFactory(new PropertyValueFactory<>(RowData.getRowData()[i]));
////            
////        }
////        for (int i = 0; i < 4; i++) {
////            table = new TableView<>();
////            table.getColumns().add(tableColumns[i]);
////        }
////        vBox.getChildren().addAll(table, hBox);
////        scene = new Scene(vBox);
////        stage.setScene(scene);
////        stage.show();
    }
    
    public void deleteButtonClicked() {
        ObservableList<RowData> resultSelected, allResults;
        allResults = table.getItems();
        resultSelected = table.getSelectionModel().getSelectedItems();
        resultSelected.forEach(allResults::remove);
    }

    public void openButtonClicked() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            if (results != null) {
                for (RowData data : results) {
                    data.reset();
                }
            }
            CSVHandler.setColumnCount(0);
            
            results = CSVHandler.readCSV(file);
            makeTable();
            table.setItems(results);
        }
    }

    public void saveButtonClicked() {
        
        results = table.getItems();
        CSVHandler.writeCSV(results);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
