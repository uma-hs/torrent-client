package com.uma.downloader;

import java.io.IOException;

/**
 * Created by uhs on 18/7/17.
 */
public class MainApplication {
    public static String FILE_FROM="/home/uhs/Desktop/proj/ttorrent/tor/The Lost City of Z (2016) [720p] [YTS.AG].torrent";
    public static String FILE_TO="/home/uhs/Desktop/proj/ttorrent/download";

    public static void main(String args[])  {
        try {
            TransferManager.instance().createBitTorrent(FILE_FROM,FILE_TO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
