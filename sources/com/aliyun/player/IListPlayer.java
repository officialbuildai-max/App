package com.aliyun.player;

/* loaded from: classes2.dex */
public interface IListPlayer extends IPlayer {
    void clear();

    String getCurrentUid();

    int getMaxPreloadMemorySizeMB();

    void removeSource(String str);

    void setMaxPreloadMemorySizeMB(int i11);

    void setPreloadCount(int i11);
}
