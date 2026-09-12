package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes4.dex */
abstract class h {

    /* renamed from: a, reason: collision with root package name */
    b f29525a;

    /* loaded from: classes4.dex */
    protected static class a {

        /* renamed from: a, reason: collision with root package name */
        float f29526a;

        /* renamed from: b, reason: collision with root package name */
        float f29527b;

        /* renamed from: c, reason: collision with root package name */
        int f29528c;

        /* renamed from: d, reason: collision with root package name */
        int f29529d;
    }

    public h(b bVar) {
        this.f29525a = bVar;
    }

    abstract void a(Canvas canvas, Rect rect, float f11, boolean z10, boolean z11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Canvas canvas, Paint paint, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Canvas canvas, Paint paint, a aVar, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Canvas canvas, Paint paint, float f11, float f12, int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas, Rect rect, float f11, boolean z10, boolean z11) {
        this.f29525a.e();
        a(canvas, rect, f11, z10, z11);
    }
}
