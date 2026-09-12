package com.transsion.http.impl;

/* loaded from: classes5.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f46025a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f46026b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(l lVar, String str) {
        this.f46026b = lVar;
        this.f46025a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.f46026b;
        lVar.f46031c.y(lVar.f46030b, this.f46025a);
    }
}
