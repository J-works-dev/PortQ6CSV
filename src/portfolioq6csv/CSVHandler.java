package portfolioq6csv;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CSVHandler {
    private static int columnCount = 0;
    private static String[] title;
    private static boolean isTitle = true;
    
    public static ObservableList<RowData> readCSV(File fileName) {

        ObservableList<RowData> results = FXCollections.observableArrayList();
        CSVReader reader;
        System.out.println("CSV handler accessed");
        try {
            reader = new CSVReader(new FileReader(fileName));
            String[] nextLine;
            RowData nextResult;
            
            while ((nextLine = reader.readNext()) != null) {
                if (isTitle) {
                    System.out.println(nextLine);
                    setTitle(nextLine);
                    setColumnCount(getTitle().length);
                    isTitle = false;
                } else {
                    System.out.println(nextLine);
                    nextResult = new RowData();
                
                    nextResult.setRowData(nextLine);
                    results.add(nextResult);
                }
            }
            
//            results.remove(0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public static void writeCSV(ObservableList<RowData> results) {

        CSVWriter writer;
        File file = new File("editedData.csv");

        try {
            writer = new CSVWriter(new FileWriter(file));

            writer.writeNext(getTitle());

            for (RowData data : results) {
                String[] nextData = data.getRowData();
                writer.writeNext(nextData);
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getColumnCount() {
        return columnCount;
    }

    public static void setColumnCount(int aColumnCount) {
        columnCount = aColumnCount;
    }

    public static String[] getTitle() {
        return title;
    }

    public static void setTitle(String[] aTitle) {
        title = aTitle;
    }
}
