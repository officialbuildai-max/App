package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import ba.b;

/* loaded from: classes3.dex */
abstract class m0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof fa.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(b.C0151b c0151b) {
        c0151b.b();
        if (c0151b.e() instanceof Spanned) {
            if (!(c0151b.e() instanceof Spannable)) {
                c0151b.o(SpannableString.valueOf(c0151b.e()));
            }
            g((Spannable) com.google.android.exoplayer2.util.a.e(c0151b.e()), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.ui.k0
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean c11;
                    c11 = m0.c(obj);
                    return c11;
                }
            });
        }
        f(c0151b);
    }

    public static void f(b.C0151b c0151b) {
        c0151b.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (c0151b.e() instanceof Spanned) {
            if (!(c0151b.e() instanceof Spannable)) {
                c0151b.o(SpannableString.valueOf(c0151b.e()));
            }
            g((Spannable) com.google.android.exoplayer2.util.a.e(c0151b.e()), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.ui.l0
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean d11;
                    d11 = m0.d(obj);
                    return d11;
                }
            });
        }
    }

    private static void g(Spannable spannable, com.google.common.base.n nVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (nVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i11, float f11, int i12, int i13) {
        float f12;
        if (f11 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i11 == 0) {
            f12 = i13;
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    return -3.4028235E38f;
                }
                return f11;
            }
            f12 = i12;
        }
        return f11 * f12;
    }
}
