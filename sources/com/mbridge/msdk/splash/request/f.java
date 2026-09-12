package com.mbridge.msdk.splash.request;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f37635a;

    /* renamed from: b, reason: collision with root package name */
    private String f37636b;

    /* renamed from: c, reason: collision with root package name */
    private int f37637c;

    /* renamed from: d, reason: collision with root package name */
    private int f37638d;

    /* renamed from: e, reason: collision with root package name */
    private int f37639e;

    public int a() {
        return this.f37639e;
    }

    public void a(int i11) {
        this.f37639e = i11;
    }

    public void a(String str) {
        this.f37636b = str;
    }

    public int b() {
        return this.f37638d;
    }

    public void b(int i11) {
        this.f37638d = i11;
    }

    public int c() {
        return this.f37637c;
    }

    public void c(int i11) {
        this.f37637c = i11;
    }

    public int d() {
        return this.f37635a;
    }

    public void d(int i11) {
        this.f37635a = i11;
    }

    public String e() {
        return this.f37636b;
    }

    @NonNull
    public String toString() {
        return "NativeAdvancedV3ParamsEntity{reqType=" + this.f37635a + ", session_id='" + this.f37636b + "', offset=" + this.f37637c + ", expectWidth=" + this.f37638d + ", expectHeight=" + this.f37639e + '}';
    }
}
