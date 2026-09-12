package com.transsion.http.impl;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f46001a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f46002b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ BitmapCallback f46003c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BitmapCallback bitmapCallback, byte[] bArr, int i11) {
        this.f46003c = bitmapCallback;
        this.f46001a = bArr;
        this.f46002b = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap x10;
        x10 = this.f46003c.x(this.f46001a);
        this.f46003c.h(new a(this, x10));
    }
}
