package com.uma.downloader.bittorrent;

import com.turn.ttorrent.client.Client;

/**
 * Created by uhs on 19/7/17.
 */
public interface TorrentDownloadListener {
    public void onUpdate(Client client);
}
