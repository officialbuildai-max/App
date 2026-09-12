package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes4.dex */
public class u implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f29323a;

    public u(Rect rect) {
        this.f29323a = rect;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f11, Rect rect, Rect rect2) {
        this.f29323a.set(rect.left + ((int) ((rect2.left - r0) * f11)), rect.top + ((int) ((rect2.top - r1) * f11)), rect.right + ((int) ((rect2.right - r2) * f11)), rect.bottom + ((int) ((rect2.bottom - r6) * f11)));
        return this.f29323a;
    }
}
