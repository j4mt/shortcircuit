package com.j4mt.app.web.ui.tests.util.csv;

import com.j4mt.app.web.ui.tests.util.csv.impl.CsvImpl;

import java.io.FileReader;
import java.io.IOException;

public class CsvHelper extends CsvImpl {
    private String filePath;
    private FileReader filereader;


    /**
     *
     * @param filePath
     */
    public CsvHelper(String filePath)  {
        this.filePath = filePath;

    }

    /**
     *
     * @throws IOException
     */
    public void openAndReadCsvFile() throws IOException {
        filereader = new FileReader(filePath);
        this.setCsvFileReader(filereader);

    }

    /**
     *
     * @throws IOException
     */
    public void closeCsvFile() throws IOException {
        this.filereader.close();
    }
}
