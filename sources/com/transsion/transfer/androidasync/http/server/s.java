package com.transsion.transfer.androidasync.http.server;

import bv.d;
import com.transsion.transfer.androidasync.a0;

/* loaded from: classes6.dex */
public class s implements cv.a {

    /* renamed from: a, reason: collision with root package name */
    int f55615a = -1;

    /* renamed from: b, reason: collision with root package name */
    private String f55616b;

    /* renamed from: c, reason: collision with root package name */
    com.transsion.transfer.androidasync.p f55617c;

    public s(String str) {
        this.f55616b = str;
    }

    @Override // cv.a
    public void C(com.transsion.transfer.androidasync.http.j jVar, com.transsion.transfer.androidasync.s sVar, bv.a aVar) {
        a0.c(this.f55617c, sVar, aVar);
        if (this.f55617c.isPaused()) {
            this.f55617c.resume();
        }
    }

    @Override // cv.a
    public boolean K() {
        return false;
    }

    @Override // cv.a
    public String j() {
        return this.f55616b;
    }

    @Override // cv.a
    public int length() {
        return this.f55615a;
    }

    @Override // cv.a
    public void r(com.transsion.transfer.androidasync.p pVar, bv.a aVar) {
        this.f55617c = pVar;
        pVar.s(aVar);
        pVar.t(new d.a());
    }
}
