package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f17845a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17846b;

    /* renamed from: c, reason: collision with root package name */
    private final String f17847c;

    /* renamed from: d, reason: collision with root package name */
    private final String f17848d;

    /* renamed from: e, reason: collision with root package name */
    private final String f17849e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f17850f;

    public l0(int i11, int i12, String str, String str2, String str3) {
        this.f17845a = i11;
        this.f17846b = i12;
        this.f17847c = str;
        this.f17848d = str2;
        this.f17849e = str3;
    }

    public l0 a(float f11) {
        l0 l0Var = new l0((int) (this.f17845a * f11), (int) (this.f17846b * f11), this.f17847c, this.f17848d, this.f17849e);
        Bitmap bitmap = this.f17850f;
        if (bitmap != null) {
            l0Var.g(Bitmap.createScaledBitmap(bitmap, l0Var.f17845a, l0Var.f17846b, true));
        }
        return l0Var;
    }

    public Bitmap b() {
        return this.f17850f;
    }

    public String c() {
        return this.f17848d;
    }

    public int d() {
        return this.f17846b;
    }

    public String e() {
        return this.f17847c;
    }

    public int f() {
        return this.f17845a;
    }

    public void g(Bitmap bitmap) {
        this.f17850f = bitmap;
    }
}
