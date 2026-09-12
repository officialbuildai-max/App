package com.transsion.http.impl;

/* loaded from: classes5.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f46032a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f46033b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(o oVar, String str) {
        this.f46033b = oVar;
        this.f46032a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar = this.f46033b;
        oVar.f46039d.x(oVar.f46037b, this.f46032a, oVar.f46038c);
    }
}
