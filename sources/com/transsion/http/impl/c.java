package com.transsion.http.impl;

/* loaded from: classes5.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f46004a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Throwable f46005b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ BitmapCallback f46006c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BitmapCallback bitmapCallback, int i11, Throwable th2) {
        this.f46006c = bitmapCallback;
        this.f46004a = i11;
        this.f46005b = th2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f46006c.y(this.f46004a, null, this.f46005b);
    }
}
