package com.transsion.http.impl;

/* loaded from: classes5.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f46007a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f46008b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DownloadCallback f46009c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DownloadCallback downloadCallback, String str, String str2) {
        this.f46009c = downloadCallback;
        this.f46007a = str;
        this.f46008b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f46009c.x(this.f46007a, this.f46008b);
    }
}
