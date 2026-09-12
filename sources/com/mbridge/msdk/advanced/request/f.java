package com.mbridge.msdk.advanced.request;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f34262a;

    /* renamed from: b, reason: collision with root package name */
    private String f34263b;

    /* renamed from: c, reason: collision with root package name */
    private int f34264c;

    /* renamed from: d, reason: collision with root package name */
    private int f34265d;

    /* renamed from: e, reason: collision with root package name */
    private int f34266e;

    public int a() {
        return this.f34266e;
    }

    public void a(int i11) {
        this.f34266e = i11;
    }

    public void a(String str) {
        this.f34263b = str;
    }

    public int b() {
        return this.f34265d;
    }

    public void b(int i11) {
        this.f34265d = i11;
    }

    public int c() {
        return this.f34264c;
    }

    public void c(int i11) {
        this.f34264c = i11;
    }

    public int d() {
        return this.f34262a;
    }

    public void d(int i11) {
        this.f34262a = i11;
    }

    public String e() {
        return this.f34263b;
    }

    @NonNull
    public String toString() {
        return "NativeAdvancedV3ParamsEntity{reqType=" + this.f34262a + ", session_id='" + this.f34263b + "', offset=" + this.f34264c + ", expectWidth=" + this.f34265d + ", expectHeight=" + this.f34266e + '}';
    }
}
