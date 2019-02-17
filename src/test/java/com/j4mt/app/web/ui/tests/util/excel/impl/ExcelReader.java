package com.j4mt.app.web.ui.tests.util.excel.impl;


import java.io.IOException;
import java.util.List;

/**
 * @author j4mt
 */
public interface ExcelReader {

    List<String> getColumnHeadings() throws IOException;
    List<String> getColumnHeadingForRow(int row) throws IOException;
    List<String> getRowData(int row) throws IOException;
    String getCellData(int row, int col) throws IOException;

    String getCellData(int row, String columnName) throws IOException;

    String getCellData(int row, int columnHeaderRowNum, String columnName) throws IOException;
    boolean columnContains(String data, int colNum) throws IOException;
    boolean isPresentInRow(int row, int Data) throws IOException;
    int getRowsUsed() throws IOException;

}
