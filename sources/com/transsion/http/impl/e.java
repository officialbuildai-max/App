package com.transsion.http.impl;

import java.io.File;

/* loaded from: classes5.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f46010a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f46011b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DownloadCallback f46012c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(DownloadCallback downloadCallback, String str, File file) {
        this.f46012c = downloadCallback;
        this.f46010a = str;
        this.f46011b = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f46012c.B(this.f46010a, this.f46011b);
    }
}
