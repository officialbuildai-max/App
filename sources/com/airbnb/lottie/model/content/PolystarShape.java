package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import m4.n;
import q4.b;
import q4.o;
import r4.c;

/* loaded from: classes2.dex */
public class PolystarShape implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f17873a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f17874b;

    /* renamed from: c, reason: collision with root package name */
    private final b f17875c;

    /* renamed from: d, reason: collision with root package name */
    private final o f17876d;

    /* renamed from: e, reason: collision with root package name */
    private final b f17877e;

    /* renamed from: f, reason: collision with root package name */
    private final b f17878f;

    /* renamed from: g, reason: collision with root package name */
    private final b f17879g;

    /* renamed from: h, reason: collision with root package name */
    private final b f17880h;

    /* renamed from: i, reason: collision with root package name */
    private final b f17881i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f17882j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f17883k;

    /* loaded from: classes2.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i11) {
            this.value = i11;
        }

        public static Type forValue(int i11) {
            for (Type type : values()) {
                if (type.value == i11) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, b bVar, o oVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z10, boolean z11) {
        this.f17873a = str;
        this.f17874b = type;
        this.f17875c = bVar;
        this.f17876d = oVar;
        this.f17877e = bVar2;
        this.f17878f = bVar3;
        this.f17879g = bVar4;
        this.f17880h = bVar5;
        this.f17881i = bVar6;
        this.f17882j = z10;
        this.f17883k = z11;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(lottieDrawable, aVar, this);
    }

    public b b() {
        return this.f17878f;
    }

    public b c() {
        return this.f17880h;
    }

    public String d() {
        return this.f17873a;
    }

    public b e() {
        return this.f17879g;
    }

    public b f() {
        return this.f17881i;
    }

    public b g() {
        return this.f17875c;
    }

    public o h() {
        return this.f17876d;
    }

    public b i() {
        return this.f17877e;
    }

    public Type j() {
        return this.f17874b;
    }

    public boolean k() {
        return this.f17882j;
    }

    public boolean l() {
        return this.f17883k;
    }
}
