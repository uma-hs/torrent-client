package com.uma.downloader.commons;

/**
 * Created by uhs on 17/7/17.
 */

    public enum TransferState {

        FINISHING,
        CHECKING,
        DOWNLOADING_METADATA,
        DOWNLOADING_TORRENT,
        DOWNLOADING,
        FINISHED,
        SEEDING,
        ALLOCATING,
        PAUSED,
        ERROR,
        ERROR_MOVING_INCOMPLETE,
        ERROR_HASH_MD5,
        ERROR_SIGNATURE,
        ERROR_NOT_ENOUGH_PEERS,
        ERROR_NO_INTERNET,
        ERROR_SAVE_DIR,
        ERROR_TEMP_DIR,
        STOPPED,
        PAUSING,
        CANCELING,
        CANCELED,
        WAITING,
        COMPLETE,
        UPLOADING,
        UNCOMPRESSING,
        DEMUXING,
        UNKNOWN,
        ERROR_DISK_FULL,
        REDIRECTING,
        STREAMING,
        SCANNING,
        ERROR_CONNECTION_TIMED_OUT
    }

