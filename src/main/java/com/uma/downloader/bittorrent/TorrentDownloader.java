package com.uma.downloader.bittorrent;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import com.uma.downloader.commons.TransferState;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by uhs on 17/7/17.
 */
public class TorrentDownloader implements  BitTorrentDownload {

    private TransferState transferState;
    private TorrentDownloadInfo torrentDownloadInfo;
    private Client torrentClient;
    TorrentDownloadListener torrentDownloadListener;

    public TorrentDownloader(TorrentDownloadInfo torrentDownloadInfo, TorrentDownloadListener torrentDownloadListener){
        this.transferState=TransferState.DOWNLOADING_TORRENT;
        this.torrentDownloadListener=torrentDownloadListener;
        this.torrentDownloadInfo=torrentDownloadInfo;
        Thread t= new Thread(new TorrentDownloadRunner());
        //t.setDaemon(true);
        t.start();
    }

    public String getSavePath() {
        return torrentDownloadInfo.getDownloadPath();
    }

    private class TorrentDownloadRunner implements Runnable {

        @Override
        public void run() {

            if(TransferState.CANCELED.equals(transferState)){
                return;
            }
            try {
                torrentClient = new Client(InetAddress.getLocalHost(), new SharedTorrent(torrentDownloadInfo.getTorrentData(), new File(getSavePath())));
                torrentClient.addObserver(new Observer() {
                    @Override
                    public void update(Observable observable, Object o) {
                        Client client = (Client) observable;
                        torrentDownloadListener.onUpdate(client);
                    }
                });
                torrentClient.setMaxDownloadRate(50);
                torrentClient.setMaxUploadRate(50);
                torrentClient.download();
                torrentClient.waitForCompletion();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
    }

}
