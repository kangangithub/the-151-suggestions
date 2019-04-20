package com.the151suggestions.part8.s116;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 当异常不可避免时,尽量减少异常抛出的几率,提高程序稳定性,性能
 * Created by Akang on 2017/8/25.
 */
public class ReadFile {
    public static void main(String[] args) {
        File file = new File("文件.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /**
         * 优化try{}catch(){},减少抛出FileNotFoundException的几率,提高程序稳定性,性能
         */
        if (file.exists() && file.isFile()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
