package com.j4mt.app.web.ui.tests.util.excel.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author j4mt
 *
 */
public class ExcelImpl implements ExcelReader,ExcelWriter {

    private  XSSFWorkbook excelBook;
    private  XSSFSheet excelWSheet;
    private  XSSFCell cell;
    private  XSSFRow row;


    @Override
    public List<String> getColumnHeadings() throws IOException {
        ArrayList<String> headings = new ArrayList<String>();
        Iterator<Row> iterator = excelWSheet.iterator();
        iterator.hasNext();
        Row currentRow = iterator.next();
        Iterator<Cell> cellIterator = currentRow.iterator();

        while (cellIterator.hasNext()){
            Cell currentCell = cellIterator.next();
            headings.add(currentCell.getStringCellValue());
        }

        return headings;
    }

    @Override
    public List<String> getColumnHeadingForRow(int row) throws IOException {
        return getRowData(row);
    }

    @Override
    public List<String> getRowData(int row) throws IOException {
        ArrayList<String> rowData = new ArrayList<String>();
        Row currentRow = excelWSheet.getRow(row);
        Iterator<Cell> cellIterator = currentRow.iterator();

        while (cellIterator.hasNext()){
            Cell currentCell = cellIterator.next();
            rowData.add(currentCell.getStringCellValue());
        }

        return rowData;
    }

    @Override
    public String getCellData(int row, int col) throws IOException {

        return excelWSheet.getRow(row).getCell(col).getStringCellValue();

    }

    @Override
    public String getCellData(int row, String columnName) throws IOException {

        Row headerRow = excelWSheet.getRow(0);
        int lastcol = headerRow.getPhysicalNumberOfCells();
        int col;
        for(col=0;col<lastcol;col++){

            if(headerRow.getCell(col).getStringCellValue().equalsIgnoreCase(columnName)){
                break;
            }
        }
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(excelWSheet.getRow(row).getCell(col));
    }

    @Override
    public String getCellData(int row,int columnHeaderRowNum, String columnName) throws IOException {

        Row headerRow = excelWSheet.getRow(columnHeaderRowNum);
        int lastcol = headerRow.getPhysicalNumberOfCells();
        int col;
        for(col=0;col<lastcol;col++){

            if(headerRow.getCell(col).getStringCellValue().equalsIgnoreCase(columnName)){
                break;
            }
        }
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(excelWSheet.getRow(row).getCell(col));
    }

    @Override
    public boolean columnContains(String data, int colNum) throws IOException {
        return false;
    }

    @Override
    public boolean isPresentInRow(int row, int Data) throws IOException {
        return false;
    }

    @Override
    public int getRowsUsed() throws IOException {
        return 0;
    }

    @Override
    public void setCellData(String data, int row, int col) throws Exception {
        throw new Exception("Excel Writer not implemented");
    }

    public XSSFSheet getExcelWSheet() {
        return excelWSheet;
    }

    public void setExcelWSheet(XSSFSheet excelWSheet) {
        this.excelWSheet = excelWSheet;
    }

    public XSSFWorkbook getExcelBook() {
        return excelBook;
    }

    public void setExcelBook(XSSFWorkbook excelBook) {
        this.excelBook = excelBook;
    }

    public XSSFCell getCell() {
        return cell;
    }

    public void setCell(XSSFCell cell) {
        this.cell = cell;
    }

    public XSSFRow getRow() {
        return row;
    }

    public void setRow(XSSFRow row) {
        this.row = row;
    }
}
