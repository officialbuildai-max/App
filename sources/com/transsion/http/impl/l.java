package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f46029a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f46030b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ StringCallback f46031c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(StringCallback stringCallback, byte[] bArr, int i11) {
        this.f46031c = stringCallback;
        this.f46029a = bArr;
        this.f46030b = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f46031c.h(new j(this, StringCallback.w(this.f46029a, "UTF-8")));
        } catch (UnsupportedEncodingException e11) {
            this.f46031c.h(new k(this, e11));
        }
    }
}
