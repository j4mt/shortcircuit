package com.j4mt.app.web.ui.tests.util.excel;

import com.j4mt.app.web.ui.tests.util.excel.impl.ExcelImpl;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author j4mt
 *
 */
public class ExcelHelper extends ExcelImpl {

    private String filePath;
    private FileInputStream inputStream;


    /**
     *
     * @param filePath
     */
    public ExcelHelper(String filePath)  {
        this.filePath = filePath;

    }

    /**
     *
     * @param sheetNumber
     * @throws IOException
     */
    public void openAndReadExcelFile(int sheetNumber) throws IOException {
        inputStream = new FileInputStream(new File(filePath));
        this.setExcelBook(new XSSFWorkbook(inputStream));
        this.setExcelWSheet(this.getExcelBook().getSheetAt(sheetNumber));

    }

    /**
     *
     * @throws IOException
     */
    public void closeExcelFile() throws IOException {
        this.getExcelBook().close();
        this.inputStream.close();
    }

}
