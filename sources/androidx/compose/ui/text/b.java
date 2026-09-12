package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.d;
import androidx.compose.ui.text.style.e;
import androidx.compose.ui.text.style.h;
import k0.e1;

/* loaded from: classes.dex */
public abstract class b {
    public static final /* synthetic */ CharSequence a(CharSequence charSequence) {
        return i(charSequence);
    }

    public static final /* synthetic */ int b(e1 e1Var, int i11) {
        return j(e1Var, i11);
    }

    public static final /* synthetic */ boolean c(d0 d0Var, boolean z10) {
        return k(d0Var, z10);
    }

    public static final /* synthetic */ int d(int i11) {
        return l(i11);
    }

    public static final /* synthetic */ int e(int i11) {
        return m(i11);
    }

    public static final /* synthetic */ int f(int i11) {
        return n(i11);
    }

    public static final /* synthetic */ int g(int i11) {
        return o(i11);
    }

    public static final /* synthetic */ int h(int i11) {
        return p(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence i(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.u(spannableString, new l0.c(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(e1 e1Var, int i11) {
        int l11 = e1Var.l();
        for (int i12 = 0; i12 < l11; i12++) {
            if (e1Var.k(i12) > i11) {
                return i12;
            }
        }
        return e1Var.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(d0 d0Var, boolean z10) {
        if (!z10 || o0.w.e(d0Var.q(), o0.x.c(0)) || o0.w.e(d0Var.q(), o0.w.f70751b.a())) {
            return false;
        }
        int z11 = d0Var.z();
        h.a aVar = androidx.compose.ui.text.style.h.f6475b;
        return (androidx.compose.ui.text.style.h.k(z11, aVar.g()) || androidx.compose.ui.text.style.h.k(d0Var.z(), aVar.f()) || androidx.compose.ui.text.style.h.k(d0Var.z(), aVar.c())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(int i11) {
        h.a aVar = androidx.compose.ui.text.style.h.f6475b;
        if (androidx.compose.ui.text.style.h.k(i11, aVar.d())) {
            return 3;
        }
        if (androidx.compose.ui.text.style.h.k(i11, aVar.e())) {
            return 4;
        }
        if (androidx.compose.ui.text.style.h.k(i11, aVar.a())) {
            return 2;
        }
        return (!androidx.compose.ui.text.style.h.k(i11, aVar.f()) && androidx.compose.ui.text.style.h.k(i11, aVar.b())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(int i11) {
        e.b.a aVar = e.b.f6446a;
        if (e.b.e(i11, aVar.c())) {
            return 0;
        }
        if (e.b.e(i11, aVar.b())) {
            return 1;
        }
        return e.b.e(i11, aVar.a()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(int i11) {
        d.a aVar = androidx.compose.ui.text.style.d.f6437a;
        if (androidx.compose.ui.text.style.d.e(i11, aVar.a())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        androidx.compose.ui.text.style.d.e(i11, aVar.b());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(int i11) {
        e.c.a aVar = e.c.f6451a;
        if (e.c.f(i11, aVar.a())) {
            return 0;
        }
        if (e.c.f(i11, aVar.b())) {
            return 1;
        }
        if (e.c.f(i11, aVar.c())) {
            return 2;
        }
        return e.c.f(i11, aVar.d()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int i11) {
        e.d.a aVar = e.d.f6457a;
        return (!e.d.d(i11, aVar.a()) && e.d.d(i11, aVar.b())) ? 1 : 0;
    }
}
