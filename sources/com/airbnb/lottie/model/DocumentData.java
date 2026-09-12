package com.airbnb.lottie.model;

import android.graphics.PointF;

/* loaded from: classes2.dex */
public class DocumentData {

    /* renamed from: a, reason: collision with root package name */
    public String f17852a;

    /* renamed from: b, reason: collision with root package name */
    public String f17853b;

    /* renamed from: c, reason: collision with root package name */
    public float f17854c;

    /* renamed from: d, reason: collision with root package name */
    public Justification f17855d;

    /* renamed from: e, reason: collision with root package name */
    public int f17856e;

    /* renamed from: f, reason: collision with root package name */
    public float f17857f;

    /* renamed from: g, reason: collision with root package name */
    public float f17858g;

    /* renamed from: h, reason: collision with root package name */
    public int f17859h;

    /* renamed from: i, reason: collision with root package name */
    public int f17860i;

    /* renamed from: j, reason: collision with root package name */
    public float f17861j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17862k;

    /* renamed from: l, reason: collision with root package name */
    public PointF f17863l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f17864m;

    /* loaded from: classes2.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData() {
    }

    public DocumentData(String str, String str2, float f11, Justification justification, int i11, float f12, float f13, int i12, int i13, float f14, boolean z10, PointF pointF, PointF pointF2) {
        a(str, str2, f11, justification, i11, f12, f13, i12, i13, f14, z10, pointF, pointF2);
    }

    public void a(String str, String str2, float f11, Justification justification, int i11, float f12, float f13, int i12, int i13, float f14, boolean z10, PointF pointF, PointF pointF2) {
        this.f17852a = str;
        this.f17853b = str2;
        this.f17854c = f11;
        this.f17855d = justification;
        this.f17856e = i11;
        this.f17857f = f12;
        this.f17858g = f13;
        this.f17859h = i12;
        this.f17860i = i13;
        this.f17861j = f14;
        this.f17862k = z10;
        this.f17863l = pointF;
        this.f17864m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f17852a.hashCode() * 31) + this.f17853b.hashCode()) * 31) + this.f17854c)) * 31) + this.f17855d.ordinal()) * 31) + this.f17856e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f17857f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f17859h;
    }
}
