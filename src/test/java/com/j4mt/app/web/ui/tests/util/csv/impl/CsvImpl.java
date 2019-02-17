package com.j4mt.app.web.ui.tests.util.csv.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CsvImpl implements CsvFileReader {

    private FileReader filereader;

    @Override
    public List<String> getColumnHeadings() throws IOException {

        CSVReader csvReader = new CSVReaderBuilder(filereader).build();
        List<String[]> allData = csvReader.readAll();

        return  Arrays.asList(allData.get(0));
    }

    @Override
    public List<String> getRowData(int row) throws IOException {
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();
        List<String[]> allData = csvReader.readAll();

        return  Arrays.asList(allData.get(row));
    }

    @Override
    public String getCellData(int row, int col) throws IOException {

        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();
        List<String[]> allData = csvReader.readAll();

        return Arrays.asList(allData.get(row)).get(col);
    }

    @Override
    public String getCellData(int row, String columnName) throws IOException {

        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .build();
        List<String[]> allData = csvReader.readAll();

        List<String> allColumns = Arrays.asList(allData.get(0));
        int colnum=0;
        for(colnum=0;colnum<allColumns.size();colnum++){
            if(allColumns.get(colnum).equalsIgnoreCase(columnName)){
                break;
            }
        }

        return Arrays.asList(allData.get(row+1)).get(colnum);
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

    public FileReader getCsvFileReader() {
        return filereader;
    }

    public void setCsvFileReader(FileReader filereader) {
        this.filereader = filereader;
    }
}
