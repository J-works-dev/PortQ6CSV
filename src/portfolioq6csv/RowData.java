package portfolioq6csv;

public class RowData {
    private static String[] rowData;

    public static String[] getRowData() {
        System.out.println(rowData);
        return rowData;
    }

    public void setRowData(String[] rowData) {
        this.rowData = rowData;
    }
    
}
