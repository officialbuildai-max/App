package com.transsion.http.impl;

/* loaded from: classes5.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f46013a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f46014b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f46015c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ DownloadCallback f46016d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DownloadCallback downloadCallback, String str, long j11, long j12) {
        this.f46016d = downloadCallback;
        this.f46013a = str;
        this.f46014b = j11;
        this.f46015c = j12;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f46016d.z(this.f46013a, this.f46014b, this.f46015c);
    }
}
