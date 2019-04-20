package com.the151suggestions.part1.s11;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * 序列化反序列化的工具类
 * Created by ankang on 2017-03-26.
 */
@Slf4j
public class SerializationUtils {
    private static String FILE_NAME = "E:\\Git\\The151Suggestions\\src\\main\\java\\com\\the151suggestions\\part1\\s11\\Object.txt";

    //序列化
    public static void writeObject(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (IOException e) {
            log.error("An error occurred when writing the object, the error message is {}", e);
        }
    }

    //反序列化
    public static Object readObject() {
        Object object = null;
        try {
            ObjectInput objectInput = new ObjectInputStream(new FileInputStream(FILE_NAME));
            object = objectInput.readObject();
        } catch (IOException e) {
            log.error("An error occurred when reading the object, the error message is {}", e);
        } catch (ClassNotFoundException e) {
            log.error("An error occurred when finding the object, the error message is {}", e);
        }
        return object;
    }
}
