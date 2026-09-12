package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import m4.u;
import q4.b;
import r4.c;

/* loaded from: classes2.dex */
public class ShapeTrimPath implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f17896a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f17897b;

    /* renamed from: c, reason: collision with root package name */
    private final b f17898c;

    /* renamed from: d, reason: collision with root package name */
    private final b f17899d;

    /* renamed from: e, reason: collision with root package name */
    private final b f17900e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f17901f;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i11) {
            if (i11 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i11 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i11);
        }
    }

    public ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3, boolean z10) {
        this.f17896a = str;
        this.f17897b = type;
        this.f17898c = bVar;
        this.f17899d = bVar2;
        this.f17900e = bVar3;
        this.f17901f = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new u(aVar, this);
    }

    public b b() {
        return this.f17899d;
    }

    public String c() {
        return this.f17896a;
    }

    public b d() {
        return this.f17900e;
    }

    public b e() {
        return this.f17898c;
    }

    public Type f() {
        return this.f17897b;
    }

    public boolean g() {
        return this.f17901f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f17898c + ", end: " + this.f17899d + ", offset: " + this.f17900e + "}";
    }
}
