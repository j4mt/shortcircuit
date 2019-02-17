package com.j4mt.app.web.ui.tests.util.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Filehelper class to verify files exsists ona path
 */
public class FileHelper {

    /**
     * delete file in Dir
     * @param path
     * @param partialFileName
     * @return
     * @throws IOException
     */
    public static boolean delete(String path, String partialFileName) throws IOException {
        boolean isDeleted = false;
        return isDeleted;
    }

    /**
     * check if file exisits by partialor full file name,
     * @param path
     * @param partialFileName
     * @return
     * @throws IOException
     */
    //TODO read path from config no hard code, this will be used mostly for download tests
    public static boolean exists(String path , String partialFileName) throws IOException {
        boolean exists = false;

        File source = new File("C:/path/");
        List<File> files = (List<File>) FileUtils.listFiles(source, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        for (File file : files) {
            // work on the files
            if(file.getName().contains(partialFileName)){
                    exists = true;
                }
        }

        return exists;
    }

    /**
     * this will clean the directory
     * @param path
     * @return
     */
    public static boolean cleanDir(String path) {
        boolean isEmpty = false;
        try {
            File dir = new File(path);
            FileUtils.cleanDirectory(dir);
            if (dir.isDirectory()) {
                if (dir.list().length > 0) {
                    System.out.println("Directory '" + dir.getAbsolutePath() + "' is not empty!");
                    isEmpty = false;
                }else{
                    isEmpty = true;
                }
            }
        }catch (Exception e){
            try {
                FileUtils.forceDelete(new File(path));
            } catch (IOException e1) {}
        }
        return isEmpty;
    }

}
