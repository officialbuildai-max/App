package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnsupportedEncodingException f46034a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f46035b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar, UnsupportedEncodingException unsupportedEncodingException) {
        this.f46035b = oVar;
        this.f46034a = unsupportedEncodingException;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar = this.f46035b;
        oVar.f46039d.x(oVar.f46037b, null, this.f46034a.getCause());
    }
}
