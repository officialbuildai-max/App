package androidx.media3.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import u1.a;

/* loaded from: classes2.dex */
abstract class x0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof u1.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(a.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) androidx.media3.common.util.a.e(bVar.e()), new com.google.common.base.n() { // from class: androidx.media3.ui.v0
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean c11;
                    c11 = x0.c(obj);
                    return c11;
                }
            });
        }
        f(bVar);
    }

    public static void f(a.b bVar) {
        bVar.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) androidx.media3.common.util.a.e(bVar.e()), new com.google.common.base.n() { // from class: androidx.media3.ui.w0
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean d11;
                    d11 = x0.d(obj);
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
