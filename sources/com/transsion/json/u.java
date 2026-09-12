package com.transsion.json;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private a f46157a;

    /* renamed from: b, reason: collision with root package name */
    private int f46158b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f46159c;

    public u(a aVar) {
        this.f46157a = aVar;
    }

    public void a() {
        this.f46158b = Math.max(this.f46158b - 1, 0);
    }

    public void b(String str) {
        this.f46159c = str;
    }

    public a c() {
        return this.f46157a;
    }

    public void d() {
        this.f46158b++;
    }

    public boolean e() {
        return this.f46158b != 0;
    }
}
