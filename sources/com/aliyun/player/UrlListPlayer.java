package com.aliyun.player;

/* loaded from: classes2.dex */
public interface UrlListPlayer extends IListPlayer, UrlPlayer {
    void addUrl(String str, String str2);

    boolean moveTo(String str);

    boolean moveToNext();

    boolean moveToPrev();
}
