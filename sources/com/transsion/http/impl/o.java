package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f46036a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f46037b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Throwable f46038c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ StringCallback f46039d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(StringCallback stringCallback, byte[] bArr, int i11, Throwable th2) {
        this.f46039d = stringCallback;
        this.f46036a = bArr;
        this.f46037b = i11;
        this.f46038c = th2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f46039d.h(new m(this, StringCallback.w(this.f46036a, "UTF-8")));
        } catch (UnsupportedEncodingException e11) {
            this.f46039d.h(new n(this, e11));
        }
    }
}
