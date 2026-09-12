package com.transsion.json;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final Class f46111a;

    /* renamed from: b, reason: collision with root package name */
    private Object f46112b;

    public g(Class cls) {
        this.f46111a = cls;
    }

    public synchronized Object a() {
        try {
            if (this.f46112b == null) {
                this.f46112b = this.f46111a.newInstance();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f46112b;
    }
}
