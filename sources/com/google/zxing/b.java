package com.google.zxing;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f32904a;

    /* renamed from: b, reason: collision with root package name */
    private id.b f32905b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f32904a = aVar;
    }

    public id.b a() {
        if (this.f32905b == null) {
            this.f32905b = this.f32904a.b();
        }
        return this.f32905b;
    }

    public id.a b(int i11, id.a aVar) {
        return this.f32904a.c(i11, aVar);
    }

    public int c() {
        return this.f32904a.d();
    }

    public int d() {
        return this.f32904a.f();
    }

    public boolean e() {
        return this.f32904a.e().f();
    }

    public b f() {
        return new b(this.f32904a.a(this.f32904a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
