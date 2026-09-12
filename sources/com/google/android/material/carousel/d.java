package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private float f28667a;

    /* renamed from: b, reason: collision with root package name */
    private float f28668b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr2[i11] = iArr[i11] * 2;
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f11, float f12, float f13) {
        return 1.0f - ((f11 - f13) / (f12 - f13));
    }

    public float c() {
        return this.f28668b;
    }

    public float d() {
        return this.f28667a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Context context) {
        float f11 = this.f28667a;
        if (f11 <= 0.0f) {
            f11 = e.h(context);
        }
        this.f28667a = f11;
        float f12 = this.f28668b;
        if (f12 <= 0.0f) {
            f12 = e.g(context);
        }
        this.f28668b = f12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract f g(b bVar, View view);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(b bVar, int i11) {
        return false;
    }
}
