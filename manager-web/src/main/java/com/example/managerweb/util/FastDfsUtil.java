package com.example.managerweb.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

public class FastDfsUtil {
    public static String[] updata(byte[] file,String extName) {
        TrackerClient client = null;
        TrackerServer connection = null;
        StorageClient storageClient = null;
        try {
            ClientGlobal.init("fastdfs.properties");
            client = new TrackerClient();
            connection = client.getConnection();
            storageClient = new StorageClient(connection,null);
            String[] pngs = storageClient.upload_file(file,extName,null);
            return pngs;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                storageClient=null;
                connection.close();
                client=null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
