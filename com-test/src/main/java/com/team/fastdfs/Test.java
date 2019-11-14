package com.team.fastdfs;


import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;


public class Test {
    public static void main(String[] args) {
        try {
            ClientGlobal.init("fastdfs.properties");
            TrackerClient client = new TrackerClient();
            TrackerServer connection = client.getConnection();
            StorageClient storageClient = new StorageClient(connection,null);
            String[] pngs = storageClient.upload_file("G:\\jar\\16.png", "png", null);
            storageClient=null;
            connection.close();
            client=null;
            System.out.println("成功");
            for (String png : pngs) {
                System.out.println(png);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
