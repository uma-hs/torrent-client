package com.uma.downloader;

import com.turn.ttorrent.client.Client;
import com.uma.downloader.bittorrent.BitTorrentDownload;
import com.uma.downloader.bittorrent.TorrentDownloadInfo;
import com.uma.downloader.bittorrent.TorrentDownloadListener;
import com.uma.downloader.bittorrent.TorrentDownloader;
import com.uma.downloader.commons.Transfer;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by uhs on 18/7/17.
 */

public class TransferManager {

    private volatile static TransferManager INSTANCE;
    private List<BitTorrentDownload> bitTorrentDownloadList = new ArrayList<>();

    private TransferManager(){

    }
    public static TransferManager instance() {
        if(null==INSTANCE){
           INSTANCE = new TransferManager();
        }
        return INSTANCE;
    }

    public void createBitTorrent(String torrentPath, String savePath) throws IOException {
            TorrentDownloadInfo torrentDownloadInfo = new TorrentDownloadInfo();
            torrentDownloadInfo.setTorrentData(Files.readAllBytes(Paths.get(torrentPath)));
            torrentDownloadInfo.setDownloadPath(savePath);
            BitTorrentDownload download = new TorrentDownloader(torrentDownloadInfo, new TorrentDownloadListener() {
                @Override
                public void onUpdate(Client client) {
                    System.out.println(client.getTorrent().getCompletion());
                }
            });
            bitTorrentDownloadList.add(download);
    }
}
