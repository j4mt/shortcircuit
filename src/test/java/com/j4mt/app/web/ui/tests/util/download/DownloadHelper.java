package com.j4mt.app.web.ui.tests.util.download;

import java.io.File;

/**
 * @author j4mt
 */
public class DownloadHelper {

    public static String downloadedFilePath;

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();
        fileName = fileName.replace(" ", "_");
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName))
                downloadedFilePath = dir_contents[i].getAbsolutePath();
                return flag=true;
        }

        return flag;
    }
}
