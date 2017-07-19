package com.uma.downloader.bittorrent;

/**
 * Created by uhs on 17/7/17.
 */
public class TorrentDownloadInfo {

    enum DownloadFrom {
        URI, MAGNET_URI, TORRENT_FILE
    }

    private byte[] torrentData;
    private DownloadFrom downloadFrom;
    private String URI;
    private String downloadPath;

    public byte[] getTorrentData() {
        return torrentData;
    }

    public void setTorrentData(byte[] torrentData) {
        this.torrentData = torrentData;
    }

    public DownloadFrom getDownloadFrom() {
        return downloadFrom;
    }

    public void setDownloadFrom(DownloadFrom downloadFrom) {
        this.downloadFrom = downloadFrom;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}
