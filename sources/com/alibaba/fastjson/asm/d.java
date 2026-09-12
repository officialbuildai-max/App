package com.alibaba.fastjson.asm;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    d f18179a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18180b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18181c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18182d;

    public d(c cVar, int i11, String str, String str2) {
        if (cVar.f18175o == null) {
            cVar.f18175o = this;
        } else {
            cVar.f18176p.f18179a = this;
        }
        cVar.f18176p = this;
        this.f18180b = i11;
        this.f18181c = cVar.h(str);
        this.f18182d = cVar.h(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar) {
        aVar.g(this.f18180b & (-393217)).g(this.f18181c).g(this.f18182d);
        aVar.g(0);
    }

    public void c() {
    }
}
