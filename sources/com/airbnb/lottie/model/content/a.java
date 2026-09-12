package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
import m4.i;
import q4.b;
import q4.d;
import q4.f;
import r4.c;

/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f17902a;

    /* renamed from: b, reason: collision with root package name */
    private final GradientType f17903b;

    /* renamed from: c, reason: collision with root package name */
    private final q4.c f17904c;

    /* renamed from: d, reason: collision with root package name */
    private final d f17905d;

    /* renamed from: e, reason: collision with root package name */
    private final f f17906e;

    /* renamed from: f, reason: collision with root package name */
    private final f f17907f;

    /* renamed from: g, reason: collision with root package name */
    private final b f17908g;

    /* renamed from: h, reason: collision with root package name */
    private final ShapeStroke.LineCapType f17909h;

    /* renamed from: i, reason: collision with root package name */
    private final ShapeStroke.LineJoinType f17910i;

    /* renamed from: j, reason: collision with root package name */
    private final float f17911j;

    /* renamed from: k, reason: collision with root package name */
    private final List f17912k;

    /* renamed from: l, reason: collision with root package name */
    private final b f17913l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f17914m;

    public a(String str, GradientType gradientType, q4.c cVar, d dVar, f fVar, f fVar2, b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f11, List list, b bVar2, boolean z10) {
        this.f17902a = str;
        this.f17903b = gradientType;
        this.f17904c = cVar;
        this.f17905d = dVar;
        this.f17906e = fVar;
        this.f17907f = fVar2;
        this.f17908g = bVar;
        this.f17909h = lineCapType;
        this.f17910i = lineJoinType;
        this.f17911j = f11;
        this.f17912k = list;
        this.f17913l = bVar2;
        this.f17914m = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new i(lottieDrawable, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f17909h;
    }

    public b c() {
        return this.f17913l;
    }

    public f d() {
        return this.f17907f;
    }

    public q4.c e() {
        return this.f17904c;
    }

    public GradientType f() {
        return this.f17903b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f17910i;
    }

    public List h() {
        return this.f17912k;
    }

    public float i() {
        return this.f17911j;
    }

    public String j() {
        return this.f17902a;
    }

    public d k() {
        return this.f17905d;
    }

    public f l() {
        return this.f17906e;
    }

    public b m() {
        return this.f17908g;
    }

    public boolean n() {
        return this.f17914m;
    }
}
