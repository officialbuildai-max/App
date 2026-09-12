package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnsupportedEncodingException f46027a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f46028b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar, UnsupportedEncodingException unsupportedEncodingException) {
        this.f46028b = lVar;
        this.f46027a = unsupportedEncodingException;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.f46028b;
        lVar.f46031c.x(lVar.f46030b, null, this.f46027a.getCause());
    }
}
