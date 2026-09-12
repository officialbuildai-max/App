package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.R$dimen;
import com.google.android.material.carousel.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class e {
    static float a(float f11, float f12, int i11) {
        return f11 + (Math.max(0, i11 - 1) * f12);
    }

    static float b(float f11, float f12, int i11) {
        return i11 > 0 ? f11 + (f12 / 2.0f) : f11;
    }

    static f c(Context context, float f11, float f12, a aVar) {
        float f13;
        float f14;
        float min = Math.min(f(context) + f11, aVar.f28661f);
        float f15 = min / 2.0f;
        float f16 = 0.0f - f15;
        float b11 = b(0.0f, aVar.f28657b, aVar.f28658c);
        float j11 = j(0.0f, a(b11, aVar.f28657b, (int) Math.floor(aVar.f28658c / 2.0f)), aVar.f28657b, aVar.f28658c);
        float b12 = b(j11, aVar.f28660e, aVar.f28659d);
        float j12 = j(j11, a(b12, aVar.f28660e, (int) Math.floor(aVar.f28659d / 2.0f)), aVar.f28660e, aVar.f28659d);
        float b13 = b(j12, aVar.f28661f, aVar.f28662g);
        float j13 = j(j12, a(b13, aVar.f28661f, aVar.f28662g), aVar.f28661f, aVar.f28662g);
        float b14 = b(j13, aVar.f28660e, aVar.f28659d);
        float b15 = b(j(j13, a(b14, aVar.f28660e, (int) Math.ceil(aVar.f28659d / 2.0f)), aVar.f28660e, aVar.f28659d), aVar.f28657b, aVar.f28658c);
        float f17 = f15 + f12;
        float b16 = d.b(min, aVar.f28661f, f11);
        float b17 = d.b(aVar.f28657b, aVar.f28661f, f11);
        float b18 = d.b(aVar.f28660e, aVar.f28661f, f11);
        f.b a11 = new f.b(aVar.f28661f, f12).a(f16, b16, min);
        if (aVar.f28658c > 0) {
            f13 = f17;
            a11.g(b11, b17, aVar.f28657b, (int) Math.floor(r7 / 2.0f));
        } else {
            f13 = f17;
        }
        if (aVar.f28659d > 0) {
            a11.g(b12, b18, aVar.f28660e, (int) Math.floor(r4 / 2.0f));
        }
        a11.h(b13, 0.0f, aVar.f28661f, aVar.f28662g, true);
        if (aVar.f28659d > 0) {
            f14 = 2.0f;
            a11.g(b14, b18, aVar.f28660e, (int) Math.ceil(r4 / 2.0f));
        } else {
            f14 = 2.0f;
        }
        if (aVar.f28658c > 0) {
            a11.g(b15, b17, aVar.f28657b, (int) Math.ceil(r0 / f14));
        }
        a11.a(f13, b16, min);
        return a11.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f d(Context context, float f11, float f12, a aVar, int i11) {
        return i11 == 1 ? c(context, f11, f12, aVar) : e(context, f11, f12, aVar);
    }

    static f e(Context context, float f11, float f12, a aVar) {
        float min = Math.min(f(context) + f11, aVar.f28661f);
        float f13 = min / 2.0f;
        float f14 = 0.0f - f13;
        float b11 = b(0.0f, aVar.f28661f, aVar.f28662g);
        float j11 = j(0.0f, a(b11, aVar.f28661f, aVar.f28662g), aVar.f28661f, aVar.f28662g);
        float b12 = b(j11, aVar.f28660e, aVar.f28659d);
        float b13 = b(j(j11, b12, aVar.f28660e, aVar.f28659d), aVar.f28657b, aVar.f28658c);
        float f15 = f13 + f12;
        float b14 = d.b(min, aVar.f28661f, f11);
        float b15 = d.b(aVar.f28657b, aVar.f28661f, f11);
        float b16 = d.b(aVar.f28660e, aVar.f28661f, f11);
        f.b h11 = new f.b(aVar.f28661f, f12).a(f14, b14, min).h(b11, 0.0f, aVar.f28661f, aVar.f28662g, true);
        if (aVar.f28659d > 0) {
            h11.b(b12, b16, aVar.f28660e);
        }
        int i11 = aVar.f28658c;
        if (i11 > 0) {
            h11.g(b13, b15, aVar.f28657b, i11);
        }
        h11.a(f15, b14, min);
        return h11.i();
    }

    static float f(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_gone_size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_max);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float h(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_min);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int[] iArr) {
        int i11 = Integer.MIN_VALUE;
        for (int i12 : iArr) {
            if (i12 > i11) {
                i11 = i12;
            }
        }
        return i11;
    }

    static float j(float f11, float f12, float f13, int i11) {
        return i11 > 0 ? f12 + (f13 / 2.0f) : f11;
    }
}
