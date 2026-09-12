package com.transsion.http.impl;

import android.graphics.Bitmap;

/* loaded from: classes5.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f45999a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f46000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, Bitmap bitmap) {
        this.f46000b = bVar;
        this.f45999a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = this.f46000b;
        bVar.f46003c.z(bVar.f46002b, this.f45999a);
    }
}
