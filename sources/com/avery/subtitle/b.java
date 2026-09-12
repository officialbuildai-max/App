package com.avery.subtitle;

/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public interface a {
        void onSubtitleChanged(k5.b bVar);
    }

    /* renamed from: com.avery.subtitle.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0190b {
        void onRefreshSubtitle();

        void onSubtitlePrepared();
    }

    void destroy();

    void initSubtitle(i5.a aVar, boolean z10);

    void pause();

    void refreshImmediately();

    void reset();

    void resume();

    void selectSubtitle(String str, String str2, i5.b bVar);

    void setDefaultSubtitle(String str);

    void setOnSubtitleChangeListener(a aVar);

    void setOnSubtitlePreparedListener(InterfaceC0190b interfaceC0190b);

    void setSubtitlePath(String str, String str2);

    void start();

    void stop();

    void subtitleDelay(long j11);
}
